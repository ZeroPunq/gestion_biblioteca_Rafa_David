package Servicio;

import Clases.src.Libro;
import Clases.src.Libro_Autor;
import DAO.src.LibroDAO;
import DAO.src.Libro_AutorDAO;

import java.util.ArrayList;

public class LibroService {
    private LibroDAO libroDAO;
    private Libro_AutorDAO libroAutorDAO;

    // Constructor
    public LibroService() {
        this.libroDAO = new LibroDAO();
        this.libroAutorDAO = new Libro_AutorDAO();
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
            return libroAutorDAO.insert(new Libro(idLibro, "", ""));
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
}
