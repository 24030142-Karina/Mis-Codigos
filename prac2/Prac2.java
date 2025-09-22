
package com.mycompany.prac2;


public class Prac2 {

    public static void main(String[] args) {
        System.out.println("PROGRAMACIÓN GENÉRICA");
        
        
        System.out.println("\n1. Contenedor Genérico:");
        Contenedor<String> contenedorString = new Contenedor<>("Hola Mundo");
        Contenedor<Integer> contenedorInteger = new Contenedor<>(42);
        
        contenedorString.mostrarTipo();
        contenedorInteger.mostrarTipo();
        
        
        System.out.println("\n2. Par Genérico:");
        Par<String, Integer> par = new Par<>("Edad", 25);
        System.out.println(par);
        
        
        System.out.println("\n3. Operación Genérica:");
        Operacion<Integer> sumaEnteros = (a, b) -> a + b;
        Operacion<String> concatenar = (a, b) -> a + b;
        
        System.out.println("Suma: " + sumaEnteros.ejecutar(5, 3));
        System.out.println("Concatenación: " + concatenar.ejecutar("Hola", " Mundo"));
        
        
        System.out.println("\n4. Calculadora con Restricciones:");
        Calculadora<Double> calcDouble = new Calculadora<>();
        Calculadora<Integer> calcInteger = new Calculadora<>();
        
        System.out.println("Suma Double: " + calcDouble.sumar(5.5, 3.2));
        System.out.println("Multiplicación Integer: " + calcInteger.multiplicar(4, 5));
        
        
        System.out.println("\n5. Métodos Genéricos:");
        Integer[] enteros = {1, 5, 3, 8, 2};
        String[] strings = {"manzana", "naranja", "plátano"};
        
        System.out.print("Array de enteros: ");
        Utilidades.imprimirArray(enteros);
        System.out.print("Array de strings: ");
        Utilidades.imprimirArray(strings);
        
        System.out.println("Máximo entero: " + Utilidades.encontrarMaximo(enteros));
        System.out.println("Máximo string: " + Utilidades.encontrarMaximo(strings));
        
        
        System.out.println("\n6. Wildcards:");
        List<Integer> listaEnteros = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> listaDoubles = Arrays.asList(1.1, 2.2, 3.3);
        List<String> listaStrings = Arrays.asList("a", "b", "c");
        
        System.out.print("Lista enteros: ");
        ProcesadorListas.imprimirLista(listaEnteros);
        System.out.print("Lista strings: ");
        ProcesadorListas.imprimirLista(listaStrings);
        
        System.out.println("Suma números enteros: " + ProcesadorListas.sumarNumeros(listaEnteros));
        System.out.println("Suma números doubles: " + ProcesadorListas.sumarNumeros(listaDoubles));
        
        
        System.out.println("\n7. Colecciones Genéricas:");
        Map<String, List<Integer>> mapaEstudiantes = new HashMap<>();
        mapaEstudiantes.put("Juan", Arrays.asList(85, 90, 78));
        mapaEstudiantes.put("María", Arrays.asList(92, 88, 95));
        
        for (Map.Entry<String, List<Integer>> entry : mapaEstudiantes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
    

