
package Principal;

import Personal.*;
import Producto.*;

/**
 * @author DAPG1
 */

public class Main {

    public static void main(String[] args) {
        Administrador Admin = new Administrador("Admin","Principal",20);
        Admin.registrarLibros("Biblioteca.csv");
        
        Libro l = new Libro("Celeste", "Diego", "Terror",6,9355957);
        Libro e = Admin.buscar(9355957);
        
        System.out.println("1"+ e);
        Admin.registrarL(l);
        
        Libro t = Admin.buscar(9355957);
        System.out.println("2"+t);
        
        
        Libro w = Admin.buscar(9355957);
        System.out.println("3"+w);
        
        Admin.eliminarL(l);
        
        Admin.registrarL(l);
        
        Libro d = Admin.buscar(9355957);
        System.out.println(d);
        
    }
    
}
