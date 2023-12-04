
package Bases;

import Bases.Exceptions.*;

/**
 * @author DAPG1
 */

public class Verificacion {
    
    public static void formatoNombre(String n){
        for(int i=0; i<n.length();i++){
            if(!Character.isLetter(n.charAt(i))){
                throw new FormatNombreException("No debe contener numeros o caracteres especiales");
            }
        }
        for(int i=1; i<n.length();i++){
            if(Character.isUpperCase(n.charAt(i))){
                throw new FormatNombreException("Solo la primera letra debe ser mayuscula");
            }
        }
        if(!Character.isUpperCase(n.charAt(0))){
            throw new FormatNombreException("Debe iniciar con mayuscula");
        }
    }
    

    
    public static void validezEdad(int edad){
        if(edad<12 || edad>120){
            throw new RangoNumeroException("La edad no es valida");
        }
    }       
    
    public static void validezTelefono(int telefono){
        String tel = Integer.toString(telefono);
        if(tel.length() != 10){
            throw new RangoNumeroException("La longitud del telefono no es correcta");
        }
    }
    
    public static void  formatoCorreo(String correo){
        boolean ver=false;
        int cant=0, ind=-1;
        for(int i=0; i<correo.length();i++){
            if(Character.isSpaceChar(correo.charAt(i))){
                throw new FormatCorreoException("El correo no puede tener espacios");
            }
            
            if(Character.compare(correo.charAt(i), '@')==0 ){
                ver = true;
                cant+=1;
                ind=i;
            }
        }
        
        if(!ver){
            throw new FormatCorreoException("El correo debe llevar @");
        }
        
        if(cant!=1){
            throw new FormatCorreoException("El correo no debe contener mas de un @");
        }
        String dominio="@";
        for(int i=ind+1;i<correo.length();i++){
            dominio+= correo.charAt(i);
        }
        
        if(!dominio.equals("@hotmail.com") || !dominio.equals("@gmail.com") || dominio.equals("@yahoo.com"))  {
            throw new FormatCorreoException("El dominio del correo es incorrecto");
        }
    }
    
    public static void formatoDireccion(String direccion){
        
    }
}
