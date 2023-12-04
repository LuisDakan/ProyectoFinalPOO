
package Principal;

import Clientes.*;
import Personal.*;
import Producto.*;

/**
 * @author DAPG1
 */

public class Main {

    public static void main(String[] args) {
        
        Administrador Admin = new Administrador("Admin","Principal",20);
        
        Administrador.crearRegistro("Registro Usuarios");
        
        /*Admin.crearRegistro("Registro Libros");
        Admin.registrarLibros("Biblioteca.csv");
        
        Libro l = new Libro("Celeste", "Luis", "Terror",6,9355957);
        
        Libro e = Admin.buscar(9355957);
        System.out.println("1 "+ e);
        
        Admin.registrarL(l);
        Libro r = Admin.buscar(9355957);
        System.out.println("2 "+ r);
        
        Admin.eliminarL(l);
        Libro t = Admin.buscar(9355957);
        System.out.println("3 "+ t);
        */
        
        Usuario usu = new Usuario("#14Y",204561,"Celeste","Peña",20);
        
        usu.setTelefono(1234567898);
        usu.setCorreo("cel@gmail.com");
        
        Usuario usu1 = new Usuario("#765432",145678,"Tista","Poo",20);
        
        usu1.setTelefono(1234567898);
        usu1.setCorreo("cel@gmail.com");
        
        Usuario usu2 = new Usuario("(IJNGr",453217,"Geriads","Meremdd",20);
        
        usu2.setTelefono(1234567898);
        usu2.setCorreo("cel@gmail.com");
        
        
        
        Admin.registrarU(usu);
        Admin.registrarU(usu1);
        Admin.registrarU(usu2);
        
        
        Usuario i = Admin.buscarU(145678);
        System.out.println("1 "+ i);
        
        Usuario n = Admin.buscarU("Tista","Poo");
        System.out.println("2 "+ n);
        
        
        Admin.eliminarU(usu1);
        Usuario p = Admin.buscarU(145678);
        System.out.println("3 "+ p);
        
        
        
        
        /*
        
        Usuario y = Admin.buscarU("Celeste","Peña");
        System.out.println("2"+ y);
        
        Usuario usu2 = new Usuario("%$#vd",324561,"Diego","Araiza",20);
        usu2.setTelefono(1988567898);
        usu2.setCorreo("diego@gmail.com");
        usu2.setDireccion("vsnds");
        Admin.registrarU(usu2);
        Admin.eliminarU(usu);
        */
    }
}
