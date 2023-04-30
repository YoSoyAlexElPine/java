package geometria;

import java.util.Scanner;

public class Geometria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;
        System.out.print("Opcion -> ");
        opc = scanner.nextInt();
        switch (opc) {
            case 1:
                System.out.print("Numero de circulos que quieras crear: ");
                int numCirculos = scanner.nextInt();
                char opc2;
                System.out.println("");
                Circulo[] circulos = new Circulo[numCirculos];
                for (int i = 0; i < numCirculos; i++) {
                    System.out.println("Circulo " + (i + 1));
                    System.out.print("Radio: ");
                    int radio = scanner.nextInt();
                    System.out.println("¿Añadir coordenadas? (S/N)");
                    do {
                        opc2 = scanner.next().charAt(0);
                    } while (opc2 != 'S' && opc2 != 'N');

                    if (opc2 == 'S') {
                        System.out.print("Coordenada x: ");
                        int coordenadax = scanner.nextInt();
                        System.out.print("Coordenada y: ");
                        int coordenaday = scanner.nextInt();
                        System.out.println("");
                        Circulo cirs = new Circulo(radio, coordenadax, coordenaday);
                        circulos[i] = cirs;
                    } else {
                        Circulo cirs = new Circulo(radio);
                        circulos[i] = cirs;
                    }
                }
                for (int i = 0; i < circulos.length; i++) {
                    System.out.println("Circulo numero "+(i+1));
                    circulos[i].datos();
                }
            case 2:
                System.out.println("Mete el lado");
                int lado=scanner.nextInt();
                Cuadrado cua=new Cuadrado (lado);
                cua.datos();
            case 3:
                
        }
    }

}
