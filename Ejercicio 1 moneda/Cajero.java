
package com.mycompany.moneda;


public class Cajero {
    private double cantidad;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public double Cambio(){
        double cantidadRest = cantidad;
        
        if (cantidadRest == 0) {
            return 0;
        }
        
        int[] denominaciones = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        String[] nombres = {"Billetes de 1000", "Billetes de 500", "Billetes de 200", 
                           "Billetes de 100", "Billetes de 50", "Billetes de 20",
                           "Monedas de 10", "Monedas de 5", "Monedas de 2", "Monedas de 1"};
        
        System.out.println("\nDesglose para " + cantidad + "€:");
        
        for (int i = 0; i < denominaciones.length; i++) {
            if (cantidadRest >= denominaciones[i]) {
                int cantidadDenominacion = (int)(cantidadRest / denominaciones[i]);
                cantidadRest %= denominaciones[i];
                
                if (cantidadDenominacion > 0) {
                    System.out.println(nombres[i] + ": " + cantidadDenominacion);
                }
            }
        }
        
        System.out.println("Cantidad restante no convertible: " + cantidadRest + "Euros");
        return cantidadRest;
    }
}

