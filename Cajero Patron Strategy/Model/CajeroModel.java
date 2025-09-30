
package Model;

import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas; 
    private Cuenta cuentaActual; 
    
    public CajeroModel(){
        cuentas = new HashMap<>();
        inicializarCuentas();
    }
    
    private void inicializarCuentas(){
        
        cuentas.put("12345",
                new Cuenta<Double>("12345", "1111", 500000.80, "Juan N"));
        cuentas.put("54321", 
                new Cuenta<Integer>("54321", "0000", 4522, "Maria Guadalupe N"));
    }

    public boolean autenticar(String numeroCuenta, String pin){
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if( cuenta != null && cuenta.validarPin(pin) ){
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }
    
    public Cuenta getCuentaActual(){
        return this.cuentaActual;
    }
    
    public double consultarSaldo(){
        return this.cuentaActual != null ? cuentaActual.getSaldo().doubleValue() : 0;
    }
    
    public boolean realizarRetiro(double cantidad){
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    public boolean realizarDeposito(double cantidad){
        if(cuentaActual != null && cantidad > 0){
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }
    
    public boolean cuentaExistente(String numeroCuenta){
        return cuentas.containsKey(numeroCuenta);
    }

    /**
     * Realiza una transferencia de cuenta a cuenta
     * numeroCuentaDestino número de la cuenta donde se transferira el dinero
     * cantidad Cantidad de dinero a transferir
     * true si la operacion fue exitosa, false si la operacion no se pudo completar
     */
    public boolean realizarTransferencia(String numeroCuentaDestino, double cantidad){
        if (cuentaActual == null || cantidad <= 0){
            return false;
        }
        if (cuentaActual.getNumeroCuenta().equals(numeroCuentaDestino)){
            return false;
        }
        Cuenta cuentaDestino = cuentas.get(numeroCuentaDestino);
        if (cuentaDestino == null){
            return false;
        }
        
        return cuentaActual.transferir(cuentaDestino, cantidad);
    }
}