
package Model;


public class Productos {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private String fechaVencimiento;

    public Productos(String codigo, String nombre, double precio, int cantidad, 
                   String categoria, String fechaVencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    @Override
    public String toString() {
        return String.format("%-7s %-20s %.2f\t%-10d %-15s %s", 
                codigo, nombre, precio, cantidad, categoria, fechaVencimiento);
    }
}
