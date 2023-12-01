
package Clientes;
import java.util.ArrayList;
import java.util.Scanner;
import Producto.*;
/**
 * @author DAPG1
 */

public class Usuario extends Cliente{
    
    private String contrasena;
    private int cuenta;
    private ArrayList<Prestamo> prestamos; 
    static Scanner input=new Scanner(System.in);
    public Usuario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getCuenta() {
        return cuenta;
    }
    public void reviewPrestamos()
    {
        for(Prestamo element:prestamos)
        {
            element.read();
        }
    }
    public void pedirPrestamo(){

    }
    public void devolverLibro(){
        
    }
    public void donar()
    {

    }
    public void recomponer()
    {

    }
    @Override
    public String toString() {

        return  "Usuario"+ "contrasenia=" + contrasena + ", cuenta=" + cuenta + '}';
    }
}
