package Menú;

import Servicio.BibliotecaService;

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
            }
        }while(op!=0);
    }
}
