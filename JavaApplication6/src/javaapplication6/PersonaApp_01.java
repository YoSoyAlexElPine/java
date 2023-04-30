package javaapplication6;

import java.util.Scanner;


public class PersonaApp_01 {
 
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
            Scanner scanner = new Scanner(System.in);
            int opc=0;
            System.out.print("opc: ");
            opc=scanner.nextInt();
            switch(opc){
                case 1:
            
       // Creamos dos personas con todos los datos
    Persona persona1 = new Persona("Juan", "Pérez García", 12345678, "C/ Mayor 10", "666111222", 35, 1.75);
    Persona persona2 = new Persona("María", "González Martínez", 87654321, "C/ Menor 5", "666222333", 28, 1.68);

    // Creamos dos personas con solo los datos obligatorios
    Persona persona3 = new Persona("Pedro", "López Hernández", 98765432, "C/ Parque 3");
    Persona persona4 = new Persona("Laura", "Martínez García", 23456789, "C/ Jardín 7");

    // Pedimos los datos del numero de personas al usuario por teclado
        System.out.println("Numero de usuarios a introducir");


    System.out.print("Introduce el nombre de la persona 5: ");
    String nombre5 = scanner.nextLine();
     nombre5 = scanner.nextLine();
    System.out.print("Introduce los apellidos de la persona 5: ");
    String apellidos5 = scanner.nextLine();
    System.out.print("Introduce el DNI de la persona 5: ");
    int dni5 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Introduce la dirección de la persona 5: ");
    String direccion5 = scanner.nextLine();
    System.out.print("Introduce el teléfono de la persona 5 (opcional): ");
    String telefono5 = scanner.nextLine();
    System.out.print("Introduce la edad de la persona 5 (opcional): ");
    int edad5 = scanner.nextInt();
    System.out.print("Introduce la estatura de la persona 5 en metros (opcional): ");
    double estatura5 = scanner.nextDouble();
    Persona persona5 = new Persona(nombre5, apellidos5, dni5, direccion5, telefono5, edad5, estatura5);


    /*System.out.print("Introduce el nombre de la persona 6: ");
    String nombre6 = scanner.nextLine();
    System.out.print("Introduce los apellidos de la persona 6: ");
    String apellidos6 = scanner.nextLine();
    System.out.print("Introduce el DNI de la persona 6: ");
    int dni6 = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Introduce la dirección de la persona 6: ");
    String direccion6 = scanner.nextLine();
    System.out.print("Introduce el teléfono de la persona 6 (opcional): ");
    String telefono6 = scanner.nextLine();
    System.out.print("Introduce la edad de la persona 6 (opcional): ");
    int edad6 = scanner.nextInt();
    System.out.print("Introduce la estatura de la persona 6 en metros (opcional): ");
    double estatura6 = scanner.nextDouble();
    Persona persona6 = new Persona(nombre6, apellidos6, dni6, direccion6, telefono6, edad6, estatura6);
*/
    // Mostramos los datos de las personas por consola
    System.out.println("Listado de personas:");
    persona1.datos();
    persona2.datos();
    persona3.datos();
    persona4.datos();
    persona5.datos();
    //System.out.println(persona5.toString().toUpperCase());
    /*System.out.println(persona6.toString().toUpperCase());*/
                case 2:
                    int numPersonas;
                    System.out.print("Mete las personas que quieras: ");
                    numPersonas=scanner.nextInt();
                    int array[]=new int [numPersonas];
                
    }
    }
}
