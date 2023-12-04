
package Personal;

import Clientes.*;
import Producto.Libro;
import java.io.*;
import java.util.HashMap;
import Bases.*;
import java.util.ArrayList;

/**
 * @author DAPG1
 */

public class Administrador extends Cliente{
    private static Administrador instance = null;
    private String contra;

    private Administrador(String contra, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.contra = contra;
    }
    
    public static Administrador getInstance(){
        if(instance==null){
            instance = new Administrador("El Admin de los Admins", "Administrador","01",30);
        }
        return instance;
    }
    
    public static void crearRegistro(String name){
        File file = new File(name);
        if(!file.exists()){
            ObjectOutputStream fileOut= null;
            try {
                fileOut= new ObjectOutputStream(new FileOutputStream(name));
            } catch (IOException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
        }
    }
 
    public Usuario buscarU(String nombre, String apellido,String contra){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if( u.getNombre().toLowerCase().equals(nombre.toLowerCase()) && u.getApellido().toLowerCase().equals(apellido.toLowerCase()) && u.getContra().equals(contra)   ){
                    return u;
                }
            }
        }catch(EOFException e){
            
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        return null;
    }
    
    public Usuario buscarU(String nombre, String apellido){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while (true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if( u.getNombre().toLowerCase().equals(nombre.toLowerCase()) && u.getApellido().toLowerCase().equals(apellido.toLowerCase())){
                    return u;
                }
            }
        }catch(EOFException e){
            
        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
        System.out.println("El usuario no existe dentro del sistema de la biblioteca");
        return null;
    }
    
    public void registrarU(Usuario usuario){
        MyObjectOutputStream fileOut= null;
        File file = new File("Registro Usuarios");
        if(file.exists()){
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Usuarios",true));
                fileOut.writeObject(usuario);
            }catch (IOException e) {
                System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
            }
        }
    }    
    
    public void eliminarU(Usuario usuario){
        ArrayList<Usuario> temporal = new ArrayList<>();
        ObjectInputStream fileIn = null;
        File file = new File("Registro Usuarios");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
                while (true) 
                {
                    Usuario u = (Usuario) fileIn.readObject();
                    if( (!u.getNombre().equals(usuario.getNombre()) ) && (!u.getApellido().equals(usuario.getApellido()))    ){
                        temporal.add( u);
                    }
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
            file.delete();
            crearRegistro("Registro Usuarios");
            MyObjectOutputStream fileOut= null;
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Usuarios",true));
                for(Usuario usu : temporal){
                    fileOut.writeObject(usu);
                }
            }catch(IOException e){
                System.out.println("Error al eliminar el usuario: " + e.getMessage());
            }
        
        }
          
    }
    
    public void registrarL(Libro libro){
        MyObjectOutputStream fileOut= null;
        File file = new File("Registro Libros");
        if(file.exists()){
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Libros",true));
                fileOut.writeObject(libro);
            }catch (IOException e) {
                System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
            }
        }
        
    }
    
    public void registrarLibros(String archivo){
        BufferedReader fileIn= null;
        MyObjectOutputStream fileOut= null;
        String linea;
        File file = new File("Registro Libros");
        if(file.exists()){
            try {
                fileIn= new BufferedReader(new FileReader(archivo));
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Libros",true));
                while((linea=fileIn.readLine()) != null){
                    String[] partes = linea.split(";");
                    Libro l = new Libro(partes[0],partes[1],partes[2], Integer.parseInt(partes[3]), Long.parseLong(partes[4]));
                    //System.out.println(l);
                    fileOut.writeObject(l);  
                }
            }catch (IOException e) {
                System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
            }
        }
    }
    
    public ArrayList<Libro> listaLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        
        ObjectInputStream fileIn = null;
        File file = new File("Registro Libros");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
                while (true){
                    Libro l = (Libro) fileIn.readObject();
                    libros.add(l);
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
        }
        return libros;
    }
    
    public void eliminarL(Libro libro){
        HashMap<Long, Libro> temporal = new HashMap<>();
        ObjectInputStream fileIn = null;
        File file = new File("Registro Libros");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
                while (true) 
                {
                    Libro l = (Libro) fileIn.readObject();
                    if( l.getId()!=libro.getId()){
                        temporal.put(l.getId(), l);
                    }
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
            
            file.delete();
            crearRegistro("Registro Libros");
            MyObjectOutputStream fileOut= null;
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Libros",true));
                for(Long I: temporal.keySet()){
                    fileOut.writeObject(temporal.get(I));
                }
            }catch(IOException e){
                System.out.println("Error al eliminar el usuario: " + e.getMessage());
            }
        
        }
    }
    
    public void refrescar(Usuario usuario){
        ObjectInputStream fileIn = null;
        ArrayList<Usuario> temporal = new ArrayList<>();
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while(true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if(usuario.getNombre().equals(u.getNombre()) && usuario.getApellido().equals(u.getApellido())    ){
                    temporal.add(usuario);
                }else{
                    temporal.add(u);
                }
            }
        }catch(EOFException e){

        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
         
        File file = new File("Registro Usuarios");
        file.delete();
        
        crearRegistro("Registro Usuarios");
        MyObjectOutputStream fileOut= null;
        try{
            fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Usuarios",true));
            for(int i=0; i<temporal.size(); i++){
                fileOut.writeObject(temporal.get(i));
            }
        }catch(IOException e){
            System.out.println("Error al modificar el usuario: " + e.getMessage());
        }
                    
    }
    
    @Override
    public void mostrarDatos(){
        ObjectInputStream fileIn = null;
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Usuarios"));
            while(true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                System.out.println(u);
            }
        }catch(EOFException e){

        }catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e.getMessage());
        }
    }

}

