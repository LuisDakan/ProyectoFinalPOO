package Producto;
import java.time.LocalDateTime;
public class Prestamo 
{
    private Libro book;
    private LocalDateTime retiro;
    private LocalDateTime devolucion;

    public Prestamo(Libro book)
    {
        this.book=book;
        retiro=LocalDateTime.now();
        devolucion=retiro.plusWeeks(1);
    }
    
    public LocalDateTime getRetiro()
    {
        return retiro;
    }

    public LocalDateTime getDevolucion()
    {
        return devolucion;
    }

    public void setRetiro()
    {
        devolucion=devolucion.plusWeeks(1);
    }

    public void read()
    {
        System.out.println("Libro: "+book.getTitulo()+" Retirado: "+retiro.getMonth()+ " "+retiro.getDayOfMonth()+" Entrega: "+devolucion.getMonth()+" "+devolucion.getDayOfMonth());
    }
}
