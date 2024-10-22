package Servicio;

import Clases.src.*;
import DAO.src.*;

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
    public Libro_AutorDAO libroAutorDAO;
    public ArrayList<Libro_Autor>libroAutors;
    public BibliotecaService() {
        this.autorDAO = new AutorDAO();
        this.autores = autorDAO.selectAll();
        this.libroDAO = new LibroDAO();
        this.libros = libroDAO.selectAll();
        this.prestamoDAO = new PrestamoDAO();
        this.prestamos = prestamoDAO.selectAll();
        this.usuarioDAO = new UsuarioDAO();
        this.usuarios = usuarioDAO.selectAll();
        this.libroAutorDAO= new Libro_AutorDAO();
        this.libroAutors= libroAutorDAO.selectAll();
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
    public ArrayList<Prestamo> selectPrestamos(){
        return prestamos;
    }

    public int insertPrestamo(Prestamo p){
        int resultado = 0;
        resultado= prestamoDAO.insert(p);
        if(resultado==1){
            prestamos.add(p);
            return 1;
        }
        return -1;
    }

    public int deletePrestamo(Prestamo p){
        int resultado = 0;
        resultado = prestamoDAO.delete(p.getID());
        if(resultado==1){
            prestamos.remove(p);
            return 1;
        }
        return -1;
    }
}