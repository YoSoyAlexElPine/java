package clases;

import static clases.Utilidades.*;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author KRene
 */
public class BuscaminasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        int opc, intentos = 0;
        int[] opciones;
        String nombre;
        Scanner read = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tablero tablero = new Tablero(5, 5, 5);
        System.out.println("Escribe un nombre para jugar");
        nombre = br.readLine();
        Jugador jugador = new Jugador(nombre);
        tablero.generarMinas();
        tablero.generarNumeros();
        System.out.println("");
        intentos = (tablero.getSizeX() * tablero.getSizeY()) - tablero.getMina();
        opciones = new int[intentos];
        do {
            cls();
            do {
                System.out.print("Tu puntaje es: " + jugador.getPuntaje());
                System.out.println("");
                tablero.tableroJugador();
                System.out.print("\nEscribe la opcion que quieras escoger...");
                opc = Integer.parseInt(br.readLine());
            } while (opc > (tablero.getSizeX() * tablero.getSizeY()) - 1 || opc < 0);
            tablero.opcionJugador(opc);
            tablero.mostrarCeros();
            jugador.setPuntaje(jugador.getPuntaje() + 10);
        } while (!tablero.ganador() && tablero.acierto(opc));
        if (tablero.casillas.get(opc).isEstado()) {
            if (tablero.casillas.get(opc) instanceof Mina) {
                System.out.println("Lo siento perdiste");
            } else {
                System.out.println("Felicidades ganaste!");
            }
        }
        tablero.imprimirTablero();
    }

}
