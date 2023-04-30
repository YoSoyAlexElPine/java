package romanos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author b03-12t
 */
public class Romanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int matriz[]=new int [3];
        Scanner scanner = new Scanner(System.in);
        try {
            File archivo = new File("archivo.txt");
            Scanner scanner2 = new Scanner(archivo);
            // Procesa el archivo
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
        
        try{
            
        
        matriz[9999]=0;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Dato incorrecto mamahuevo");
        }
        try {
            System.out.print("Introduce dato tipo int -> ");
            int b;
            b = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Te equivocaste de tipo mamahuevo");
            System.out.println(e.toString());
        }
        Thread.sleep(1000);
        int a = 9;
        for (int i = 0; i < 20; i++) {
            a = (int) (Math.random() * 2000);
            conversor(a);
            System.out.println("Numero decimal : " + a);
            System.out.println("Numero romano : " + conversor(a));
            System.out.println("");
        }

    }

    public static String conversor(int a) {
        StringBuilder sb = new StringBuilder();
        int roman[] = new int[13];
        int b = a;
        roman[12] = 1000;
        roman[11] = 900;
        roman[10] = 500;
        roman[9] = 400;
        roman[8] = 100;
        roman[7] = 90;
        roman[6] = 50;
        roman[5] = 40;
        roman[4] = 10;
        roman[3] = 9;
        roman[2] = 5;
        roman[1] = 4;
        roman[0] = 1;

        String romanS[] = new String[13];
        romanS[12] = "M";
        romanS[11] = "CM";
        romanS[10] = "D";
        romanS[9] = "CD";
        romanS[8] = "C";
        romanS[7] = "XC";
        romanS[6] = "L";
        romanS[5] = "XL";
        romanS[4] = "X";
        romanS[3] = "IX";
        romanS[2] = "V";
        romanS[1] = "IV";
        romanS[0] = "I";
        do {
            for (int i = roman.length - 1; i > -1; i--) {
                do {
                    if (b >= roman[i]) {
                        b = b - roman[i];
                        sb.append(romanS[i]);
                    }
                } while (b >= roman[i]);
            }

        } while (b > 0);
        return sb.toString();
    }

    public class ClaseAlex implements java.io.Serializable {
        // código
    }
}
