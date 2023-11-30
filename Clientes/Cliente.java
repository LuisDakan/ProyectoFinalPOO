
package Clientes;

import Bases.Persona;
import Producto.Libro;
import java.io.*;

/**
 * @author DAPG1
 */

public abstract class Cliente extends Persona{
    
    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public Libro buscar(String titulo) {
        ObjectInputStream fileIn = null;
        try {
            fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
            while (true) {
                Libro l = (Libro) fileIn.readObject();
                if (l.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                    fileIn.close();
                    return l;
                }
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        
        System.out.println("EL libro no existe dentro del sistema de la biblioteca");
        return null;
    }
    
    public Libro buscar(long id){
        ObjectInputStream fileIn = null;
        try {
            fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
            while (true) {
                Libro l = (Libro) fileIn.readObject();
                if (id==l.getId()){
                    fileIn.close();
                    return l;
                }
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        
        System.out.println("EL libro no existe dentro del sistema de la biblioteca");
        return null;
    }
    
    public void buscar(){
        
    }
    
}
