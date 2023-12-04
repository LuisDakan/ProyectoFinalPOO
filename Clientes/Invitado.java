
package Clientes;

import java.util.Scanner;

/**
 * @author DAPG1
 */

public class Invitado extends Cliente{
    private double dinero;
    static Scanner input=new Scanner(System.in);
    private static Invitado instance = null;
    
    private Invitado(String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
    }
    
    public static Invitado getInstance(){
        if(instance==null){
            instance = new Invitado("Invitado","01",25);
        }
        return instance;
    }

    
    @Override
    public void mostrarDatos(){
        System.out.println("Invitado" + "Donativo=" + dinero);
    }

    
}
