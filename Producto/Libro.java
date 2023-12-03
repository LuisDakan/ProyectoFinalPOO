package Producto;

import java.io.Serializable;

/**
 * @author DAPG1
 */

public class Libro implements Serializable{

    private String titulo;
    private String autor;
    private String genero;
    private int cant;
    private int id;

    public Libro(String titulo, String autor, String genero, int cant, int id) {
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

    public int getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return "Titulo: "+this.titulo+" Autor: "+this.autor+" Genero: "+this.genero+" Cantidad: "+this.cant+" Id: "+this.id;
    }
    
}
