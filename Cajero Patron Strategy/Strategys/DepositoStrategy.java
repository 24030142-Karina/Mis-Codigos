
package Strategys;

import Model.CajeroModel;
import Views.CajeroView;

/**
 * Strategy para la operación de depósito
 * @author Karina Ramirez
 */
public class DepositoStrategy implements OperacionStrategy {
    private CajeroModel model;
    private CajeroView view;
    
    public DepositoStrategy(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public boolean ejecutar() {
        double cantidad = view.solicitarCantidad("Deposito");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return false;
        }
        
        if (model.realizarDeposito(cantidad)) {
            view.mostrarMensaje("Deposito exitoso por la cantidad " + cantidad);
            return true;
        } else {
            view.mostrarMensaje("Error al procesar el deposito");
            return false;
        }
    }
}