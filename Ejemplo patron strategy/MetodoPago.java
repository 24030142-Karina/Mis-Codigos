
package com.mycompany.patronstrategy;


// Estrategia de pago
public interface MetodoPago {
    boolean procesarPago(double monto);
    String obtenerTipo();
}
