package DAO.src;

import Clases.src.Prestamo;
import Clases.src.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public ArrayList<Usuario> selectAll(){
        ArrayList<Usuario> usuarios = null;
        String SQL = "SELECT * FROM Usuario";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            usuarios= new ArrayList<Usuario>();
            while (rs.next()){
                Usuario u = new Usuario(rs.getInt("ID"),rs.getString("Nombre"));
                usuarios.add(u);
            }
            return usuarios;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int insert(Usuario u){
        String SQL = "INSERT INTO Usuario VALUES (?,?)";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,u.getID());
            ps.setString(2, u.getNombre());
            ps.execute();
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int delete(int id){
        String SQL ="DELETE FROM Usuario WHERE ID = ?";
        try {
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setInt(1,id);
            ps.execute();
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int update(Usuario u){
        String SQL = "UPDATE Usuario SET Nombre = ? WHERE ID = ?";
        try{
            PreparedStatement ps = Conexion.conectar().prepareStatement(SQL);
            ps.setString(1,u.getNombre());
            ps.setInt(2,u.getID());
            ps.execute();
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
