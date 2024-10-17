package DAO.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:3306/gestion_equipos";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
