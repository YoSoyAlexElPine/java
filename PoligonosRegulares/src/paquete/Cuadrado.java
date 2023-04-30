package paquete;

public class Cuadrado extends PoligonosRegulares implements Dibujable {

    final int numLados = 4;
    boolean relleno=false;
    public Cuadrado() {
        lado = 5;
    }

    public Cuadrado(int lado, String color) {
        this.lado = lado;
        this.color = color;
    }

    public Cuadrado(int lado) {
        this.lado = lado;

    }

    public int obtenerArea() {
        int area = lado * lado;
        return area;
    }

    public int obtenerPerimetro() {
        System.out.println("Calculando perimetro");
        int perimetro = lado * numLados;
        return perimetro;
    }

    public void dibujar() {
        if (relleno == false) {
            for (int i = 0; i < lado; i++) {
                if (i == 0 || i == lado-1) {
                    for (int j = 0; j < lado; j++) {
                        System.out.print("* ");
                    }
                } else {
                    System.out.print("* ");
                    for (int j = 0; j < lado - 2; j++) {
                        System.out.print("  ");
                    }
                    System.out.print("* ");
                }
                System.out.println("");
            }
            }else{
                for (int j = 0; j <lado; j++) {
                    for (int k = 0; k <lado; k++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
            }
        }
    }

