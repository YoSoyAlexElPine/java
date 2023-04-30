package javaapplication3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication3 {

    public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("Introduce tu nombre: ");
            String nombre = br.readLine();
            System.out.println("Hola, " + nombre + "!");
            br.close();
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

}
