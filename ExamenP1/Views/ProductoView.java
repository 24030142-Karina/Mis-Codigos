package views;

import Model.Productos;
import java.util.List;
import java.util.Scanner;

public class ProductoView {
    
    public void mostrarMenu() {
        System.out.println("\n----- GESTIÓN DE PRODUCTOS -----");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Modificar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Listar Productos");
        System.out.println("5. Buscar Producto");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarProductos(List<Productos> productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        System.out.println("Código\tNombre\t\t\tPrecio\tCantidad\tCategoría\tVencimiento");
        System.out.println("--------------------------------------------------------------------------------");
        
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Productos producto : productos) {
                System.out.println(producto.toString());
            }
        }
    }

    public void mostrarDetalleProducto(Productos producto) {
        System.out.println("\nDetalle del Producto:");
        System.out.println("Código: " + producto.getCodigo());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Cantidad en stock: " + producto.getCantidad());
        System.out.println("Categoría: " + producto.getCategoria());
        System.out.println("Fecha de Vencimiento: " + producto.getFechaVencimiento());
    }

    public String solicitarDato(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
