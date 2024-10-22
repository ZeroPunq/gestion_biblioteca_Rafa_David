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
    public ArrayList<Libro_Autor> libroAutors;

    public BibliotecaService() {
        this.autorDAO = new AutorDAO();
        this.autores = autorDAO.selectAll();
        this.libroDAO = new LibroDAO();
        this.libros = libroDAO.selectAll();
        this.prestamoDAO = new PrestamoDAO();
        this.prestamos = prestamoDAO.selectAll();
        this.usuarioDAO = new UsuarioDAO();
        this.usuarios = usuarioDAO.selectAll();
        this.libroAutorDAO=new Libro_AutorDAO();
        this.libroAutors= libroAutorDAO.selectAll();
    }
    //Metodo para obtener todos los usuarios
    public ArrayList<Usuario> selectUsuario() {
        return usuarios;
    }
    //Metodo para añadir usuario
    public int insertUsuario(Usuario u) {
        int resultado = 0;
        resultado = usuarioDAO.insert(u);
        if (resultado == 1) {
            this.usuarios.add(u);
            return 1;
        }
        return -1;
    }
    //Metodo para borrar usuarios
    public int deleteUsuario(Usuario u) {
        int resultado = 0;
        resultado = usuarioDAO.delete(u.getID());
        if (resultado == 1) {
            this.usuarios.remove(u);
            return 1;
        }
        return -1;
    }
    //Metodo para actualizar usuarios
    public int updateUsuario(Usuario u) {
        int resultado = 0;
        resultado = usuarioDAO.update(u);
        if (resultado == 1) {
            int indice = this.usuarios.indexOf(u);
            this.usuarios.set(indice, u);
            return 1;
        }
        return -1;
    }
    //Metodo para ver los prestamos
    public ArrayList<Prestamo> selectPrestamos() {
        return prestamos;
    }
    //Metodo para crear prestamos
    public int insertPrestamo(Prestamo p) {
        int resultado = 0;
        resultado = prestamoDAO.insert(p);
        if (resultado == 1) {
            this.prestamos.add(p);
            return 1;
        }
        return -1;
    }
    //Metodo para borrar prestamos
    public int deletePrestamo(Prestamo p) {
        int resultado = 0;
        resultado = prestamoDAO.delete(p.getID());
        if (resultado == 1) {
            this.prestamos.remove(p);
            return 1;
        }
        return -1;
    }

    // Método para agregar un nuevo libro
    public int agregarLibro(Libro libro) {
        try {
            int resultado = 0;
            resultado = libroDAO.insert(libro);
            if(resultado==1){
                libros.add(libro);
                return 1;
            }
            return -1;
        } catch (RuntimeException e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para actualizar un libro
    public int actualizarLibro(Libro l) {
            int resultado = 0;
            resultado = libroDAO.update(l);
            if (resultado ==1){
                int indice = this.libros.indexOf(l);
                this.libros.set(indice,l);
                return 1;
            }
            return -1;
    }
    // Método para eliminar un libro por su ID
    public int eliminarLibro(Libro l) {
        try {
            int resultado = 0;
            resultado = libroDAO.delete(l.getID());
            if (resultado==1){
                libros.remove(l);
                return 1;
            }
            return -1;
        } catch (RuntimeException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los libros
    public ArrayList<Libro> obtenerLibros() {
            return libros;
    }

        // Método para asignar un autor a un libro (relación muchos a muchos)
        public int asignarAutorALibro (Libro_Autor la){
                int resultado = 0;
                resultado = libroAutorDAO.insert(la);
                if (resultado == 1) {
                    libroAutors.add(la);
                    return 1;
                }
                return -1;

        }

        // Método para obtener todos los libros con sus autores (usando la tabla intermedia)
        public ArrayList<Libro_Autor> obtenerLibrosConAutores () {
            return libroAutors; // Devuelve los libros relacionados con autores
        }

    // Método para agregar un nuevo autor
    public int agregarAutor(Autor a) {
        try {
            int resultado = 0;
            resultado = autorDAO.insert(a);
            if(resultado==1){
                autores.add(a);
                return 1;
            }
            return -1;
        } catch (RuntimeException e) {
            System.out.println("Error al agregar el autor: " + e.getMessage());
            return 0;
        }
    }

    // Método para actualizar un autor
    public int actualizarAutor(Autor a) {
        int resultado = 0;
        resultado = autorDAO.update(a);
        if (resultado ==1){
            int indice = this.autores.indexOf(a);
            this.autores.set(indice,a);
            return 1;
        }
        return -1;
    }

    // Método para eliminar un autor por su ID
    public int eliminarAutor(int id) {
        try {
            int resultado = 0;
            resultado = autorDAO.delete(id);
            if (resultado==1){
                autores.remove(id);
                return 1;
            }
            return -1;
        } catch (RuntimeException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los libros
    public ArrayList<Autor> obtenerAutores() {
        return autores;
    }
}


