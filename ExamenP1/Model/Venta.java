package model;

public class Venta {
    private int idProducto;
    private int cantidad;
    private double precio;
    private String fecha;
    private int idCliente;

    public Venta(int idProducto, int cantidad, double precio, String fecha, int idCliente) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}
