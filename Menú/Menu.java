package Menú;

import Clases.src.Prestamo;
import Servicio.BibliotecaService;

import java.sql.Date;
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
                    System.out.println("Introduce la id del prestamo a eliminar");
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
            System.out.println("1.- Añadir Prestamo");
            System.out.println("2.- Ver Prestamos");
            System.out.println("3.- Modificar Prestamos");
            System.out.println("4.- Borrar Prestamos");
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
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 4:
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
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
            System.out.println("Menu Libro");
            System.out.println("1.- Añadir Prestamo");
            System.out.println("2.- Ver Prestamos");
            System.out.println("3.- Modificar Prestamos");
            System.out.println("4.- Borrar Prestamos");
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
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 4:
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
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
            System.out.println("Menu Libro");
            System.out.println("1.- Añadir Prestamo");
            System.out.println("2.- Ver Prestamos");
            System.out.println("3.- Modificar Prestamos");
            System.out.println("4.- Borrar Prestamos");
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
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 4:
                    System.out.println("Introduce la id del prestamo a eliminar");
                    bs.deletePrestamo(new Prestamo(sc.nextInt(),Date.valueOf(sc.nextLine()),Date.valueOf(sc.nextLine()),sc.nextInt(), sc.nextInt()));
                    break;
                case 0 :
                    menu();
                    break;
            }
        }while (op!=0);
    }


}
