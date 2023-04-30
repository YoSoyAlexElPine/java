/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete;

/**
 *
 * @author b03-12t
 */
public class BibliotecaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Libro li = new Libro(1960, 2435, "melon");

        Revista re = new Revista(1582, 2435, "lobulo");
        if (li.equals(re)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }

    private void publicacionesAnterioresA() {

    }

}
