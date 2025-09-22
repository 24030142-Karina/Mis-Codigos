
package com.mycompany.patronstrategy;

// Contexto que utiliza la estrategia
public class ProcesadorPagos {
    private MetodoPago estrategiaPago;
    private double monto;
    
    public ProcesadorPagos(double monto) {
        this.monto = monto;
    }
    
    public void setEstrategiaPago(MetodoPago estrategia) {
        this.estrategiaPago = estrategia;
    }
    
    public boolean ejecutarPago() {
        if (estrategiaPago == null) {
            System.out.println("Error: No se ha seleccionado método de pago");
            return false;
        }
        
        System.out.println("=== Iniciando pago ===");
        System.out.println("Método: " + estrategiaPago.obtenerTipo());
        System.out.println("Monto: $" + monto);
        
        boolean resultado = estrategiaPago.procesarPago(monto);
        
        if (resultado) {
            System.out.println("✅ Pago exitoso!");
        } else {
            System.out.println("❌ Pago fallido");
        }
        
        return resultado;
    }
}
