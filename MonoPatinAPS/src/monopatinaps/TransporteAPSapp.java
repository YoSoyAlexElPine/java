/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopatinaps;

import java.util.Scanner;
import monopatinaps.clasesAPS.Transporte;

/**
 *
 * @author b03-12t
 */
public class TransporteAPSapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(4.99999999999999);

        //Variables y asigancion de datos
        int aux1, aux2, aux3;
        String str1, str2;

        Transporte array[] = new Transporte[3];
        Scanner scanner = new Scanner(System.in);

        Transporte trans1 = new Transporte();
        Transporte trans2 = new Transporte("5247-CIU", "Buen transporte");
        Transporte trans3 = new Transporte(4, 12000, "2493", "Muy rapido", false);

        //Datos Vehiculo 1
        do {
            System.out.println("Introduce tu valoracion del vehiculo 1");
            aux1 = scanner.nextInt();
        } while (aux1 > 5 || aux1 < 0);
        trans1.setValoracion(aux1);

        System.out.println("Precio del vehiculo 1");
        aux2 = scanner.nextInt();
        trans1.setPrecio(aux2);

        System.out.println("Referencia del vehiculo 1");
        str1 = scanner.nextLine();
        str1 = scanner.nextLine();
        trans1.setReferencia(str1);

        System.out.println("Descripcion del vehiculo 1");
        str2 = scanner.nextLine();
        trans1.setDescripcion(str2);

        do {
            System.out.println("Es electrico (0 = no; 1 = si)");
            aux3 = scanner.nextInt();
        } while (aux3 > 1 || aux3 < 0);
        if (aux3 == 1) {
            trans1.setElectrico(true);
        } else {
            trans1.setElectrico(false);
        }

        //Datos Vehiculo 2
        do {
            System.out.println("Introduce tu valoracion del vehiculo 2");
            aux1 = scanner.nextInt();
        } while (aux1 > 5 || aux1 < 0);
        trans2.setValoracion(aux1);

        System.out.println("Precio del vehiculo 2");
        aux2 = scanner.nextInt();
        trans2.setPrecio(aux2);

        do {
            System.out.println("Es electrico (0 = no; 1 = si)");
            aux3 = scanner.nextInt();
        } while (aux3 > 1 || aux3 < 0);
        if (aux3 == 1) {
            trans2.setElectrico(true);
        } else {
            trans2.setElectrico(false);
        }

        //Datos vehiculo 3
        do {
            System.out.println("Cambia la valoracion del vehiculo 3");
            aux1 = scanner.nextInt();
        } while (aux1 > 5 || aux1 < 0);
        trans3.setValoracion(aux1);

        System.out.println("Cambia el precio del vehiculo 3");
        aux2 = scanner.nextInt();
        trans3.setPrecio(aux2);

        do {
            System.out.println("Es electrico (0 = no; 1 = si)");
            aux3 = scanner.nextInt();
        } while (aux3 > 1 || aux3 < 0);
        if (aux3 == 1) {
            trans3.setElectrico(true);
        } else {
            trans3.setElectrico(false);
        }

        //Arrays
        array[0] = trans1;
        array[1] = trans2;
        array[2] = trans3;

        //Mustra por pantalla de datos
        for (int i = 0; i < array.length; i++) {
            array[i].datos();
        }
        System.out.println("Objetos creados: " + trans3.cont);

    }

}
