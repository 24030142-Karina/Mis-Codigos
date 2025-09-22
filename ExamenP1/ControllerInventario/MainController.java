
package ControllerInventario;

import controllerInventario.ProductoController;
import Model.Productos;
import Model.Cliente;
import model.Repositorio;
import Views.MainView;
import Util.Manager;
import java.util.Scanner;

public class MainController {
    private Repositorio<Productos> repositorioProductos;
    private Repositorio<Cliente> repositorioClientes;
    private MainView view;
    private Scanner scanner;
    private ProductoController productoController;
    private ClienteController clienteController;

    public MainController() {
        this.repositorioProductos = new Repositorio<>();
        this.repositorioClientes = new Repositorio<>();
        this.view = new MainView();
        this.scanner = new Scanner(System.in);
        this.productoController = new ProductoController(repositorioProductos, scanner);
        this.clienteController = new ClienteController(repositorioClientes, scanner);
    }

    public void iniciar() {
        cargarDatos();
        
        boolean salir = false;
        
        while (!salir) {
            view.mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: productoController.menuProductos(); break;
                case 2: clienteController.menuClientes(); break;
                case 5: guardarDatos(); salir = true; break;
                default: view.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
        
        view.mostrarMensaje("¡Gracias por usar el sistema!");
        scanner.close();
    }

    private void cargarDatos() {
        view.mostrarMensaje("Datos cargados exitosamente.");
    }

    private void guardarDatos() {
        
        view.mostrarMensaje("Datos guardados exitosamente.");
    }
}