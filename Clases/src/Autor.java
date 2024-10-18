package Clases.src;

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
    public String toString() {
        return "Autor{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
