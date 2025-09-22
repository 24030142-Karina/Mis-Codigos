
package Views;

import Model.Cliente;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
    
    public void mostrarMenu() {
        System.out.println("\n----- GESTIÓN DE CLIENTES -----");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Modificar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Buscar Cliente");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        System.out.println("ID\tNombre\t\t\tEmail\t\t\tTeléfono\tSaldo");
        System.out.println("--------------------------------------------------------------------------------");
        
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.printf("%-3d %s\n", (i + 1), clientes.get(i).toString());
            }
        }
    }

    public void mostrarDetalleCliente(Cliente cliente, int indice) {
        System.out.println("\nDetalle del Cliente:");
        System.out.println("ID: " + (indice + 1));
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Saldo: $" + cliente.getSaldo());
    }

    public String solicitarDato(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
