package proyectojv.jrm.ap;

import java.util.Scanner;
import static proyectojv.jrm.ap.FuncionesGenerales.*;

public class ProyectoJVJRMAP {

    
    public static void main(String[] args) {
        int opc;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        do {
           menu();
            opc = teclado.nextInt();
            System.out.println("");
            switch (opc) {
                case 1 -> {
                    menuMazmorra();
                }
                case 2 -> {	
                    menuTorre();
                }
                case 3 -> {
                    System.out.println("EN DESARROLLO");
                }
                case 0 -> {
                    salir = true;
                    break;
                }
                default ->{
                    System.out.println("Opcion no disponible");
                }
            }
        } while (salir==false);
    
    }
private static void menu() {
	 System.out.println("Introduce una opcion");
     System.out.println("1. Mazmorra ");
     System.out.println("2. Torre ");
     System.out.println("3. Casa encantada ");
     System.out.println("                    ");
     System.out.println("0. Salir ");
     System.out.print("Eleccion -> ");
}
}  