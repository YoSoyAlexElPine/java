package volumenaps;

import java.util.Scanner;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class VolumenAPS {

    /**
     * Clase main
     *
     * @param args
     */
    public static void main(String[] args) {

        //Objetos a declarar
        Scanner scanner = new Scanner(System.in);

        //Variables a declarar
        int opcMenu;
        double lado, radio, altura;

        //Seleccion de opcion de menu
        do {

            //Mostramos el menu y leermos su eleccion
            menu();
            opcMenu = scanner.nextInt();

            //Funcion a realizar segun haya elegido el usuario
            switch (opcMenu) {
                /*
                    Estructura del Switch
                        1. Leemos datos necesarios mediante la funcion leerDato("nombre del dato")
                        2. Introducimos esapacio
                        3. Mostramos por pantalla cada dato y su resultado
                 */

                case 1 -> {
                    //1. Lectura de dato
                    lado = leerDato("lado");
                    //2. espacio
                    System.out.println("");
                    //3. Muesta por pantalla
                    System.out.println("Volumen del cubo de lado " + lado + " = " + volumenCubo(lado));
                    System.out.println("");
                }
                case 2 -> {
                    lado = leerDato("lado");
                    altura = leerDato("altura");
                    System.out.println("");
                    System.out.println("Volumen de la piramide de lado " + lado + " y altura " + altura + " = " + volumenPiramideCuadrangular(lado, altura));
                    System.out.println("");
                }
                case 3 -> {
                    radio = leerDato("lado");
                    altura = leerDato("altura");
                    System.out.println("");
                    System.out.println("Volumen del cilindro de radio " + radio + " y altura " + altura + " = " + volumenCilindro(radio, altura));
                    System.out.println("");
                }
                case 4 -> {
                    radio = leerDato("radio");
                    System.out.println("");
                    System.out.println("Volumen de la esfera de radio " + radio + " = " + volumenEsfera(radio));
                    System.out.println("");
                }
                case 5 ->
                    //Funcion dibujar figuras
                    dibujarFigura();
                case 6 -> {
                }

                default -> {
                    //En cualquie otro caso mostramos "opcion no valida"
                    System.out.println("Opcion no valida");
                    System.out.println("");
                }
            }

            //Condicion para que se repita hasta que el usuario eliga salir
        } while (opcMenu != 6);
    }

    /**
     * Funcion que permitira dibujar por pantalla una figura selecionada
     *
     * @param lado
     * @param radio
     * @param altura
     */
    private static void dibujarFigura() {

        //Objetos a declarar
        Scanner scanner = new Scanner(System.in);

        //Variables a declarar        
        double lado, radio, altura;
        int aleatorio = 0, opcFigura;
        char caracter;

        //Calculamos el caracter aleatorio mediante el math.random
        
        do {
            aleatorio = (int) (Math.random() * 47);
        } while (aleatorio < 33);

        //Guardamos el caracter aleatorio en la variable caracter
        caracter = (char) aleatorio;

        //Mostramos el menu para que el usuario eliga que figura quire leer y leemos su eleccion
        menuFiguras();
        opcFigura = scanner.nextInt();
        
        //Switch que alterna que figura dibujar
        switch (opcFigura) {
            
            //Cubo
            
            case 1 -> {
                
                lado = leerDato("lado");
                
                System.out.println("Caracter a dibujar = " + caracter);
                System.out.println("");
                
                for (int i = 0; i < lado; i++) {
                    for (int j = 0; j < lado; j++) {
                        if (i == 0 || i == lado - 1) {
                            System.out.print(caracter + " ");
                        } else {
                            if (j == 0 || j == lado - 1) {
                                System.out.print(caracter + " ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
            }
            
            //Piramide
            
            case 2 -> {
                
                lado = leerDato("lado");
                altura = leerDato("altura");

                System.out.println("Caracter a dibujar: " + caracter);
                System.out.println("");

                for (double i = altura; i >0; i--) {
                    for (int j = 0; j < lado-i; j++) {
                        if (j==0 || j==lado-i-1) {
                            System.out.print(caracter+" ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("");
                    
                }
                for (int j = 0; j < lado; j++) {
                        System.out.print(caracter+" ");
                    }
            }
            
            //Cilindro
            
            case 3 -> {
                radio = leerDato("radio");
                altura = leerDato("altura");

                lado = radio * 2;

                System.out.println("Caracter a dibujar: " + caracter);
                System.out.println("");

                for (int i = 0; i < altura; i++) {
                    for (int j = 0; j < lado; j++) {
                        if (i == 0 || i == altura - 1) {
                            System.out.print(caracter + " ");
                        } else {
                            if (j == 0 || j == lado - 1) {
                                System.out.print(caracter + " ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                    }
                    System.out.println();
                }
            }
            
            //Esfera
            
            case 4 -> {
                
                System.out.println("En construccion");
                
            }
            default ->
                System.out.println("Opcion no valida");
        }
        
        //Espacios para separar el siguiente mensaje y verse limpio
        System.out.println("");
        System.out.println("");

    }

    /**
     * Funcion que calculara el volumen de una esfera
     *
     * @param r
     * @return formula
     */
    
    private static double volumenEsfera(double r) {
        final double formula=((4 / 3) * Math.PI * r * r * r);
        return formula;
    }

    /**
     * Funcion que calculara el volumen de un cilindro
     *
     * @param r
     * @param h
     * @return formula
     */
    private static double volumenCilindro(double r, double h) {
        final double formula=Math.PI * r * r * h;
        return formula;
    }

    /**
     * Funcion que calculara el volumen de una piramide cuadrangular
     *
     * @param l
     * @param h
     * @return formula
     */
    private static double volumenPiramideCuadrangular(double l, double h) {
        final double unTercio = 0.33333333333333333333333333;
        final double formula=(unTercio * l * l * h);
        return formula;
    }

    /**
     * Funcion que calculara el volumen de un cubo
     *
     * @param l
     * @return formula
     */
    private static double volumenCubo(double l) {
        final double formula=(l * l * l);
        return formula;
    }

    /**
     * Funcion que mostrara por pantalla el menu de dibujar figuras
     */
    private static void menuFiguras() {
        System.out.println("""
                           Selecciona figura a dibujar
                           
                           1. Cubo
                           2. Piramide
                           3. Cilindro
                           4. Esfera
                           """);
    }

    /**
     * Funcion que leera el dato que introduzcamos
     *
     * @param nombre
     * @return dato leido
     */
    private static double leerDato(String nombre) {
        double d1;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce valor para " + nombre + ": ");
        d1 = scanner.nextDouble();
        return d1;
    }

    /**
     * Funcion que mostrara por pantalla el menu de principal
     */
    private static void menu() {
        System.out.println("""
                           1. Calcular volumen de cubo
                           2. calcular volumen de pirámide cuadrangular
                           3. Calcular volumen del cilindro
                           4. Calcular volumen de la esfera
                           5. Dibujar figura
                           6. Salir
                           
                           Elige una opcion porfavor
                           """);
    }
    
}
