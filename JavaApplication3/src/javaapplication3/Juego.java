package javaapplication3;

/**
 *
 * @author b03-12t
 */
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private int numeroAdivinar;
    private int maxIntentos;

    public Juego(int maxIntentos) {
        Scanner entrada=new Scanner(System.in);
        Random random = new Random();
        this.numeroAdivinar = random.nextInt(100) + 1;
        this.maxIntentos = entrada.nextInt();
    }

    public boolean adivinarNumero(int numero) {
        if (numero == numeroAdivinar) {
            return true;
        } else if (numero < numeroAdivinar) {
            System.out.println("El numero a adivinar es mayor");
        } else {
            System.out.println("El numero a adivinar es menor");
        }
        return false;
    }

    public boolean verificarVictoria(Jugador jugador) {
        if (jugador.getPuntaje() == 0) {
            System.out.println("Lo siento, has perdido. El numero a adivinar era " + numeroAdivinar);
            return false;
        } else {
            System.out.println("¡Felicidades, has adivinado el numero!");
            jugador.incrementarPuntaje();
            return true;
        }
    }
}
