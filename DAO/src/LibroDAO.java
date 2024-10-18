package DAO.src;

import Clases.src.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO {

    public LibroDAO(){

    }
    public ArrayList<Libro> selectAll(){
        ArrayList<Libro> libros = null;
        String SQL = "SELECT * FROM Libro";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            libros = new ArrayList<Libro>();
            while(rs.next()){
                Libro l = new Libro(rs.getInt("ID"), rs.getString("titulo"), rs.getString("isbn"));
                libros.add(l);
            }
            return libros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Libro l){
        String SQL = "INSERT INTO Libro VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,l.getID());
            ps.setString(2,l.getTitulo());
            ps.setString(3,l.getIsbn());
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int delete(int id){
        String SQL = "DELETE INTO Libro VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,id);
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
    }
}
