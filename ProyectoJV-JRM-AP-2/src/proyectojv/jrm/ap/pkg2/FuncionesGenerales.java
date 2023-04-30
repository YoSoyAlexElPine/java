/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectojv.jrm.ap.pkg2;
//import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JoseVi
 */
public class FuncionesGenerales {

    // Funciones para la mazmorra        
    public static void menuMazmorra() {
        int opc, tamanioMazmorra = 5;
        Mazmorra[][] mazmorra;
        boolean salir = false;
        Scanner teclado = new Scanner(System.in);

        mazmorra = new Mazmorra[tamanioMazmorra][tamanioMazmorra];
        mazmorra = generarMazmorra(mazmorra);

        do {
            System.out.println("Introduce una opcion");
            System.out.println("1. Generar nueva aventura");
            System.out.println("2. Ver generacion actual");
            System.out.println("3. Dibujar mazmorra");
            System.out.println("0. Salir ");
            opc = teclado.nextInt();
            switch (opc) {
                case 1 -> {
                    mazmorra = new Mazmorra[tamanioMazmorra][tamanioMazmorra];
                    mazmorra = generarMazmorra(mazmorra);
                }
                case 2 -> {
                    System.out.println("=============================");
                    for (int i = 0; i < mazmorra.length; i++) {
                        for (int j = 0; j < mazmorra.length; j++) {
                            System.out.println(mazmorra[i][j].toString());
                            System.out.println("=============================");
                        }

                    }
                }
                case 3 -> {
                    for (int i = 0; i < mazmorra.length; i++) {
                        for (int j = 0; j < mazmorra.length; j++) {
                            mazmorra[i][j].dibujar();
                        }
                        System.out.println("");
                    }
                }
                case 0 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("Opcion no disponible");
                }
            }
        } while (!salir);
    }

    public static Mazmorra[][] generarMazmorra(Mazmorra[][] mazmorra) {
        int piso = -1, aux;
        int MIN = 1, MAX = 3;
        for (int i = 0; i < mazmorra.length; i++) {
            for (int j = 0; j < mazmorra.length; j++) {
                if (i == 0 && j == 0) {
                    mazmorra[0][0] = new Mazmorra("Zona Inicial", Hostilidad.AMISTOSA);
                } else {
                    aux = (int) (Math.random() * (MAX - MIN + 1) + MIN);
                    switch (aux) {
                        case 1 -> {
                            mazmorra[i][j] = new Mazmorra(piso, "ZonaInicial", Hostilidad.AMISTOSA);
                        }
                        case 2 -> {
                            mazmorra[i][j] = new Mazmorra(piso, "ZonaInicial", Hostilidad.HOSTIL);
                        }
                        case 3 -> {
                            mazmorra[i][j] = new Mazmorra(piso, "ZonaInicial", Hostilidad.PASIVA);
                        }
                        default -> {
                            System.out.println("Error en el codigo");
                        }
                    }
                }

            }
            piso--;
        }
        return mazmorra;
    }

    public static void menuTorre() {
        Scanner teclado = new Scanner(System.in);
        int opc = 0, opc2 = 0, opc3, numPlantas, botin, aux, dinero = 1000, cerdos = 3;
        boolean fort;
        Torre torre1 = null;
        System.out.println("""
                           1. Generar torre aleatoria
                           2. Crear torre personalizada
                           """);
        try {
            System.out.print("Introduzca una opción: ");
            opc2 = teclado.nextInt();
            System.out.println("Opción introducida: " + opc2);
        } catch (Exception e) {
            System.out.println("Error: debe introducir un valor numérico.");
        }
        if (opc2 == 1) {
            torre1 = generarTorre();
        } else {
            System.out.println("Introducce numero de plantas");
            numPlantas = teclado.nextInt();
            System.out.println("Introdicce el botin que tendra tu torre");
            botin = teclado.nextInt();
            System.out.println("Esta fortificada? 0 = no, 1 = si");
            aux = teclado.nextInt();
            if (aux == 0) {
                fort = false;
            } else {
                fort = true;
            }
            torre1 = new Torre(numPlantas, fort, botin);
        }

        do {
            System.out.println("""
                               
                           === Elige Opcion ===
                               
                           1. Inspeccionar
                           2. Saquear
                           3. Conquistar
                           4. Comerciar
                           5. Dibujar
                          
                           0. Salir
                               
                           """);
            try {
                System.out.print("Introduzca una opción: ");
                opc = teclado.nextInt();
                System.out.println("Opción introducida: " + opc);
            } catch (Exception e) {
                System.out.println("Error: debe introducir un valor numérico.");
            }

            switch (opc) {
                case 1 ->
                    System.out.println(torre1.toString());
                case 2 -> {
                    System.out.println("Has saqueado la torre, ahora el botin " + torre1.saquear() + " te pertenece");
                    dinero = dinero + torre1.saquear();
                    System.out.println("Ahora tienes " + dinero + " de dinero");
                }
                case 3 -> {
                    torre1.setPertenece(torre1.conquistar());
                    if (torre1.getPertenece() == true) {
                        System.out.println("Ahora la torre te pertenece");
                    } else {
                        System.out.println("No has logrado conquistar la torre");
                    }
                }
                case 4 -> {
                    if (torre1.hostilidad != Hostilidad.HOSTIL) {
                        System.out.println("tienes " + cerdos + " cerdos");
                        System.out.println("Ofrecen " + torre1 + " por cada cerdo");
                        System.out.println("Cuantos quieres comerciar?");
                        do {
                            opc3 = teclado.nextInt();
                            if (opc3 > cerdos) {
                                System.out.println("No tienes tantos gorrinos");
                            }
                        } while (opc3 > cerdos);

                    } else {
                        System.out.println("No puedes comerciar con torres hostiles");
                    }

                }
                case 5 ->
                    torre1.dibujar();
            }
        } while (opc != 0);
    }

    private static Torre generarTorre() {
        int numPlanta, botin, poder,oferta;
        boolean fortificado;
        Hostilidad hostilidad = null;
        numPlanta = (int) (Math.random() * 10);
        botin = (int) (Math.random() * 10000);
        oferta=(int) (Math.random()*500);
        poder = (int) (Math.random() * 1000);
        int aux = (int) (Math.random()); if (aux == 1) { fortificado = false;} else {fortificado = true;}
        
    }
        int aux2 = (int) (Math.random() * 2);
        switch (aux2) {
            case 0 ->
                hostilidad = Hostilidad.AMISTOSA;
            case 1 ->
                hostilidad = Hostilidad.PASIVA;
            case 2 ->
                hostilidad = Hostilidad.HOSTIL;
        }
        Torre torre = new Torre(numPlanta,poder,botin,oferta,"Elfica",  fortificado, pertenece, false, Hostilidad);
        return torre;
    }
 