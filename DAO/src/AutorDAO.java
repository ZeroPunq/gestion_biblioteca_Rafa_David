
package DAO.src;

import Clases.src.Autor;
import Clases.src.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorDAO {

    public AutorDAO(){

    }
    public ArrayList<Autor> selectAll(){
        ArrayList<Autor> autores = null;
        String SQL = "SELECT * FROM Autor";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            autores = new ArrayList<Autor>();
            while(rs.next()){
                Autor a = new Autor(rs.getInt("ID"), rs.getString("nombre"));
                autores.add(a);
            }
            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Autor a){
        String SQL = "INSERT INTO Autor VALUES (?, ?)";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1, a.getID());
            ps.setString(2, a.getNombre());
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int delete(int id){
        String SQL = "DELETE FROM Autor WHERE ID = ?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,id);
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update (Autor a){
        String SQL = "UPDATE Autor SET Nombre = ? WHERE ID = ?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setString(1, a.getNombre());
            ps.setInt(2,a.getID());
            ps.execute();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
