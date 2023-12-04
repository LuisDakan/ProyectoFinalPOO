
package Clientes;

import Producto.Prestamo;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author DAPG1
 */

public class Usuario extends Cliente {
    
    private String contra;
    private int cuenta; //6 digitos
    private double dinero;
    static Scanner input=new Scanner(System.in);
    private ArrayList<Prestamo> prestamos; 
    private int cantMult;

    public Usuario(String contra, int cuenta, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.contra = contra;
        this.cuenta = cuenta;
    }
    
    
    public void reviewPrestamos(){
        for(int i=0;i<prestamos.size();i++)
        {
            System.out.print(i+") ");
            prestamos.get(i).read();
        }
    }

    public boolean pedirPrestamo(){
        for(Prestamo element:prestamos){
            if(element.isOutTime() && recomponer()){
                System.out.println("No puede pedir prestamos");
                return true;
            }
        }
        return false;
    }
    
    public long devolverLibro(){
        System.out.println("Que desea devolver? Escoja el numero");
        reviewPrestamos();        
        int index=input.nextInt();
        if(--index>prestamos.size() || index<0){
            System.out.println("Este prestamo no existe");
            return -1;
        }
        
        long id = prestamos.get(index).getBook().getId();
        if(prestamos.get(index).isOutTime() && recomponer()){
            System.out.println("Antes debe pagar la multa");
            return -1;
        }
        prestamos.remove(index);
        return id;
    }
    
    @Override
    public void donacion(){
        System.out.println("Le agradecemos sus donativo\nIngrese la cantidad que quiera donar");
        dinero=input.nextDouble();
    }
    
    private boolean recomponer(){ //multa por retraso de devolucion
        System.out.println("Debe realizar \n1)Pagar Multa 2)Salir");
        switch(input.nextInt())
        {
            case 1->{
                System.out.println("Se le desconto 80 pesos");
                return false;
            }
            case 2->{System.out.println();
                return true;}
            default->{System.out.println("Opcion no valida");
                return true;
            }
        }
    }

    public String getContra() {
        return contra;
    }

    public int getCuenta(){
        return cuenta;
    }

    public ArrayList<Prestamo> getPrestamos(){
        return prestamos;
    }
    
    @Override
    public String toString(){
        return "Usuario{" + "contraseña=" + contra + ", cuenta=" + cuenta + '}';
    }
}
