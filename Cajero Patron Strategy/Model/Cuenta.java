
package Model;

/**
 * Se ah transformado la clase "cuenta" a programacion generica
 * @author Karina Ramirez
 */
public class Cuenta<T extends Number> {
    private String numeroCuenta;
    private String pin;
    private T saldo;
    private String titular;

    /**
     * Constructor de la clase Cuenta con programacion generica
     * @param numeroCuenta es el numero de identificacion de la cuenta
     * @param pin es el PIN de seguridad de la cuenta
     * @param saldoInicial parametro para el saldo inicial de la cuenta ya sea double, int, float
     * @param titular Nombre del titular de la cuenta
     * @author Karina Ramirez
     */
    public Cuenta(String numeroCuenta, String pin, T saldoInicial, String titular){
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }
    
    public String getNumeroCuenta() {return numeroCuenta;}
    public String getPin() {return pin;}
    public T getSaldo() {return saldo;}
    public String getTitular() {return titular;}
    
    /**
     * Establece el saldo de la cuenta
     * @param saldo es el parametro para el saldo nuevo saldo de la cuenta
     * @author Karina Ramirez
     */
    public void setSaldo(T saldo){
        this.saldo = saldo;
    }

    /**
     * Valida si el PIN ingresado coincide con el PIN de la cuenta.
     * @param pinIngresado es el Pin que se tiene que validar
     * @return true si el PIN es correcto, false si el PIN es incorrecto
     * @author Karina Ramirez
     */
    public boolean validarPin(String pinIngresado){
        return this.pin.equals(pinIngresado);
    }

    /**
     * Realiza un retiro de la cuenta si hay saldo suficiente
     * @param cantidad Cantidad de dinero a retirar
     * @return true si el retiro fue exitoso, false si no hay saldo suficiente
     * @author Karina Ramirez
     */
    public boolean retirar(double cantidad){
        if( cantidad > 0 && cantidad <= this.saldo.doubleValue() ){
            double nuevoSaldo = this.saldo.doubleValue() - cantidad;
            this.saldo = convertirSaldo(nuevoSaldo);
            return true;
        }
        return false;
    }

    /**
     * Realiza un deposito a la cuenta del usuario
     * @param cantidad Cantidad de dinero que se va a depositar
     * @author Karina Ramirez
     */
    public void depositar(double cantidad){
        if(cantidad > 0){
            double nuevoSaldo = this.saldo.doubleValue() + cantidad;
            this.saldo = convertirSaldo(nuevoSaldo);
        }
    }

    /**
     * Realiza una transferencia de la cuenta del usuario a otra
     * @param cuentaDestino Cual es la cuenta a la que se le va a transferir
     * @param cantidad Cantidad de dinero que se va a transferir
     * @return true si la transferencia fue exitosa, false si la operacion fue fallida
     * @author Karina Ramirez
     */
    public boolean transferir(Cuenta<T> cuentaDestino, double cantidad){
        if (cantidad <= 0 || cuentaDestino == null || this == cuentaDestino){
            return false;
        }
        if(retirar(cantidad)){
            cuentaDestino.depositar(cantidad);
            return true;
        }
        return false;
    }

    /**
     * Convierte un valor double al tipo generico T
     * @param valor parametro del valor double a convertir
     * @return valor convertido al tipo T
     * @author Karina Ramirez
     */
    @SuppressWarnings("unchecked")
    private T convertirSaldo(double valor){
        // CORREGIDO: instanceof con clases, no con primitivos
        if(saldo instanceof Double){
            return (T) Double.valueOf(valor);
        } else if (saldo instanceof Integer){
            return (T) Integer.valueOf((int) valor);
        } else if (saldo instanceof Float){
            return (T) Float.valueOf((float)valor);
        } else if (saldo instanceof Long){
            return (T) Long.valueOf((long)valor);
        } else{
            return (T) Double.valueOf(valor);
        }
    }

    /**
     * Representacion en String de la cuenta
     * @return String informacion de la cuenta
     * @author Karina Ramirez
     */
    @Override
    public String toString(){
        return "Cuenta{"+
                "numeroCuenta='"+ numeroCuenta + "'" +
                ", Saldo="+saldo+
                ", titular='"+titular + "'" +
                ", tipo="+saldo.getClass().getSimpleName()+
                "}";
    }
}