package Servicio;

import Clases.src.*;
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

    // Método para agregar un nuevo libro
    public int agregarLibro(Libro libro) {
        try {
            return libroDAO.insert(libro);
        } catch (RuntimeException e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para actualizar un libro
    public int actualizarLibro(Libro libro) {
        try {
            return libroDAO.update(libro);
        } catch (RuntimeException e) {
            System.out.println("Error al actualizar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para eliminar un libro por su ID
    public int eliminarLibro(int id) {
        try {
            return libroDAO.delete(id);
        } catch (RuntimeException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los libros
    public ArrayList<Libro> obtenerLibros() {
        try {
            return libroDAO.selectAll();
        } catch (RuntimeException e) {
            System.out.println("Error al obtener los libros: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Método para asignar un autor a un libro (relación muchos a muchos)
    public int asignarAutorALibro(int idLibro, int idAutor) {
        try {
            return Libro_AutorDAO.insert(new Libro(idLibro, "", ""));
        } catch (RuntimeException e) {
            System.out.println("Error al asignar el autor al libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los libros con sus autores (usando la tabla intermedia)
    public ArrayList<Libro_Autor> obtenerLibrosConAutores() {
        try {
            return libroAutorDAO.selectAll(); // Devuelve los libros relacionados con autores
        } catch (RuntimeException e) {
            System.out.println("Error al obtener libros con autores: " + e.getMessage());
            return new ArrayList<>();
        }
}
