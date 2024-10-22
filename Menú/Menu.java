package Menú;

import Clases.src.*;
import Servicio.BibliotecaService;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Scanner sc= new Scanner(System.in);
    public BibliotecaService bs = new BibliotecaService();

    public void menu(){
        int op;
        do{
            System.out.println("Menú");
            System.out.println("1.Menu Autor");
            System.out.println("2.Menu Libro");
            System.out.println("3.Menu Prestamo");
            System.out.println("4.Menu Usuario");
            System.out.println("5 Menu Libro_Autor");
            System.out.println("0.Salir");
            op= sc.nextInt();

            switch (op){

                case 1 :
                    menuAutor();
                    break;
                case 2 :
                    menuLibro();
                    break;
                case 3 :
                    menuPrestamo();
                    break;
                case 4 :
                    menuUsuario();
                    break;
                case 5 :
                    menuLibro_Autor();
                    break;
                case 0 :
                    System.out.println("Saliendo...");
                    break;
            }
        }while(op!=0);
    }

    public void menuPrestamo(){
        int op;
        do{
            System.out.println("Menu Prestamo");
            System.out.println("1.- Añadir Prestamo");
            System.out.println("2.- Ver Prestamos");
            System.out.println("3.- Borrar Prestamos");
            System.out.println("0.- Volver al menu principal");

            op =sc.nextInt();
            switch (op){
                case 1:

                    System.out.println("Inserte datos del Prestamo (ID,Fecha Inicio(YYYY-MM-DD), Fecha Fin(YYYY-MM-DD), Id Usuario , Id Libro) :");
                    bs.insertPrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 2 :
                    System.out.println(bs.selectPrestamos());
                    break;
                case 3 :
                    System.out.println("Introduce el prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 0 :
                    menu();
                    break;
            }
        }while (op!=0);
    }
    public void menuLibro(){
        int op;
        do{
            System.out.println("Menu Libro");
            System.out.println("1.- Añadir Libro");
            System.out.println("2.- Ver Libros");
            System.out.println("3.- Modificar Libros");
            System.out.println("4.- Borrar Libros");
            System.out.println("0.- Volver al menu principal");

            op =sc.nextInt();
            switch (op){
                case 1:

                    System.out.println("Inserte datos del Libro (ID,Titulo, ISBN) :");
                    System.out.println("ID:");
                    int idl = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nombre:");
                    String til =sc.nextLine();
                    System.out.println("ISBN:");
                    String isbnl =sc.nextLine();
                    bs.agregarLibro(new Libro(idl,til,isbnl));
                    break;
                case 2 :
                    System.out.println(bs.obtenerLibros());
                    break;
                case 3 :
                    System.out.println("Introduce los datos del libro a modificar. (ID y Nombre)");
                    bs.actualizarLibro(new Libro(sc.nextInt(),sc.nextLine(),sc.nextLine()));
                    break;
                case 4:
                    System.out.println("Introduce la id del libro a eliminar");
                    bs.eliminarLibro(new Libro(sc.nextInt(),sc.nextLine(),sc.nextLine()));
                    break;
                case 0 :
                    menu();
                    break;
            }
        }while (op!=0);
    }
    public void menuUsuario(){
        int op;
        do{
            System.out.println("Menu Usuario");
            System.out.println("1.- Añadir Usuario");
            System.out.println("2.- Ver Usuario");
            System.out.println("3.- Modificar Usuario");
            System.out.println("4.- Borrar Usuarios");
            System.out.println("0.- Volver al menu principal");

            op =sc.nextInt();
            switch (op){
                case 1:

                    System.out.println("Inserte datos del Usuario (ID,Nombre) :");
                    bs.insertUsuario(new Usuario(sc.nextInt(), sc.nextLine()));
                    break;
                case 2 :
                    System.out.println(bs.selectUsuario());
                    break;
                case 3 :
                    System.out.println("Introduce el Usuario a modificar");
                   bs.updateUsuario(new Usuario(sc.nextInt(), sc.nextLine()));
                    break;
                case 4:
                    System.out.println("Introduce el Usuario a eliminar");
                   bs.deleteUsuario(new Usuario(sc.nextInt(), sc.nextLine()));
                    break;
                case 0 :
                    menu();
                    break;
            }
        }while (op!=0);
    }
    public void menuAutor(){
        int op;
        do{
            System.out.println("Menu Autor");
            System.out.println("1.- Añadir Autor");
            System.out.println("2.- Ver Autores");
            System.out.println("3.- Modificar Autores");
            System.out.println("4.- Borrar Autores");
            System.out.println("0.- Volver al menu principal");

            op =sc.nextInt();
            switch (op){
                case 1:

                    System.out.println("Inserte datos del Autor(ID, Nombre) :");
                    System.out.println("ID");
                    int ida = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nombre");
                    String a =sc.nextLine();
                    bs.agregarAutor(new Autor(ida,a));
                    break;
                case 2 :
                    System.out.println(bs.obtenerAutores());
                    break;
                case 3 :
                    System.out.println("Introduce los datos a modificar. (ID y Nombre)");
                    System.out.println("ID");
                    int ida1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nombre");
                    String a1 =sc.nextLine();
                    bs.actualizarAutor(new Autor(ida1, a1));
                    break;
                case 4:
                    System.out.println("Introduce la id del autor eliminar");
                    bs.eliminarAutor(new Autor(sc.nextInt(),sc.nextLine()));
                    break;
                case 0 :
                    menu();
                    break;
            }
        }while (op!=0);
    }

    public void menuLibro_Autor() {
        int op;
        do {
            System.out.println("Menu Libro_Autor");
            System.out.println("1.- Asignar un Autor a un Libro");
            System.out.println("2.- Ver todos los Libros y sus Autores");
            System.out.println("0.- Volver al menu principal");

            op = sc.nextInt();
            switch (op) {
                case 1:

                    System.out.println("Inserte el Libro (ID_Libro) y el Autor(ID_Autor):");
                    bs.asignarAutorALibro(new Libro_Autor(sc.nextInt(), sc.nextInt()));
                    break;
                case 2:
                    System.out.println(bs.obtenerLibrosConAutores());
                    break;
                case 0:
                    menu();
                    break;
            }
        } while (op != 0);
    }
}
