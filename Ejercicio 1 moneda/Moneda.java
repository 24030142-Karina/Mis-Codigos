
package com.mycompany.moneda;

import java.util.Scanner;
public class Moneda {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Cajero cajero1= new Cajero();
        System.out.println("Ingresa los euros a transformar");
        System.out.println("Nota: Deben ser enteros positivos");
        System.out.println("Ingresa 0 para terminar");
        while(true){
            int cantidad=leer.nextInt();
            if (cantidad==0){
                System.out.println("Nos vemos");
                break;
            }
            
            if (cantidad < 0) {
                System.out.println("La cantidad debe ser positiva");
                continue;
            }
            cajero1.setCantidad(cantidad);
            cajero1.Cambio();
            System.out.println(cantidad);
            
            
            System.out.println("Cantidad ingresada: "+cantidad+"Euros");
            System.out.println("Cambio: "+cantidad);
        }
    }
    
}

    

