

package com.mycompany.patronstrategy;

/**
 *  Ejemplo práctico para comprender el funcionamiento de Strategy
 * 
 * @author karin
 */

/* 
EJEMPLO:
Tenemos un sistema que necesita procesar 
diferentes tipos de pago (tarjeta, PayPal, criptomonedas) 
de manera flexible.
*/
public class PatronStrategy {

    public static void main(String[] args) {
        // Crear procesador de pagos
        ProcesadorPagos procesador = new ProcesadorPagos(150.50);
        
        System.out.println("=== PROCESADOR DE PAGOS ===\n");
        
        // Probar diferentes estrategias
        System.out.println("1. PAGO CON TARJETA:");
        MetodoPago tarjeta = new PagoTarjeta("1234567812345678", "123");
        procesador.setEstrategiaPago(tarjeta);
        procesador.ejecutarPago();
        
        System.out.println("\n2. PAGO CON PAYPAL:");
        MetodoPago paypal = new PagoPayPal("cliente@ejemplo.com");
        procesador.setEstrategiaPago(paypal);
        procesador.ejecutarPago();
        
        System.out.println("\n3. PAGO CON CRIPTO:");
        MetodoPago cripto = new PagoCripto("0x1a2b3c4d5e6f7890");
        procesador.setEstrategiaPago(cripto);
        procesador.ejecutarPago();
    }
}
