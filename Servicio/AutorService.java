package Servicio;


import Clases.src.Autor;
import Clases.src.Libro;
import Clases.src.Libro_Autor;
import DAO.src.AutorDAO;
import DAO.src.Libro_AutorDAO;

import java.util.ArrayList;

public class AutorService {
    private AutorDAO autorDAO;
    private Libro_AutorDAO libroAutorDAO;

    // Constructor
    public AutorService() {
        this.autorDAO = new AutorDAO();
        this.libroAutorDAO = new Libro_AutorDAO();
    }

    // Método para agregar un nuevo autor
    public int agregarAutor(Autor autor) {
        try {
            return autorDAO.insert(autor);
        } catch (RuntimeException e) {
            System.out.println("Error al agregar el autor: " + e.getMessage());
            return 0;
        }
    }

    // Método para actualizar un autor
    public int actualizarAutor(Autor autor) {
        try {
            return autorDAO.update(autor);
        } catch (RuntimeException e) {
            System.out.println("Error al actualizar el autor: " + e.getMessage());
            return 0;
        }
    }

    // Método para eliminar un autor por su ID
    public int eliminarAutor(int id) {
        try {
            return autorDAO.delete(id);
        } catch (RuntimeException e) {
            System.out.println("Error al eliminar el autor: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los autores
    public ArrayList<Autor> obtenerAutores() {
        try {
            return autorDAO.selectAll();
        } catch (RuntimeException e) {
            System.out.println("Error al obtener los autores: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Método para asignar un libro a un autor (relación muchos a muchos)
    public int asignarLibroAAutor(int idAutor, int idLibro) {
        try {
            return libroAutorDAO.insert(new Libro(idLibro,));
        } catch (RuntimeException e) {
            System.out.println("Error al asignar el libro al autor: " + e.getMessage());
            return 0;
        }
    }

    // Método para obtener todos los autores con sus libros
    public ArrayList<Libro_Autor> obtenerAutoresConLibros() {
        try {
            return libroAutorDAO.selectAll();  // Devuelve los autores relacionados con libros
        } catch (RuntimeException e) {
            System.out.println("Error al obtener autores con libros: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
