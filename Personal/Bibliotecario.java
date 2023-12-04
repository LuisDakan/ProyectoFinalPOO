
package Personal;

import Bases.MyObjectOutputStream;
import Clientes.*;
import static Personal.Administrador.crearRegistro;
import Producto.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * @author DAPG1
 */

public class Bibliotecario extends Cliente{
    
    static Scanner input=new Scanner(System.in);
    
    public Bibliotecario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    @Override
    public void donacion(){
        
    }
    
    public void crearRegistroP(){
        Administrador.crearRegistro("Registro Prestamos");
    }
    
    public void registrarPrestamo(Usuario usuario){
        MyObjectOutputStream fileOut= null;
        File file = new File("Registro Prestamos");
        if(file.exists()){
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Prestamos",true));
                fileOut.writeObject(usuario);
            }catch (IOException e) {
                System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
            }
        }
    }
    
    public void eliminarPrestamos(Usuario usuario){
        ArrayList<Usuario> temporal = new ArrayList<>();
        ObjectInputStream fileIn = null;
        File file = new File("Registro Prestamos");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Prestamos"));
                while (true) 
                {
                    Usuario u = (Usuario) fileIn.readObject();
                    if( u.getCuenta()!= usuario.getCuenta()){
                        temporal.add(u);
                    }
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
            
            file.delete();
            crearRegistro("Registro Prestamos");
            MyObjectOutputStream fileOut= null;
            try{
                fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Prestamos",true));
                for(Usuario usu: temporal){
                    fileOut.writeObject(usu);
                }
            }catch(IOException e){
                System.out.println("Error al eliminar el usuario: " + e.getMessage());
            }
        }
    }
    
    public void actualizarPrestamo(Usuario usuario){
        ObjectInputStream fileIn = null;
        ArrayList<Usuario> temporal = new ArrayList<>();
        try{
            fileIn = new ObjectInputStream(new FileInputStream("Registro Prestamos"));
            while(true) 
            {
                Usuario u = (Usuario) fileIn.readObject();
                if(usuario.getCuenta() == u.getCuenta()){
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
         
        File file = new File("Registro Prestamos");
        file.delete();
        
        crearRegistro("Registro Prestamos");
        MyObjectOutputStream fileOut= null;
        try{
            fileOut= new MyObjectOutputStream(new FileOutputStream("Registro Prestamos",true));
            for(int i=0; i<temporal.size(); i++){
                fileOut.writeObject(temporal.get(i));
            }
        }catch(IOException e){
            System.out.println("Error al modificar el usuario: " + e.getMessage());
        }
    }
    
    
    public boolean verificarPrestamo(Usuario usuario){
        ObjectInputStream fileIn = null;
        File file = new File("Registro Prestamos");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Prestamos"));
                while (true) 
                {
                    Usuario u = (Usuario) fileIn.readObject();
                    if( u.getCuenta()== usuario.getCuenta()){
                        return true;
                    }
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
        }
        
        return false;
    } 
    
    
    
    
    
    public void realizarPrestamo(Usuario usuario,ArrayList<Libro> general){
        long id=0;
        int index=0;
        if(usuario.pedirPrestamo()){
            return;
        }
        
        System.out.println("Que libro desea pedir prestado\n0)Escriba el id 1)pegar del portapeles)");
        switch(input.nextInt()){
            case 1->{System.out.println("Escriba el id");
                    id=input.nextLong();
            }
            case 2->{id=usuario.getPortaPapeles();}
        }
        
        for(int i=0;i<general.size();i++){
            if(id==general.get(i).getId())
            {
                if(general.get(i).getCant()==0){
                    System.out.println("No es posible realizar el prestamo, ya que todos los ejemplares estan agotados");
                    return;
                }
                general.get(i).minusCant();
                index=i;
            }
        }
        
        File file = new File("Registro Libros");
        file.delete();
        Administrador.crearRegistro("Registro Libros");
        
        MyObjectOutputStream fileOut;
        try{
            fileOut=new MyObjectOutputStream(new FileOutputStream("Registro Libros",true)); 
            for(int i=0;i<general.size();i++){
                fileOut.writeObject(general.get(i));
            }
        }
        catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        usuario.getPrestamos().add(new Prestamo(general.get(index)));
        
        if(verificarPrestamo(usuario)){
            actualizarPrestamo(usuario);
        }else{
            registrarPrestamo(usuario);
        }
        
        
    }
    
    public void devolver(Usuario usuario,ArrayList<Libro> general){
        long id=usuario.devolverLibro();
        if(id==-1){
            System.out.println("No es posible realizar la devolucion");
            return;
        }
        
        if(usuario.getPrestamos().isEmpty()){
            eliminarPrestamos(usuario);
        }else{
            actualizarPrestamo(usuario);
        }
        
        for(int i=0;i<general.size();i++){
            if(id==general.get(i).getId()){
                general.get(i).addCant();
            }
        }
        
        File file = new File("Registro Libros");
        file.delete();
        Administrador.crearRegistro("Registro Libros");
        
        MyObjectOutputStream fileOut;
        try{
            fileOut=new MyObjectOutputStream(new FileOutputStream("Registro Libros",true));
            for(int i=0;i<general.size();i++)
            {
                fileOut.writeObject(general.get(i));
            }
        }catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
    }
    
    public void renovarPrestamo(Usuario usuario)
    {
        for(Prestamo element:usuario.getPrestamos()){
            if(element.isOutTime()){
                System.out.println("Tiene libros atrasados, no puede renovar");
                return;
            }
        }
        System.out.println("Escriba el numero del libro que desea renovar");
        usuario.reviewPrestamos();
        int index=input.nextInt();
        if(--index>usuario.getPrestamos().size() || index<0){
            System.out.println("Prestamo no valido");
            return;
        }
        usuario.getPrestamos().get(index).setRetiro();
    }
    
    
}
