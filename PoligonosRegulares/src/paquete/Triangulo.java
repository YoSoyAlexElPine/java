/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

public class Triangulo extends PoligonosRegulares implements Dibujable {

    final int numLados = 3;

    public Triangulo() {
        lado = 5;
        relleno = true;
    }

    public Triangulo(int lado) {
        this.lado = lado;
        relleno = true;
    }

    public Triangulo(int lado, String color) {
        this.lado = lado;
        this.color = color;
        relleno = true;
    }

    public int obtenerArea() {
        int area = (lado * lado) / 2;
        return area;
    }

    public int obtenerPerimetro() {
        System.out.println("Calculando perimetro");
        int perimetro = lado * numLados;
        return perimetro;
    }

    @Override
    public void dibujar() {
        if (relleno == true) {
            for (int i = 0; i < lado + 1; i++) {
                for (int j = 0; j < lado - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
        } else {
            boolean aux = false, aux2 = false;

            for (int i = 0; i < lado; i++) {
                for (int j = 0; j < lado - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < i; j++) {
                    if (j == i - 1) {
                        if (aux2 == true) {
                            System.out.print("* ");
                        }

                    }
                    if (aux == false) {
                        System.out.print("* ");
                        aux = true;
                    } else {
                        System.out.print("  ");
                    }
                    aux2 = true;
                }
                aux = false;
                System.out.println("");
            }
            for (int i = 0; i < lado; i++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
