/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buscaminas;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        int array[][]=new int [5][5];
        Scanner scanner=new Scanner(System.in);
        Buscaminas bm=new Buscaminas(5);
        menu();
        for (int i = 0; i < 10; i++) {
            System.out.println(i); 
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=j;
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
        System.out.println(bm.minas);
        bm.tablero();
        do {
                 bm.click();   
        } while (bm.click()==false);

    }
 private static void menu(){
     System.out.println("""
                        1. Facil
                        2. Medio
                        3. Dificil
                        """);
 }   
}
