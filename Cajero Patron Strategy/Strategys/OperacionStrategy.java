
package Strategys;


/**
 * Interfaz Strategy para las operaciones del cajero
 * Permite cambiar el algoritmo de ejecución de operaciones en tiempo de ejecución
 * @author Karina Ramirez
 */
public interface OperacionStrategy {
    /**
     * Ejecuta la operación específica
     * true si la operación fue exitosa, false en caso contrario
     */
    boolean ejecutar();
}
