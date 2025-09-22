
public class Utilidades {
    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
    
    public static <T extends Comparable<T>> T encontrarMaximo(T[] array) {
        if (array == null || array.length == 0) return null;
        
        T maximo = array[0];
        for (T elemento : array) {
            if (elemento.compareTo(maximo) > 0) {
                maximo = elemento;
            }
        }
        return maximo;
    }
}

