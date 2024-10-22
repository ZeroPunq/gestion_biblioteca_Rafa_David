package Clases.src;

import java.util.Objects;

public class Libro {

    private int ID;
    private String titulo;
    private String isbn;

    public Libro(int ID, String titulo, String isbn){
        this.ID = ID;
        this.titulo = titulo;
        this.isbn = isbn;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ID == libro.ID;  // Comparar por ID u otro campo único
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID); // Hash basado en el ID
    }


    @Override
    public String toString() {
        return "Libro{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

