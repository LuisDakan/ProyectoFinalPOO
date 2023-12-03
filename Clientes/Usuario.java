
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
        for(int i=0;i<prestamos.size();i++)
        {
            System.out.print(i+") ");
            prestamos.get(i).read();
        }
    }
    public void pedirPrestamo()
    {
        
    }
    public long devolverLibro()
    {
        System.out.println("Que desea devolver?Escoja el numero");
        reviewPrestamos();        
        int index=input.nextInt();
        if(--index>prestamos.size() || index<0)
        {
            System.out.println("Prestamo no valido");
            return -1;
        }
        long id=prestamos.get(index).getBook().getId();
        prestamos.remove(index);
        return id;
        
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
