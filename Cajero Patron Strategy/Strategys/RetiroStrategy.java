
package Strategys;

import Model.CajeroModel;
import Views.CajeroView;

/**
 * Strategy para la operación de retiro
 * @author Karina Ramirez
 */
public class RetiroStrategy implements OperacionStrategy {
    private CajeroModel model;
    private CajeroView view;
    
    public RetiroStrategy(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public boolean ejecutar() {
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return false;
        }
        
        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Retiro exitoso de " + cantidad);
            return true;
        } else {
            view.mostrarMensaje("Fondos insuficientes");
            return false;
        }
    }
}