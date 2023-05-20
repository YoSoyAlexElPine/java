import java.util.Scanner;
import java.io.*;


public class Tutorial {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea="";
        
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
        	do {
            System.out.println("Introduce el número " + (i+1) + ":");
            try {
                linea = br.readLine();
                numeros[i] = Integer.parseInt(linea);
                
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ocurrio un error");
                
            }
			} while (linea=="");
        }

        System.out.print("Los números introducidos son: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }

    public static int suma(int a, int b) {
        return a + b;
    }
}
