package clases;

import static clases.Utilidades.*;

/**
 *
 * @author KRene
 */
public class Mina extends Casillas implements Dibujable {

    public Mina(boolean estado, int posicionX, int posicionY) {
        super(estado, posicionX, posicionY);
    }

    public Mina(int posicionX, int posicionY) {
        super(posicionX, posicionY);

    }

    public Mina() {
    }

    public boolean explotar() {
        return false;
    }

    @Override
    public void dibujar() {
        System.out.print(RED + "\t[ X ]");
    }

    public void generar() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Casillas o) {
        return super.compareTo(o);
    }

}
