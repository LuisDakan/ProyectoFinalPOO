
package Personal;
import Clientes.Usuario;
import Producto.*;
import java.util.Scanner;
/**
 * @author DAPG1
 */

public class Bibliotecario 
{
    static Scanner input=new Scanner(System.in);
    public void realizarPrestamo(Usuario usuario)
    {
        for(Prestamo element:usuario.getPrestamos())
        {
            if(element.isOutTime())
            {
                System.out.println("Tiene libros atrasados, no puede realizar prestamos");
                return;
            }
        }
        System.out.println("Que libro desea pedir prestado(Escriba el id)");
        //Abre el archivo
        //usuario.getPrestamos().add();
    }  
    
    public void devolver(Usuario usuario)
    {
        long id=usuario.devolverLibro();usuario.devolverLibro();
    }
    public void renovarPrestamo(Usuario usuario)
    {
        for(Prestamo element:usuario.getPrestamos())
        {
            if(element.isOutTime())
            {
                System.out.println("Tiene libros atrasados, no puede renovar");
                return;
            }
        }
        System.out.println("Escriba el numero del libro que desea renovar");
        usuario.reviewPrestamos();
        int index=input.nextInt();
        if(--index>usuario.getPrestamos().size() || index<0)
        {
            System.out.println("Prestamo no valido");
            return;
        }
        usuario.getPrestamos().get(index).setRetiro();
    }
}
