/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

//import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JoseVi
 */
public class FuncionesGenerales {


    public static void menuTorre() {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int opc = 0, opc2 = 0,fuerza=999999999;
        Torre torre1 = null;
        System.out.println("""
                           1. Generar torre aleatoria
                           2. Crear torre personalizada
                           """);
        try {
            System.out.print("Introduzca una opción: ");
            opc2 = scanner.nextInt();
            System.out.println("Opción introducida: " + opc2);
        } catch (Exception e) {
            System.out.println("Error: debe introducir un valor numérico.");
        }
        if (opc2 == 1) {
            torre1 = generarTorre();
        } else {
           torre1=crearTorre(); 
        }

        do {
            System.out.println("""
                               
                           === Elige Opcion ===
                           
                           1. Inspeccionar
                           2. Saquear
                           3. Conquistar
                           4. Comerciar
                           5. Dibujar
                           6. Evento aleatorio
                           
                           0. Salir
                               
                           """);
            try {
                System.out.print("Introduzca una opción: ");
                opc = scanner.nextInt();
                System.out.println("Opción introducida: " + opc);
            } catch (Exception e) {
                System.out.println("Error: debe introducir un valor numérico.");
            }

            switch (opc) {
                case 1 ->torre1.investigar();
                case 2 ->torre1.saquear();
                case 3 ->torre1.conquistar(fuerza);
                case 4 ->torre1.comerciar(100,"cerdos");           
                case 5 ->torre1.dibujar();
                case 6 ->torre1.generarEventoAleatorio();
                /*case 6 ->{
                	cerdos=cerdos+cazarCerdos();
                	System.out.println("Tienes "+cerdos+" cerdos.");
                }
                case 7->{
                	inventario(dinero,cerdos,fuerza);
                	System.out.println("");
                }
                case 8->{
                	int opcArmas=0;
                	do {
					int precioArma=0,fuerzaArma=0;
                	System.out.println("""
                			=== Tienda de armas ===
                			1. Espada de madera - 100 dinero - 10 fuerza
                			2. Espada de hierro - 500 dinero - 100 fuerza
                			3. Espada de adamatium - 10.000 dinero - 20.000 fuerza
                			
                			Eleccion (0 para salir) -> """);
                	opcArmas=teclado.nextInt();
                	switch (opcArmas) {
                	case 0:{
                		break;
                	}
					case 1: {
						precioArma=100;
						fuerzaArma=10;
						break;
					}
					case 2: {
						precioArma=500;
						fuerzaArma=100;
						break;
					}
					case 3: {
						precioArma=10000;
						fuerzaArma=20000;
						break;
					}
					default:
						throw new IllegalArgumentException("Valor incorrecto: " + opcArmas);
					}
                	if (dinero-precioArma<0) {
						System.out.println("Mas te gustaria a ti pero no tienes dinero suficiente.");
					} else {
						dinero=dinero-precioArma;
						fuerza=fuerza+fuerzaArma;
						inventario(dinero,cerdos,fuerza);
					}
    				} while (opcArmas!=0);
                	
                }
                case 9->{
                	System.out.println(torre1.getTamanio()+" metros.");
                }*/
            }
        } while (opc != 0);
    }
    /*private static int cazarCerdos() {
		int cerdos=(int)(Math.random()*5);
		if (cerdos<1) {
			System.out.println("Parece que no hubo suerte, o punteria.");
		} else {
			System.out.println("Tu caza ha dado frutos.");
		}
		System.out.println("Has cazado "+cerdos+" cerdos");
		return cerdos;
	}*/

	private static Torre generarTorre() {
        int numPlanta, botin, poder,oferta;
        boolean fortificado;
        Hostilidad hostilidad = null;
        numPlanta = (int) (Math.random() * 10);
        botin = (int) (Math.random() * 10000);
        oferta=(int) (Math.random()*500);
        poder = (int) (Math.random() * 1000);
        int aux = (int) (Math.random()); if (aux == 1) { fortificado = false;} else {fortificado = true;}
        
    
        int aux2 = (int) (Math.random() * 3);
        switch (aux2) {
            case 0 -> hostilidad = Hostilidad.AMISTOSA;
            case 1 -> hostilidad = Hostilidad.PASIVA;
            case 2 -> hostilidad = Hostilidad.HOSTIL;
            case 3 -> hostilidad = Hostilidad.HOSTIL;
        }
        Torre torre = new Torre(numPlanta,poder,botin,oferta,"Elfica","Norte",  fortificado, false, hostilidad);
        return torre;
}
    private static Torre crearTorre() {
    	int numPlantas,botin,aux,aux2;
    	@SuppressWarnings("resource")
		Scanner teclado=new Scanner (System.in);
    	Hostilidad aux3=null;
    	boolean fort;
    	System.out.println("Introducce numero de plantas");
        numPlantas = teclado.nextInt();
        System.out.println("Introdicce el botin que tendra tu torre");
        botin = teclado.nextInt();
        System.out.println("Esta fortificada? 0 = no, 1 = si");
        aux = teclado.nextInt();
        System.out.println("Como es su temperamento? 0 = amistoso | 1 = neutral | 2 = hostil | 3 = tuyo");
        aux2=teclado.nextInt();
        switch (aux2) {
        	case 0-> aux3=Hostilidad.AMISTOSA;
        	case 1-> aux3=Hostilidad.PASIVA;
        	case 2-> aux3=Hostilidad.HOSTIL;
        	case 3-> aux3=Hostilidad.TUYA;
        }
        
        if (aux == 0) {
            fort = false;
        } else {
            fort = true;
        }
        Torre torre = new Torre(numPlantas,100,botin,200,"Humana","Oeste", fort,false,aux3);
        return torre;
    }
    /*private static void inventario(int dinero,int cerdos,int fuerza) {
    	System.out.println("=== Inventario ===");
    	System.out.println("Dinero = "+dinero);
    	System.out.println("Cerdos = "+cerdos);
    	System.out.println("");
    	System.out.println("Fuerza = "+fuerza);
    	System.out.println(".");
    }*/

}
 