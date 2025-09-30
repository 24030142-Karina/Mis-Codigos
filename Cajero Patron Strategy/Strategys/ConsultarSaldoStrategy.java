
package Strategys;

import Model.CajeroModel;
import Views.CajeroView;

/**
 * Strategy para la operación de consultar saldo
 * @author Karina Ramirez
 */
public class ConsultarSaldoStrategy implements OperacionStrategy {
    private CajeroModel model;
    private CajeroView view;
    
    public ConsultarSaldoStrategy(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public boolean ejecutar() {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
        return true; // Siempre exitosa
    }
}
