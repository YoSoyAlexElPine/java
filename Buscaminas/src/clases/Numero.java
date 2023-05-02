package clases;
import static clases.Utilidades.*;

/**
 *
 * @author KRene
 */
public class Numero extends Casillas implements Dibujable{

    private int valor;

    public Numero(boolean estado, int posicionX, int posicionY) {
        super(estado, posicionX, posicionY);

    }

    public Numero() {
    }

    public int generarNum(int x, int y) {

        //Eje X
        if (x == this.getPosicionX() && y + 1 == this.getPosicionY()) {
            return 1;
        }
        if (x == this.getPosicionX() && y - 1 == this.getPosicionY()) {
            return 1;
        }
        //Eje Y
        if (y == this.getPosicionY() && x + 1 == this.getPosicionX()) {
            return 1;
        }
        if (y == this.getPosicionY() && x - 1 == this.getPosicionX()) {
            return 1;
        }
        //Diagonal 1
        if (y + 1 == this.getPosicionY() && x + 1 == this.getPosicionX()) {
            return 1;
        }
        if (y - 1 == this.getPosicionY() && x - 1 == this.getPosicionX()) {
            return 1;
        }

        //Diagonal 2
        if (x - 1 == this.getPosicionX() && y + 1 == this.getPosicionY()) {
            return 1;
        }

        if (y - 1 == this.getPosicionY() && x + 1 == this.getPosicionX()) {
            return 1;
        }
        return 0;
    }

    //GETTERS AND SETTERS
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void dibujar() {
        System.out.print(GREEN+"\t[ " + this.getValor() + " ]"+BLACK);
    }

}
