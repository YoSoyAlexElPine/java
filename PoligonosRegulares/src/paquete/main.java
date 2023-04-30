/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete;

/**
 *
 * @author b03-12t
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo tr1 = new Triangulo();
        Triangulo tr2 = new Triangulo(10, "Verde");
        Cuadrado cua1 = new Cuadrado(5);
        System.out.println("----- Triangulo numero 1 -----");
        System.out.println("Perimetro = " + tr1.obtenerPerimetro());
        System.out.println("Area = " + tr1.obtenerArea());
        System.out.println("");
        System.out.println("----- Triangulo numero 2 -----");
        System.out.println("Perimetro = " + tr2.obtenerPerimetro());
        System.out.println("Area = " + tr2.obtenerArea());
        System.out.println("");
        System.out.println("----- Cuadrado numero 1 -----");
        System.out.println("Perimetro = " + cua1.obtenerPerimetro());
        System.out.println("Area = " + cua1.obtenerArea());
        System.out.println("----- Dibujo -----");
        tr2.dibujar();
        System.out.println(tr1.color);
    }

}
