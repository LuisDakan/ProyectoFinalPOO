
package Personal;

import Clientes.*;
import Producto.Libro;
import java.io.*;

/**
 * @author DAPG1
 */

public class Bibliotecario extends Cliente{
    
    public Bibliotecario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public void realizarPrestamo(Usuario cliente){
        ObjectOutputStream fileOut= null;
        try {
            fileOut= new ObjectOutputStream(new FileOutputStream("Registro Prestamos"));
            fileOut.writeObject(cliente);
            fileOut.close();
        }catch (IOException e) {
            System.out.println("Error al escribir objetos en el archivo: " + e.getMessage());
        }
    }  
    
    public void devolver(){

    }
    public void renovarPrestamo(){

    }
    
    
}
