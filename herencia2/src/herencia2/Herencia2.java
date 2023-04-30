package herencia2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Herencia2 {

    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1;
        int num, num2, num3, opc, opc2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dime el nombre para tu animal: ");
        string1 = br.readLine();
        tabla();
        opc2 = Integer.parseInt(br.readLine());
        Animal pr = null;
        switch (opc2) {
            case 1:
                pr = new Perro(string1);
                break;
            case 2:
                pr = new Gato(string1);
                break;
            case 3:
                pr = new Pajaro(string1);
                break;
            case 4:
                System.out.println("Indica la velocidad de tu animal");
                num = Integer.parseInt(br.readLine());
                do {
                    System.out.println("Indica que tan rapido se cansa tu animal");
                    num2 = Integer.parseInt(br.readLine());
                } while (num2 < 1);
                do {
                    System.out.println("Indica el hambre que va ha tener");
                    num3 = Integer.parseInt(br.readLine());
                } while (num3 < 1);
                pr = new Pers(string1, num, num2, num3);
                break;
        }
        do {
            menu();
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    pr.comer();

                    menu();
                    System.out.println("");
                    System.out.print("Avance: " + pr.avance + " Hambre: " + pr.hambre + " Sueño: " + pr.sueño);
                    System.out.println("");
                    break;
                case 2:
                    pr.dormir();

                    menu();
                    System.out.println("");
                    System.out.print("Avance: " + pr.avance + " Hambre: " + pr.hambre + " Sueño: " + pr.sueño);
                    System.out.println("");
                    break;
                case 3:
                    do{
                    for (int i = 0; i < 10; i++) {
                     
                                  pr.avanzar();
                            System.out.println();
                            Thread.sleep(500);
                    }
              
                        } while (pr.hambre>0 || pr.sueño>0);
                    break;

            }
        } while (pr.hambre > 0 && pr.sueño > 0);
        System.out.println(pr.nombre + " ha muerto a la edad de " + pr.edad);
        System.out.println(pr.nombre + " ha avanzado " + pr.avance + " casillas");
    }

    private static void menu() {
        System.out.println("""
                           -------------------
                           - 1. Comer
                           - 2. Dormir
                           - 3. Avanzr
                           -------------------
                           """);
    }

    private static void tabla() {
        System.out.println("""
                           --------------------------
                           - 1. Perrro
                           - 2. Gato
                           - 3. Pajaro
                           - 4. Animal Persomalizado
                           --------------------------""");
    }
}
