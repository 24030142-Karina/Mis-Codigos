
package Model;

public class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    private double saldo;

    public Cliente(String nombre, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-15s $%.2f", 
                nombre, email, telefono, saldo);
    }
}
