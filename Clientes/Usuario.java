
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
    private long portapeles;

    public Usuario(String contra, int cuenta, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.contra = contra;
        this.cuenta = cuenta;
        portapeles=0;
    }
    
    @Override
    public void mostrarDatos(){
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
        mostrarDatos();        
        int index=input.nextInt();
        if(--index>prestamos.size() || index<0){
            System.out.println("Este prestamo no existe");
            return -1;
        }
        
        long id = prestamos.get(index).getBook().getId();
        if(prestamos.get(index).isOutTime()){
            multa();
        }
        prestamos.remove(index);
        return id;
    }
    
    private boolean recomponer(){ //opcion multa por retraso de devolucion
        System.out.println("Debe realizar \n1)Pagar Multa 2)Salir");
        switch(input.nextInt()){
            case 1->{
                System.out.println("Se le cobrara $80 de su tarjeta de Usuario");
                return false;
            }
            case 2->{System.out.println();
                return true;}
            default->{System.out.println("Opcion no valida");
                return true;
            }
        }
    }
    
    private void multa(){ //multa por retraso de devolucion
        System.out.println("Debe realizar el pago de la multa por retraso en la devolucion");
        System.out.println("Se realizo un cobro a su tarjeta de Usuario");
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
    
    public long getPortaPapeles(){
        return portapeles;
    }

    public void setPortapeles(long portapeles) {
        this.portapeles = portapeles;
    }
    
    @Override
    public String toString(){
        return "Usuario{" + "contraseña=" + contra + ", cuenta=" + cuenta + '}';
    }
}
