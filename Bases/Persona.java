package Bases;

/**
 * @author DAPG1
 */

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String correo;
    private String direccion;
    

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void validezCorreo(){
        
    }
    
    public void validezNumero(){
        
    }
    
    public void validezDireccion(){
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
