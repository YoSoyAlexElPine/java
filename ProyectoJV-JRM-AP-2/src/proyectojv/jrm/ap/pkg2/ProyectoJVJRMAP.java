package proyectojv.jrm.ap.pkg2;

import java.util.Scanner;
import static proyectojv.jrm.ap.pkg2.FuncionesGenerales.*;

public class ProyectoJVJRMAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
       // Mazmorra piso1 = new Mazmorra(10, "ZonaInicial", Hostilidad.AMISTOSA);
        //Mazmorra piso2 = new Mazmorra(5, "ZonaInicial", Hostilidad.AMISTOSA);
        do {
            System.out.println("Introduce una opcion");
            System.out.println("1. Mazmorra ");
            System.out.println("2. Torre ");
            System.out.println("3. Casa encantada ");
            System.out.println("                    ");
            System.out.println("0. Salir ");
            opc = teclado.nextInt();
            System.out.println("");
            switch (opc) {
                case 1 -> {
                    FuncionesGenerales.menuMazmorra();
                }
                case 2 -> {
                    FuncionesGenerales.menuTorre();
                }
                case 3 -> {
                    System.out.println("EN DESARROLLO");
                }
        } while (!salir);

    }