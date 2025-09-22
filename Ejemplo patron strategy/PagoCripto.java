
package com.mycompany.patronstrategy;

// Estrategia para criptomonedas
public class PagoCripto implements MetodoPago {
    private String direccionWallet;
    
    public PagoCripto(String direccionWallet) {
        this.direccionWallet = direccionWallet;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con cripto: $" + monto);
        System.out.println("Wallet: " + direccionWallet);
        return validarWallet() && confirmarTransaccion(monto);
    }
    
    @Override
    public String obtenerTipo() {
        return "Criptomoneda";
    }
    
    private boolean validarWallet() {
        return direccionWallet != null && direccionWallet.startsWith("0x");
    }
    
    private boolean confirmarTransaccion(double monto) {
        return monto > 0.001;
    }
}
