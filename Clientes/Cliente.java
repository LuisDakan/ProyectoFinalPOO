
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
    
    public void buscar(String info,int option) {
        ObjectInputStream fileIn = null;
        int busquedas=0;
        String parcial="\0";
        try {
            fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
            while (true) 
            {
                Libro l = (Libro) fileIn.readObject();
                switch(option)
                {
                    case 1->{parcial=l.getTitulo().substring(0, info.length());}
                    case 2->{parcial=l.getAutor().substring(0, info.length());}
                    case 3->{parcial=l.getGenero().substring(0,info.length());}
                }
                if(parcial.toLowerCase().equals(info.toLowerCase()))
                {
                    System.out.println(l);
                    busquedas+=1;
                }
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        System.out.println(busquedas+"busquedas encontradas");
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
    
    public void buscar(String titulo,String autor, String genero)
    {
        ObjectInputStream fileIn = null;
        int busquedas=0;
        String parcial1,parcial2,parcial3;
        try {
            fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
            while (true) 
            {
                Libro l = (Libro) fileIn.readObject();
                parcial1=l.getTitulo().substring(0, titulo.length());
                parcial2=l.getAutor().substring(0, autor.length());
                parcial3=l.getGenero().substring(0,genero.length());
                if(parcial1.toLowerCase().equals(titulo.toLowerCase())&&parcial2.toLowerCase().equals(autor.toLowerCase())&&parcial3.toLowerCase().equals(genero.toLowerCase()))
                {
                    System.out.println(l);
                    busquedas+=1;
                }
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        System.out.println(busquedas+"busquedas encontradas");
    }
    
}
