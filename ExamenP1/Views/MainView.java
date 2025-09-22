
package Views;


public class MainView {
    
    public void mostrarMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE INVENTARIO =====");
        System.out.println("1. Gestionar Productos");
        System.out.println("2. Gestionar Clientes");
        System.out.println("5. Guardar y Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
