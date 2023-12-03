
package Personal;

import Clientes.*;
import Producto.Libro;
import java.io.*;
import java.util.ArrayList;
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
    
    public Usuario buscarU(Usuario usuario){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if(usuario == u){
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
            fileOut.flush();
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
        String linea = "\n"+libro.getTitulo()+";"+libro.getAutor()+";"+libro.getGenero()+";"+libro.getCant()+";"+libro.getId();
        PrintWriter fileOut= null;
        try {
            fileOut= new PrintWriter(new BufferedWriter(new FileWriter("Biblioteca.csv",true)));
            //fileOut.print("\n");
            fileOut.print(linea);
            fileOut.flush();
            fileOut.close();
        }catch (IOException e){
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
        registrarLibros("Biblioteca.csv");
        
    }
    
    //correcto
    public void registrarLibros(String archivo){
        BufferedReader fileIn= null;
        ObjectOutputStream fileOut= null;
        String linea;
       
        try {
            fileIn= new BufferedReader(new FileReader(archivo));
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Libros"));
            while((linea=fileIn.readLine()) != null){
                String[] partes = linea.split(";");
                Libro l = new Libro(partes[0],partes[1],partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
                //System.out.println(l);
                fileOut.writeObject(l);  
            }
            fileOut.flush();
            fileOut.close();
            fileIn.close();
        }catch (IOException e) {
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
    }
    
    
    public void eliminarL(Libro libro){
        ArrayList<String> temporal = new ArrayList<>();
        String datos = libro.getTitulo()+";"+libro.getAutor()+";"+libro.getGenero()+";"+libro.getCant()+";"+libro.getId();        
        BufferedReader fileIn= null;
        String linea;
        System.out.println("datos: "+ datos);
        try{
            fileIn= new BufferedReader(new FileReader("Biblioteca.csv"));
            while ((linea=fileIn.readLine()) != null){
                if(!linea.equals(datos)){
                    temporal.add( linea);
                }
            }
            fileIn.close();     
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
        System.out.println(temporal.contains(datos));
        
        File file = new File("Biblioteca.csv");
        file.delete();
        
        PrintWriter fileOut= null;
        try {
            fileOut= new PrintWriter(new BufferedWriter(new FileWriter("Biblioteca.csv")));
            //fileOut.print("\n");
            
            fileOut.print(temporal.get(0));
            for(int i=1; i<temporal.size();i++){
                fileOut.print("\n"+temporal.get(i));
                fileOut.flush();
            }
            fileOut.close();
        }catch (IOException e){
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }        
        registrarLibros("Biblioteca.csv");
    }
    
    
}

