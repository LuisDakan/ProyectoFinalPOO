
package Producto;

import Bases.Exceptions.*;
import Bases.Verificacion;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author DAPG1
 */

public class FabricaLibros implements Factory{
    
    static Scanner input=new Scanner(System.in);
    
    @Override
    public Libro crearLibro(){
        String titulo="", autor="", genero="";
        int cant=-1;
        long id=-1;
        
        try{
            System.out.print("Ingrese el titulo del libro");
            titulo = input.nextLine();
            formatoTitulo(titulo);
            
            System.out.print("Ingrese Al autor del libro");
            autor = input.nextLine();
            Verificacion.formatoNombre(autor);
            
            System.out.print("Ingrese el genero del libro");
            genero = input.nextLine();
            formatoGenero(genero);
            
            System.out.print("Ingrese el genero del libro");
            cant = input.nextInt();
            formatoCant(cant);

            System.out.print("Ingrese el genero del libro");
            id = input.nextLong();
            formatoID(id);
        }catch(FormatNombreException e){
            System.out.println("Error en el formato del titulo: " + e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("Error en el formato del titulo: " + e.getMessage());
        }catch(IdRepetidoException e){
            System.out.println("Error en el formato del titulo: " + e.getMessage());
        }catch(RangoNumeroException e){
            System.out.println("Error en el formato del titulo: " + e.getMessage());
        }
        
        Libro libro = new Libro(titulo,autor,genero, cant, id);
        try{
            verificarLibro(libro);
        }catch(LibroRepetidoException e){
            System.out.println("El libro esta repetido: " + e.getMessage());
        }
        
        return libro;
        
    }
    
    @Override
    public void verificarLibro(Libro libro){
        ObjectInputStream fileIn = null;
        File file = new File("Registro Libros");
        if(file.exists()){
            try{
                fileIn = new ObjectInputStream(new FileInputStream("Registro Libros"));
                while (true) 
                {
                    Libro l = (Libro) fileIn.readObject();
                    if(l.getTitulo().equals(libro.getTitulo()) && l.getGenero().equals(libro.getGenero())  ){
                        throw new LibroRepetidoException();
                    }
                }
            }catch(EOFException e){

            }catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error clase no encontrada: " + e.getMessage());
            }
        } 
    }
    
    @Override
    public void formatoTitulo(String titulo){
        if(!Character.isUpperCase(titulo.charAt(0))){
            throw new FormatNombreException("Debe iniciar con mayuscula");
        }
    }
    
    @Override
    public void formatoGenero(String genero){
        if(!Character.isUpperCase(genero.charAt(0))){
            throw new FormatNombreException("Debe iniciar con mayuscula");
        }
        
        for(int i=0; i<genero.length();i++){
            if(!Character.isLetter(genero.charAt(i))){
                throw new FormatNombreException("No debe contener numeros o caracteres especiales");
            }
        }
    }
    
    @Override
    public void formatoCant(int cant){
        if(cant<=0){
            throw new RangoNumeroException("Debe iniciar con mayuscula");
        }
    }
    
    @Override
    public void formatoID(long id){
        BufferedReader fileIn= null;
        String linea;
        try {
            fileIn= new BufferedReader(new FileReader("Biblioteca.csv"));
            while((linea=fileIn.readLine()) != null){
                String[] partes = linea.split(";");
                if(Long.parseLong(partes[4]) == id){
                    throw new IdRepetidoException("Ya existe el Id");
                }
            }
            fileIn.close();
        }catch (IOException e) {
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
    }
    
}
