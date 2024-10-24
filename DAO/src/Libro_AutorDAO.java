package DAO.src;

import Clases.src.Libro;
import Clases.src.Libro_Autor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Libro_AutorDAO {
    public Libro_AutorDAO() {
    }
    public ArrayList<Libro_Autor> selectAll(){
        ArrayList<Libro_Autor> libros_autores = null;
        String SQL = "SELECT * FROM Libro_Autor";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            libros_autores = new ArrayList<Libro_Autor>();
            while(rs.next()){
                Libro_Autor la = new Libro_Autor(rs.getInt("idLibro"), rs.getInt("idAutor"));
                libros_autores.add(la);
            }
            return libros_autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Libro_Autor la){
        String SQL = "INSERT INTO Libro_Autor VALUES (?, ?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,la.getIdAutor());
            ps.setInt(2,la.getIdLibro());
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*public int delete(int id){
        String SQL = "DELETE INTO Libro VALUES (?,?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,id);
            ps.setInt(2,id);
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

 public int update (Libro l){
        String SQL = "UPDATE Libro SET Nombre = ? WHERE ID = ?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,l.getID());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getIsbn());
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
