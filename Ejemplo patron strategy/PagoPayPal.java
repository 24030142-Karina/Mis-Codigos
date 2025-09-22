
package com.mycompany.patronstrategy;

// Estrategia para PayPal
public class PagoPayPal implements MetodoPago {
    private String email;
    
    public PagoPayPal(String email) {
        this.email = email;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal: $" + monto);
        System.out.println("Email: " + email);
        return validarCuenta() && realizarTransferencia(monto);
    }
    
    @Override
    public String obtenerTipo() {
        return "PayPal";
    }
    
    private boolean validarCuenta() {
        return email != null && email.contains("@");
    }
    
    private boolean realizarTransferencia(double monto) {
        return monto <= 10000;
    }
}
