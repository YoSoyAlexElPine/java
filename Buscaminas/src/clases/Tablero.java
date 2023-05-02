package clases;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author KRene
 */
public class Tablero {

    private int sizeX, mina, sizeY;
    public ArrayList<Casillas> casillas = new ArrayList<Casillas>();
    public ArrayList<Numero> numeros = new ArrayList<Numero>();
    public ArrayList<Mina> minas = new ArrayList<Mina>();

    public Tablero(int sizeX, int mina, int sizeY) {
        this.sizeX = sizeX;
        this.mina = mina;
        this.sizeY = sizeY;
    }

    public int posicion() {
        int area = sizeX;
        return (int) ((Math.random() * area) + 1);
    }

    public void generarMinas() {
        for (int i = 0; i < this.mina;) {
            Mina bomb = new Mina();
            bomb.setPosicionX(this.posicion());
            bomb.setPosicionY(this.posicion());
            if (revisarLista(bomb)) {
                casillas.add(bomb);
                minas.add(bomb);
                i++;
            }
        }
    }

    public void tableroJugador() {
        int cont = 0;
        Collections.sort(casillas);
        for (int i = 0; i < this.getSizeY(); i++) {
            if (casillas.get(cont).isEstado()) {
                casillas.get(cont).dibujar();
            } else {
                System.out.print("\t[  ] " + cont);
            }

            cont++;
            for (int j = 1; j < this.getSizeX(); j++) {
                if (casillas.get(cont).isEstado()) {
                    casillas.get(cont).dibujar();
                } else {
                    System.out.print("\t[  ] " + cont);
                }

                cont++;
            }
            System.out.println("");
        }
    }

    public void opcionJugador(int opc) {
        Collections.sort(casillas);
        if (casillas.get(opc).isEstado()) {
            System.out.println("Esa casilla ya la usaste");
        } else {

            casillas.get(opc).setEstado(true);
        }

    }

    public void mostrarCeros() {
        boolean cambiar = false;
        for (Casillas casilla : casillas) {
            if (casilla instanceof Numero numero) {
                if (numero.getValor() == 0 && !numero.isEstado()) {
                    cambiar = true;
                }
            }
            if (cambiar) {
                casilla.setEstado(true);
            }
            cambiar = false;
        }
    }

    public void ocultarTablero() {
        int cont = 0;
        for (int i = 0; i < sizeY; i++) {
            System.out.print("\t[   ] " + cont);
            cont++;
            for (int j = 1; j < sizeX; j++) {
                System.out.print("\t[   ] " + cont);
                cont++;
            }
            System.out.println("");
        }
    }

    public void imprimirTablero() {
        int cont = 0;
        Collections.sort(casillas);
        for (int i = 0; i < this.getSizeY(); i++) {
            casillas.get(cont).dibujar();
            cont++;
            for (int j = 1; j < this.getSizeX(); j++) {
                casillas.get(cont).dibujar();
                cont++;
            }
            System.out.println("");
        }
    }

    public void generarNumeros() {
        int total, num, x = 0, y = 0;
        int cont = 0;
        total = (sizeX * sizeY) - mina;
        for (int i = 0; i < total;) {
            Numero numero = new Numero();
            numero.setPosicionX(this.posicion());
            numero.setPosicionY(this.posicion());
            if (revisarLista(numero)) {
                numeros.add(numero);
                casillas.add(numero);
                i++;
            }
        }

        for (Numero numero : numeros) {
            cont = 0;
            for (Mina mina1 : minas) {
                num = numero.generarNum(mina1.getPosicionX(), mina1.getPosicionY());
                cont = cont + num;
            }
            numero.setValor(cont);
        }
    }

    public boolean acierto(int opc) {
        if (casillas.get(opc) instanceof Mina) {
            return false;
        }
        return true;
    }

    public boolean ganador() {
        boolean ganador = false;
        int cont=0;
        for (Casillas casilla : casillas) {
            if (casilla instanceof Numero) {
                if (casilla.isEstado()) {
                    cont++;
                }
            }
        }
        if (cont==numeros.size()) {
            ganador=true;
        }
        return ganador;
    }

    private boolean revisarLista(Casillas bomb) {
        boolean check = true;
        //Recorre la lista para saber si esa mina fue escrita antes
        for (Casillas mina1 : casillas) {
            if (mina1.equals(bomb)) {
                check = false;
            }
        }
        return check;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getMina() {
        return mina;
    }

    public void setMina(int mina) {
        this.mina = mina;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public ArrayList<Casillas> getMinas() {
        return casillas;
    }

    public void setMinas(ArrayList<Casillas> minas) {
        this.casillas = minas;
    }

    @Override
    public String toString() {
        return "Tablero{" + "sizeX=" + sizeX + ", mina=" + mina + ", sizeY=" + sizeY + ", minas=" + casillas + '}';
    }

}
