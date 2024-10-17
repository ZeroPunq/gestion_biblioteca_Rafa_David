package Clases.src;

import java.sql.Date;

public class Prestamo {
    private int ID;
    private Date fechaInicio;
    private Date fechaFinal;

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
    public String toString() {
        return "Prestamo{" +
                "ID=" + ID +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                '}';
    }
}
