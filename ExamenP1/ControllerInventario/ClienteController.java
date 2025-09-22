package ControllerInventario;

import Model.Cliente;
import Views.ClienteView;
import model.Repositorio;
import java.util.Scanner;
import java.util.function.Predicate;

public class ClienteController {
    private Repositorio<Cliente> repositorioClientes;
    private ClienteView view;
    private Scanner scanner;

    public ClienteController(Repositorio<Cliente> repositorioClientes, Scanner scanner) {
        this.repositorioClientes = repositorioClientes;
        this.view = new ClienteView();
        this.scanner = scanner;
    }

    public void menuClientes() {
        boolean volver = false;
        
        while (!volver) {
            view.mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: agregarCliente(); break;
                case 2: modificarCliente(); break;
                case 3: eliminarCliente(); break;
                case 4: listarClientes(); break;
                case 5: buscarCliente(); break;
                case 6: volver = true; break;
                default: view.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void agregarCliente() {
        if (repositorioClientes.tamaño() >= 50) {
            view.mostrarMensaje("No se pueden agregar más clientes. Límite alcanzado.");
            return;
        }

        view.mostrarMensaje("\n--- AGREGAR NUEVO CLIENTE ---");
        
        String nombre = view.solicitarDato("Nombre: ", scanner);
        String email = view.solicitarDato("Email: ", scanner);
        String telefono = view.solicitarDato("Teléfono: ", scanner);
        double saldo = Double.parseDouble(view.solicitarDato("Saldo inicial: ", scanner));
        
        Cliente cliente = new Cliente(nombre, email, telefono, saldo);
        if (repositorioClientes.agregar(cliente)) {
            view.mostrarMensaje("Cliente agregado con éxito.");
        } else {
            view.mostrarMensaje("Error al agregar cliente.");
        }
    }

    private void modificarCliente() {
        view.mostrarMensaje("\n--- MODIFICAR CLIENTE ---");
        int indice = Integer.parseInt(view.solicitarDato("Ingrese el número de cliente a modificar (1-" + repositorioClientes.tamaño() + "): ", scanner)) - 1;
        
        if (indice < 0 || indice >= repositorioClientes.tamaño()) {
            view.mostrarMensaje("Número de cliente no válido.");
            return;
        }
        
        Cliente cliente = repositorioClientes.obtener(indice);
        view.mostrarMensaje("Cliente encontrado: " + cliente.getNombre());
        view.mostrarMensaje("Ingrese los nuevos datos (deje en blanco para mantener el valor actual):");
        
        String nombre = view.solicitarDato("Nombre [" + cliente.getNombre() + "]: ", scanner);
        if (!nombre.isEmpty()) {
            cliente.setNombre(nombre);
        }
        
        String email = view.solicitarDato("Email [" + cliente.getEmail() + "]: ", scanner);
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }
        
        String telefono = view.solicitarDato("Teléfono [" + cliente.getTelefono() + "]: ", scanner);
        if (!telefono.isEmpty()) {
            cliente.setTelefono(telefono);
        }
        
        String saldoStr = view.solicitarDato("Saldo [" + cliente.getSaldo() + "]: ", scanner);
        if (!saldoStr.isEmpty()) {
            cliente.setSaldo(Double.parseDouble(saldoStr));
        }
        
        repositorioClientes.modificar(indice, cliente);
        view.mostrarMensaje("Cliente modificado con éxito.");
    }

    private void eliminarCliente() {
        view.mostrarMensaje("\n--- ELIMINAR CLIENTE ---");
        int indice = Integer.parseInt(view.solicitarDato("Ingrese el número de cliente a eliminar (1-" + repositorioClientes.tamaño() + "): ", scanner)) - 1;
        
        if (indice < 0 || indice >= repositorioClientes.tamaño()) {
            view.mostrarMensaje("Número de cliente no válido.");
            return;
        }
        
        Cliente cliente = repositorioClientes.obtener(indice);
        view.mostrarMensaje("Cliente encontrado: " + cliente.getNombre());
        String confirmacion = view.solicitarDato("¿Está seguro que desea eliminar este cliente? (S/N): ", scanner);
        
        if (confirmacion.equalsIgnoreCase("S")) {
            if (repositorioClientes.eliminar(indice)) {
                view.mostrarMensaje("Cliente eliminado con éxito.");
            }
        } else {
            view.mostrarMensaje("Operación cancelada.");
        }
    }

    private void listarClientes() {
        view.mostrarClientes(repositorioClientes.obtenerTodos());
    }

    private void buscarCliente() {
        view.mostrarMensaje("\n--- BUSCAR CLIENTE ---");
        view.mostrarMensaje("1. Buscar por Nombre");
        view.mostrarMensaje("2. Buscar por Email");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                String nombre = view.solicitarDato("Ingrese el nombre a buscar: ", scanner).toLowerCase();
                Predicate<Cliente> porNombre = c -> c.getNombre().toLowerCase().contains(nombre);
                mostrarResultadosBusqueda(repositorioClientes.buscar(porNombre));
                break;
                
            case 2:
                String email = view.solicitarDato("Ingrese el email a buscar: ", scanner).toLowerCase();
                Predicate<Cliente> porEmail = c -> c.getEmail().toLowerCase().contains(email);
                mostrarResultadosBusqueda(repositorioClientes.buscar(porEmail));
                break;
                
            default:
                view.mostrarMensaje("Opción no válida.");
        }
    }

    private void mostrarResultadosBusqueda(java.util.List<Cliente> resultados) {
        if (resultados.isEmpty()) {
            view.mostrarMensaje("No se encontraron clientes.");
        } else {
            view.mostrarClientes(resultados);
        }
    }
}
