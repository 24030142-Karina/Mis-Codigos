package controllerInventario;

import Model.Productos;
import model.Repositorio;
import java.util.Scanner;
import java.util.function.Predicate;
import views.ProductoView;

public class ProductoController {
    private Repositorio<Productos> repositorioProductos;
    private ProductoView view;
    private Scanner scanner;

    public ProductoController(Repositorio<Productos> repositorioProductos, Scanner scanner) {
        this.repositorioProductos = repositorioProductos;
        this.view = new ProductoView();
        this.scanner = scanner;
    }

    public void menuProductos() {
        boolean volver = false;
        
        while (!volver) {
            view.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: agregarProducto(); break;
                case 2: modificarProducto(); break;
                case 3: eliminarProducto(); break;
                case 4: listarProductos(); break;
                case 5: buscarProducto(); break;
                case 6: volver = true; break;
                default: view.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void agregarProducto() {
        if (repositorioProductos.tamaño() >= 100) {
            view.mostrarMensaje("No se pueden agregar más productos. Límite alcanzado.");
            return;
        }

        view.mostrarMensaje("\n--- AGREGAR NUEVO PRODUCTO ---");
        
        String codigo = view.solicitarDato("Código: ", scanner);
        
        // Verificar si el código ya existe
        for (int i = 0; i < repositorioProductos.tamaño(); i++) {
            if (repositorioProductos.obtener(i).getCodigo().equals(codigo)) {
                view.mostrarMensaje("Error: El código ya existe. No se puede agregar el producto.");
                return;
            }
        }
        
        String nombre = view.solicitarDato("Nombre: ", scanner);
        double precio = Double.parseDouble(view.solicitarDato("Precio: ", scanner));
        int cantidad = Integer.parseInt(view.solicitarDato("Cantidad: ", scanner));
        String categoria = view.solicitarDato("Categoría: ", scanner);
        String fechaVencimiento = view.solicitarDato("Fecha de Vencimiento (DD/MM/YYYY) o N/A: ", scanner);
        
        Productos producto = new Productos(codigo, nombre, precio, cantidad, categoria, fechaVencimiento);
        if (repositorioProductos.agregar(producto)) {
            view.mostrarMensaje("Producto agregado con éxito.");
        } else {
            view.mostrarMensaje("Error al agregar producto.");
        }
    }

    private void modificarProducto() {
        view.mostrarMensaje("\n--- MODIFICAR PRODUCTO ---");
        String codigo = view.solicitarDato("Ingrese el código del producto a modificar: ", scanner);
        
        int indice = -1;
        for (int i = 0; i < repositorioProductos.tamaño(); i++) {
            if (repositorioProductos.obtener(i).getCodigo().equals(codigo)) {
                indice = i;
                break;
            }
        }
        
        if (indice == -1) {
            view.mostrarMensaje("Producto no encontrado.");
            return;
        }
        
        Productos producto = repositorioProductos.obtener(indice);
        view.mostrarMensaje("Producto encontrado: " + producto.getNombre());
        view.mostrarMensaje("Ingrese los nuevos datos (deje en blanco para mantener el valor actual):");
        
        String nombre = view.solicitarDato("Nombre [" + producto.getNombre() + "]: ", scanner);
        if (!nombre.isEmpty()) {
            producto.setNombre(nombre);
        }
        
        String precioStr = view.solicitarDato("Precio [" + producto.getPrecio() + "]: ", scanner);
        if (!precioStr.isEmpty()) {
            producto.setPrecio(Double.parseDouble(precioStr));
        }
        
        String cantidadStr = view.solicitarDato("Cantidad [" + producto.getCantidad() + "]: ", scanner);
        if (!cantidadStr.isEmpty()) {
            producto.setCantidad(Integer.parseInt(cantidadStr));
        }
        
        String categoria = view.solicitarDato("Categoría [" + producto.getCategoria() + "]: ", scanner);
        if (!categoria.isEmpty()) {
            producto.setCategoria(categoria);
        }
        
        String fechaVencimiento = view.solicitarDato("Fecha de Vencimiento [" + producto.getFechaVencimiento() + "]: ", scanner);
        if (!fechaVencimiento.isEmpty()) {
            producto.setFechaVencimiento(fechaVencimiento);
        }
        
        repositorioProductos.modificar(indice, producto);
        view.mostrarMensaje("Producto modificado con éxito.");
    }

    private void eliminarProducto() {
        view.mostrarMensaje("\n--- ELIMINAR PRODUCTO ---");
        String codigo = view.solicitarDato("Ingrese el código del producto a eliminar: ", scanner);
        
        int indice = -1;
        for (int i = 0; i < repositorioProductos.tamaño(); i++) {
            if (repositorioProductos.obtener(i).getCodigo().equals(codigo)) {
                indice = i;
                break;
            }
        }
        
        if (indice == -1) {
            view.mostrarMensaje("Producto no encontrado.");
            return;
        }
        
        Productos producto = repositorioProductos.obtener(indice);
        view.mostrarMensaje("Producto encontrado: " + producto.getNombre());
        String confirmacion = view.solicitarDato("¿Está seguro que desea eliminar este producto? (S/N): ", scanner);
        
        if (confirmacion.equalsIgnoreCase("S")) {
            if (repositorioProductos.eliminar(indice)) {
                view.mostrarMensaje("Producto eliminado con éxito.");
            }
        } else {
            view.mostrarMensaje("Operación cancelada.");
        }
    }

    private void listarProductos() {
        view.mostrarProductos(repositorioProductos.obtenerTodos());
    }

    private void buscarProducto() {
        view.mostrarMensaje("\n--- BUSCAR PRODUCTO ---");
        view.mostrarMensaje("1. Buscar por Código");
        view.mostrarMensaje("2. Buscar por Nombre");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                String codigo = view.solicitarDato("Ingrese el código a buscar: ", scanner);
                Predicate<Productos> porCodigo = p -> p.getCodigo().equals(codigo);
                mostrarResultadosBusqueda(repositorioProductos.buscar(porCodigo));
                break;
                
            case 2:
                String nombre = view.solicitarDato("Ingrese el nombre a buscar: ", scanner).toLowerCase();
                Predicate<Productos> porNombre = p -> p.getNombre().toLowerCase().contains(nombre);
                mostrarResultadosBusqueda(repositorioProductos.buscar(porNombre));
                break;
                
            default:
                view.mostrarMensaje("Opción no válida.");
        }
    }

    private void mostrarResultadosBusqueda(java.util.List<Productos> resultados) {
        if (resultados.isEmpty()) {
            view.mostrarMensaje("No se encontraron productos.");
        } else {
            view.mostrarProductos(resultados);
        }
    }
}
