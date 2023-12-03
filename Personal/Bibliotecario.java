
package Personal;
import Clientes.Usuario;
import Producto.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * @author DAPG1
 */

public class Bibliotecario 
{
    static Scanner input=new Scanner(System.in);
    public void realizarPrestamo(Usuario usuario,ArrayList<Libro> general)
    {
        long id=0;
        int index=0;
        if(usuario.pedirPrestamo())
        {
            return;
        }
        System.out.println("Que libro desea pedir prestado\n0)Escriba el id 1)pegar del portapeles)");
        switch(input.nextInt())
        {
            case 1->{System.out.println("Escriba el id");
                    id=input.nextLong();
            }
            case 2->{id=usuario.getPortaPapeles();}
        }
        for(int i=0;i<general.size();i++)
        {
            if(id==general.get(i).getId())
            {
                general.get(i).minusCant();
                index=i;
            }
        }
        ObjectOutputStream fileOut;
        try{
            fileOut=new ObjectOutputStream(new FileOutputStream("Registro Usuarios")); //Usar singleton
            for(int i=0;i<general.size();i++)
            {
                fileOut.writeObject(general.get(i));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error al abrir el archivo");
        }
        usuario.getPrestamos().add(new Prestamo(general.get(index)));
    }  
    
    public void devolver(Usuario usuario,ArrayList<Libro> general)
    {
        long id=usuario.devolverLibro();
        if(id==-1){
            System.out.println("No es posible realizar la devolucion");
            return;
        }
        for(int i=0;i<general.size();i++)
        {
            if(id==general.get(i).getId())
            {
                general.get(i).addCant();
            }
        }
        ObjectOutputStream fileOut;
        try{
            fileOut=new ObjectOutputStream(new FileOutputStream("Registro Usuarios")); //Usar singleton
            for(int i=0;i<general.size();i++)
            {
                fileOut.writeObject(general.get(i));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error al abrir el archivo");
        }
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
