
package Strategys;

import Model.CajeroModel;
import Views.CajeroView;

/**
 * Strategy para la operación de transferencia
 * @author Karina Ramirez
 */
public class TransferenciaStrategy implements OperacionStrategy {
    private CajeroModel model;
    private CajeroView view;
    
    public TransferenciaStrategy(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public boolean ejecutar() {
        String cuentaDestino = view.solicitarCuentaDestino();
        double cantidad = view.solicitarCantidad("Transferir");
        
        if (cantidad <= 0) {
            view.mostrarMensaje("Cantidad Erronea, vuelve a intentarlo");
            return false;
        }
        if (!model.cuentaExistente(cuentaDestino)) {
            view.mostrarErrorCuentaNoExistente();
            return false;
        }
        if (model.getCuentaActual().getNumeroCuenta().equals(cuentaDestino)) {
            view.mostrarErrorMismaCuenta();
            return false;
        }
        if (model.realizarTransferencia(cuentaDestino, cantidad)) {
            view.mostrarTransferenciaExitosa(cantidad, cuentaDestino);
            return true;
        } else {
            view.mostrarErrorSaldoInsuficiente();
            return false;
        }
    }
}
