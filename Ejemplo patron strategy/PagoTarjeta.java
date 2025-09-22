
package com.mycompany.patronstrategy;

// Estrategia para tarjeta de crédito
public class PagoTarjeta implements MetodoPago {
    private String numeroTarjeta;
    private String cvv;
    
    public PagoTarjeta(String numeroTarjeta, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con tarjeta: $" + monto);
        return validarTarjeta() && autorizarPago(monto);
    }
    
    @Override
    public String obtenerTipo() {
        return "Tarjeta de Crédito";
    }
    
    private boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.length() == 16;
    }
    
    private boolean autorizarPago(double monto) {
        return monto > 0;
    }
}