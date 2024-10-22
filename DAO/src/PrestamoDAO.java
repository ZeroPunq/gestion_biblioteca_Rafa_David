package DAO.src;

import Clases.src.Prestamo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrestamoDAO {
    public PrestamoDAO() {
    }

    public ArrayList<Prestamo> selectAll(){
        ArrayList<Prestamo> prestamos = null;
        String SQL = "SELECT * FROM Prestamo ";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            prestamos= new ArrayList<>();
            while (rs.next()){
                Prestamo p =new Prestamo(rs.getInt("ID"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"),rs.getInt("usuarioId"),rs.getInt("libroId"));
                prestamos.add(p);
            }
            return prestamos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int insert(Prestamo p){
        String SQL = "INSERT INTO Prestamo VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,p.getID());
            ps.setDate(2,p.getFechaInicio());
            ps.setDate(3,p.getFechaFinal());
            ps.setInt(4,p.getIdUsuario());
            ps.setInt(4,p.getIdLibro());
            ps.execute();
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int delete(int id){
        String SQL = "DELETE FROM Prestamo WHERE ID = ?";
        try {
            PreparedStatement ps= Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,id);
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
