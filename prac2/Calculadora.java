

interface Operacion<T> {
    T ejecutar(T a, T b);
}


class Calculadora<T extends Number> {
    public double sumar(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    
    public double multiplicar(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }
}
