package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repositorio<T> {
    private List<T> elementos;
    private static final int MAX_ELEMENTOS = 100;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

    public boolean agregar(T elemento) {
        if (elementos.size() >= MAX_ELEMENTOS) {
            return false;
        }
        return elementos.add(elemento);
    }

    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < elementos.size()) {
            elementos.remove(indice);
            return true;
        }
        return false;
    }

    public T obtener(int indice) {
        if (indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        }
        return null;
    }

    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos);
    }

    public int tamaño() {
        return elementos.size();
    }

    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    public List<T> buscar(Predicate<T> criterio) {
        List<T> resultados = new ArrayList<>();
        for (T elemento : elementos) {
            if (criterio.test(elemento)) {
                resultados.add(elemento);
            }
        }
        return resultados;
    }

    public boolean modificar(int indice, T nuevoElemento) {
        if (indice >= 0 && indice < elementos.size()) {
            elementos.set(indice, nuevoElemento);
            return true;
        }
        return false;
    }
}
