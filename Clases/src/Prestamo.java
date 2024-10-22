package Clases.src;

import java.sql.Date;
import java.util.Objects;

public class Prestamo {
    private int ID;
    private Date fechaInicio;
    private Date fechaFinal;
    private int idUsuario;
    private int idLibro;

    public Prestamo(int ID, Date fechaInicio, Date fechaFinal, int idUsuario, int idLibro) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getID() {
        return ID;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return ID == prestamo.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "ID=" + ID +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}
