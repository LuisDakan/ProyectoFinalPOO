
package Producto;

/**
 * @author DAPG1
 */

public interface Factory {
    
    public Libro crearLibro();
    
    public void verificarLibro(Libro libro);
    
    public void formatoTitulo(String titulo);
    
    public void formatoGenero(String genero);
    
    public void formatoCant(int cant);
    
    public void formatoID(long id);
    
   
   
    
        
}
