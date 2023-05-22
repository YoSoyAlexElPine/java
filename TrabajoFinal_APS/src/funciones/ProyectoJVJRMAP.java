package funciones;

import java.io.IOException;

import Objetos.Mapa;

import static funciones.FuncionesGenerales.*;

public class ProyectoJVJRMAP {

    
    public static void main(String[] args) throws NumberFormatException, IOException {	
        int opc;
        boolean salir = false;
        do {
           menu();
            opc = FuncionesGenerales.brInt("Introduce una opcion ");
            System.out.println("");
            switch (opc) {
                case 1 -> {
                	System.out.println("HOla mundo");
                }
                case 2 -> {	
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