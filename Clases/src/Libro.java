package Clases.src;

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
    public String toString() {
        return "Libro{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

