
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
    public boolean pedirPrestamo()
    {
        for(Prestamo element:prestamos)
        {
            if(element.isOutTime()&&recomponer())
            {
                System.out.println("No puede realizar prestamos");
                return true;
            }
        }
        return false;
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
        if(prestamos.get(index).isOutTime()&&recomponer())
        {
            System.out.println("Antes debe pagar la multa");
            return -1;
        }
        prestamos.remove(index);
        return id;
        
    }
    public double donar()
    {
        System.out.println("Le agradecemos sus donativo\nIngrese la cantidad que quiera donar");
        double donative=input.nextDouble();
        return donative;
    }
    private boolean recomponer()
    {
        System.out.println("Debe realizar \n1)Pagar Multa 2)Salir");
        switch(input.nextInt())
        {
            case 1->{
                System.out.println("Se le desconto 10 pesos");
                return false;
            }
            case 2->{System.out.println();
                return true;}
            default->{System.out.println("Opcion no valida");
                return true;
            }
        }
    }
    public ArrayList<Prestamo> getPrestamos()
    {
        return prestamos;
    }
    @Override
    public String toString() {

        return  "Usuario"+ "contrasenia=" + contrasena + ", cuenta=" + cuenta + '}';
    }
}
