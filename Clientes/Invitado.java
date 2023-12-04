
package Clientes;

/**
 * @author DAPG1
 */

public class Invitado extends Cliente{
    
    public Invitado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public boolean leer(){
        
        
        return true;
    }

    @Override
    public void donacion() {
        
    }
}
