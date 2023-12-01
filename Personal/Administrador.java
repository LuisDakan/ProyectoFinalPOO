
package Personal;

import Clientes.*;
import Producto.Libro;
import java.io.*;
import java.util.HashMap;



/**
 * @author DAPG1
 */

public class Administrador extends Cliente{

    public Administrador(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
/*
    cuentas 
    donaciones de usuarios junto con pagad del registro
    */
    
    public Usuario buscarU(int cuenta){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if(u.getCuenta()==cuenta){
                    fileIn.close();
                    return u;
                }
            }
        }catch(EOFException e){
            try{
                fileIn.close();
            }catch(IOException ex){
                System.out.println("Error al cerrar el archivo: " + ex.getMessage());
            }
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        System.out.println("EL usuario no existe dentro del sistema de la biblioteca");
        return null;
    }
    
    public Usuario buscarU(String nombre, String apellido){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if( u.getNombre().toLowerCase().equals(nombre)  && u.getApellido().toLowerCase().equals(apellido)){
                    fileIn.close();
                    return u;
                }
            }
        }catch(EOFException e){
            try{
                fileIn.close();
            }catch(IOException ex){
                System.out.println("Error al cerrar el archivo: " + ex.getMessage());
            }
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        System.out.println("El usuario no existe dentro del sistema de la biblioteca");
        return null;
    }
    
    public void registrarU(Usuario usuario){
        ObjectOutputStream fileOut= null;
        try {
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Usuarios"));
            fileOut.writeObject(usuario);
            fileOut.close();
        }catch (IOException e) {
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
    }    
    
    public void eliminarU(Usuario usuario){
        HashMap<Integer, Usuario> temporal = new HashMap<>();
        ObjectInputStream fileIn = null;
        
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if(u.getCuenta()!=usuario.getCuenta()){
                    temporal.put(u.getCuenta(), u);
                }
            }
        }catch(EOFException e){
            try{
                fileIn.close();
            }catch(IOException ex){
                System.out.println("Error al cerrar el archivo: " + ex.getMessage());
            }            
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        
        ObjectOutputStream fileOut= null;
        try{
            File file = new File("Registro Usuarios");
            file.delete();
            
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Usuarios"));
            for(Integer I: temporal.keySet()){
                fileOut.writeObject(temporal.get(I));
            }
            
            fileOut.close(); 
        }catch(IOException e){
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
          
    }
    
    public void registrarL(Libro libro){
        ObjectOutputStream fileOut= null;
        try {
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Usuarios"));
            fileOut.writeObject(libro);
            fileOut.close();
        }catch (IOException e) {
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
    }
    
    
    
    public void eliminarL(Libro libro){
        HashMap<Long, Libro> temporal = new HashMap<>();
        ObjectInputStream fileIn = null;
        
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
            while (true) 
            {
                Libro l = (Libro) fileIn.readObject();
                if(l.getId()!=libro.getId()){
                    temporal.put(l.getId(), l);
                }
            }
        }catch(EOFException e){
            try{
                fileIn.close();
            }catch(IOException ex){
                System.out.println("Error al cerrar el archivo: " + ex.getMessage());
            }            
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        
        ObjectOutputStream fileOut= null;
        try{
            File file = new File("Registro Libros");
            file.delete();
            
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Libros"));
            for(Long I: temporal.keySet()){
                fileOut.writeObject(temporal.get(I));
            }
            fileOut.close(); 
        }catch(IOException e){
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }


    
    @Override  //el de libro por titulo
    public void buscar(String info,int option){
        
    }
    
    
    
    
}

