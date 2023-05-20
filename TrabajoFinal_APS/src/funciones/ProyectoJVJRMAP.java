package funciones;

import java.util.Scanner;
import static funciones.FuncionesGenerales.*;

public class ProyectoJVJRMAP {

    
    public static void main(String[] args) {
    	Mapa mapa=new Mapa();
    	
    	mapa.dibujar();
    	
        int opc;
        boolean salir = false;
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        do {
           menu();
            opc = scanner.nextInt();
            System.out.println("");
            switch (opc) {
                case 1 -> {
                	
                }
                case 2 -> {	
                    menuTorre();
                }
                case 3 -> {
                    System.out.println("EN DESARROLLO");
                }
                default ->{
                    System.out.println("Opcion no disponible");
                }
            }
        } while (salir==false);
    
    }
private static void menu() {
	 System.out.println("""
	 		\t Las torres del hambre
	 		
	 		1. Jugar
	 		2. Crear torre
	 		3. Crear personaje
	 		
	 		""");

}
}  