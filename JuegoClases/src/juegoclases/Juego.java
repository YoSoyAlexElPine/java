package juegoclases;

import java.util.Random;
import javax.swing.JOptionPane;

public class Juego {

    int numeroAdivinar;
    int numeroIntroducido;
    int numeroIntentos;
    int rango;

    public Juego(int numeroIntentos, int rango) {
        this.numeroIntentos = numeroIntentos;
        this.rango = rango;
    }

    public Juego(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

    public Juego() {
        numeroIntentos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de intentos que vayas a querer"));
        rango = Integer.parseInt(JOptionPane.showInputDialog("Entre que rango de valores quieres generar el numero aleatorio"));
    }

    public void generar() {
        Random rnd = new Random();
        numeroAdivinar = rnd.nextInt(rango) + 1;
    }

    public void Leer() {
        numeroIntroducido = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero a adivinar, tienes " + numeroIntentos + " intentos restantes"));
    }

    public void comprovar() {
        if (numeroIntroducido == numeroAdivinar) {
            JOptionPane.showMessageDialog(null, "Has ganado");

        }
        if (numeroIntroducido > numeroAdivinar) {
            JOptionPane.showMessageDialog(null, "El numero es menor que " + numeroIntroducido);
            numeroIntentos--;
        }
        if (numeroIntroducido < numeroAdivinar) {
            JOptionPane.showMessageDialog(null, "Es mayor que " + numeroIntroducido);
            numeroIntentos--;
        }
    }

}
