
package Clientes;

/**
 * @author DAPG1
 */

public class Usuario extends Cliente{
    
    private String contraseña;
    private int cuenta;
    
    public Usuario(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getCuenta() {
        return cuenta;
    }
    
    
  
    //metodo donar

    @Override
    public String toString() {
        return "Usuario{" + "contrase\u00f1a=" + contraseña + ", cuenta=" + cuenta + '}';
    }
}
