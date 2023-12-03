
package Clientes;

import Producto.Prestamo;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author DAPG1
 */

public class Usuario extends Cliente implements Serializable{
    
    private String contra;
    private int cuenta; //6 digitos
    static Scanner input=new Scanner(System.in);
    private ArrayList<Prestamo> prestamos; 
    
    public Usuario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public void reviewPrestamos()
    {
        for(int i=0;i<prestamos.size();i++)
        {
            System.out.print(i+") ");
            prestamos.get(i).read();
        }
    }

    public void pedirPrestamo(){
        
    }
    
    public long devolverLibro()
    {
        System.out.println("Que desea devolver? Escoja el numero");
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
    
    public void donar(){

    }
    
    public void recomponer(){

    }

    public String getContra() {
        return contra;
    }

    public int getCuenta(){
        return cuenta;
    }

    @Override
    public String toString() {
        return "Usuario{" + "contraseña=" + contra + ", cuenta=" + cuenta + '}';
    }
}
