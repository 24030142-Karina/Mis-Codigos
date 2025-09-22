
package Util;

import Model.Productos;
import Model.Cliente;
import model.Repositorio;
import java.io.*;

public class Manager {
    
    public static void guardarProductos(Repositorio<Productos> productos, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }
    
    public static Repositorio<Productos> cargarProductos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Repositorio<Productos>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
            return new Repositorio<>();
        }
    }
    
    public static void guardarClientes(Repositorio<Cliente> clientes, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }
    
    public static Repositorio<Cliente> cargarClientes(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Repositorio<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
            return new Repositorio<>();
        }
    }
}

