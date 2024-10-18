package Servicio;

import Clases.src.Autor;
import Clases.src.Libro;
import Clases.src.Prestamo;
import Clases.src.Usuario;
import DAO.src.AutorDAO;
import DAO.src.LibroDAO;
import DAO.src.PrestamoDAO;
import DAO.src.UsuarioDAO;

import java.util.ArrayList;

public class BibliotecaService {
    public AutorDAO autorDAO;
    public ArrayList<Autor> autores;
    public LibroDAO libroDAO;
    public ArrayList<Libro> libros;
    public PrestamoDAO prestamoDAO;
    public ArrayList<Prestamo> prestamos;
    public UsuarioDAO usuarioDAO;
    public ArrayList<Usuario> usuarios;

    public BibliotecaService() {
        this.autorDAO = new AutorDAO();
        this.autores = autorDAO.selectAll();
        this.libroDAO = new LibroDAO();
        this.libros = libroDAO.selectAll();
        this.prestamoDAO = new PrestamoDAO();
        this.prestamos = prestamoDAO.selectAll();
        this.usuarioDAO = new UsuarioDAO();
        this.usuarios = usuarioDAO.selectAll();
    }
    public ArrayList<Usuario> selectUsuario(){
        return usuarios;
    }

    public int insertUsuario(Usuario u){
        int resultado = 0;
        resultado = usuarioDAO.insert(u);
        if(resultado == 1) {
            this.usuarios.add(u);
            return 1;
        }
        return -1;
    }
    public int deleteUsuario(Usuario u){
        int resultado = 0;
        resultado= usuarioDAO.delete(u.getID());
        if(resultado == 1){
            this.usuarios.remove(u);
            return 1;
        }
        return -1;
    }
    public int updateUsuario(Usuario u){
        int resultado = 0;
        resultado = usuarioDAO.update(u);
        if(resultado == 1){
            int indice = this.usuarios.indexOf(u);
            this.usuarios.set(indice,u);
            return 1;
        }
        return -1;
    }
}
