
package Controllers;

import Model.CajeroModel;
import Views.CajeroView;
import Strategys.*;

public class CajeroController {
    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;
    
    // Patrón Strategy
    private OperacionStrategy estrategiaActual;

    public CajeroController(CajeroModel model, CajeroView view){
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema(){
        view.mostrarBienvenida();
        while (sistemaActivo){
            if( autenticarUsuario() ){
                ejecutarMenuPrincipal();
            }else{
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    
    private boolean autenticarUsuario(){
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta,pin);
    }

    /**
     * Método principal para elegir la opción que se desea ejecutar con patrón Strategy
     * @author Karina Ramirez
     */
    private void ejecutarMenuPrincipal(){
        boolean sessionActiva = true;
        while (sessionActiva){
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            
            // Configurar la estrategia según la opción seleccionada
            configurarEstrategia(opcion);
            
            switch (opcion){
                case 1:
                case 2:
                case 3:
                case 4:
                    ejecutarEstrategia();
                    break;
                case 5:
                    sessionActiva = false;
                    view.mostrarMensaje("Sesion cerrada");
                    break;
                default:
                    view.mostrarErrorOpcionInvalida();
                    break;
            }
        }
    }

    /**
     * Configura la estrategia según la opción del menú
     * @param opcion Opción seleccionada por el usuario
     */
    private void configurarEstrategia(int opcion) {
        switch (opcion) {
            case 1:
                estrategiaActual = new ConsultarSaldoStrategy(model, view);
                break;
            case 2:
                estrategiaActual = new RetiroStrategy(model, view);
                break;
            case 3:
                estrategiaActual = new DepositoStrategy(model, view);
                break;
            case 4:
                estrategiaActual = new TransferenciaStrategy(model, view);
                break;
            default:
                estrategiaActual = null;
                break;
        }
    }

    /**
     * Ejecuta la estrategia actual si está configurada
     */
    private void ejecutarEstrategia() {
        if (estrategiaActual != null) {
            view.mostrarCargando();
            estrategiaActual.ejecutar();
        }
    }

    public void consultarSaldo(){
        configurarEstrategia(1);
        ejecutarEstrategia();
    }
    
    public void realizarRetiro(){
        configurarEstrategia(2);
        ejecutarEstrategia();
    }

    public void realizarDeposito(){
        configurarEstrategia(3);
        ejecutarEstrategia();
    }
    
    public void realizarTransferencia(){
        configurarEstrategia(4);
        ejecutarEstrategia();
    }
}