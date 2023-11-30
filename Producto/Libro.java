package Producto;

/**
 * @author DAPG1
 */

public class Libro {

    private String titulo;
    private String autor;
    private String genero;
    private int cant;
    private long id;
    

    public Libro(String titulo, String autor, String genero, int cant, long id) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cant = cant;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getCant() {
        return cant;
    }

    public long getId() {
        return id;
    }


    
}
