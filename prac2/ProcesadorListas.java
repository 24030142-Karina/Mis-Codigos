
public class ProcesadorListas {
    public static void imprimirLista(List<?> lista) {
        for (Object elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
    
    public static double sumarNumeros(List<? extends Number> lista) {
        double suma = 0.0;
        for (Number numero : lista) {
            suma += numero.doubleValue();
        }
        return suma;
    }
}
}
