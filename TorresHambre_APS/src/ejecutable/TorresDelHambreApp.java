package ejecutable;

import java.io.IOException;

import funciones.*;
import objetos.Usuario;

public class TorresDelHambreApp {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // Variables
        int opc;

        // Titulo de cabecera
        Graficos.titulo();

        do {
            Usuario.menu();// menu
            opc = FuncionesGenerales.brInt("Elige: ");
            System.out.println();
            switch (opc) {
                case 1 -> {
                    // Logeo de usuario
                    if (Usuario.login() == true) {
                        FuncionesGenerales.jugar();
                    }
                }
                case 2 ->
                    new Usuario();// Registro de usuario
                case 0 -> {
                }
                default -> {
                    System.out.println("Opcion no valida");
                    Thread.sleep(1000);
                }
            }
        } while (opc != 0);
        Graficos.despedida();//despedida
    }
}
