
package Clientes;
import java.util.ArrayList;
import Producto.Prestamo;
/**
 * @author DAPG1
 */

public class Usuario extends Cliente{
    
    private String contrasena;
    private int cuenta;
    private ArrayList<Prestamo> prestamos; 
    
    public Usuario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getCuenta() {
        return cuenta;
    }
    public void realizarPrestamo()
    {

    }
    public void reviewPrestamos()
    {

    }

    public void devolver()
    {

    }
    public void renovarPrestamo()
    {

    }
    
    public void donar()
    {

    }
    public void recomponer(){

    }
    @Override
    public String toString() {

        return  "Usuario"+ "contrasenia=" + contrasena + ", cuenta=" + cuenta + '}';
    }
}
