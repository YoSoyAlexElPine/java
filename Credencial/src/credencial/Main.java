package credencial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opc, contador = 0;
        Credencial[] array = new Credencial[999];
        Scanner scanner = new Scanner(System.in);

        do {
            Graficos.menu();
            System.out.print("opc -> ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    nombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseña = scanner.nextLine();
                    Credencial pers = new Credencial(nombre, contraseña);

                    array[contador] = pers;
                    contador++;
                    break;
                case 2:
                    for (int i = 0; i < contador; i++) {
                        System.out.println("");
                        System.out.println("****************************");
                        array[i].datos();
                        System.out.println("****************************");
                        System.out.println("Usuario numero: " + (i + 1));
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (int i = 1; i < 21; i++) {
                        String nombre2 = "alumno";
                        StringBuilder sb = new StringBuilder(7);
                        sb.append(nombre2);
                        sb.append(i);
                        nombre = sb.toString();
                        Credencial pers0 = new Credencial(nombre);

                        array[contador] = pers0;
                        contador++;
                    }
            }
        } while (opc != 4);
    }
}
