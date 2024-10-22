package Clases.src;

import java.util.Objects;

public class Autor {
    private int ID;
    private String nombre;

    public Autor(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return ID == autor.ID;  // Comparar por ID u otro campo único
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID); // Hash basado en el ID
    }

    @Override
    public String toString() {
        return "Autor{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
