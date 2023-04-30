/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication6;

/**
 * Clase que representa a una persona.
 */
public class Persona {

    // Atributos de la clase
    private String nombre;
    private String apellidos;
    private int dni;
    private String direccion;
    private String telefono;
    private int edad;
    private double estatura;
    private int peso;
    private String mail;
    CLM provincia=CLM.CIUDAD_REAL;

    // Variable de clase para llevar la cuenta de los objetos Persona creados
    private static int contadorPersonas = 0;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre Nombre de la persona (obligatorio).
     * @param apellidos Apellidos de la persona (obligatorio).
     * @param dni DNI de la persona (obligatorio).
     * @param direccion Dirección de la persona (obligatorio).
     */
    public Persona(String nombre, String apellidos, int dni, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        contadorPersonas++;
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre Nombre de la persona (obligatorio).
     * @param apellidos Apellidos de la persona (obligatorio).
     * @param dni DNI de la persona (obligatorio).
     * @param direccion Dirección de la persona (obligatorio).
     * @param telefono Teléfono de la persona (opcional).
     * @param edad Edad de la persona (opcional).
     * @param estatura Estatura de la persona en metros (opcional).
     */
    public Persona(String nombre, String apellidos, int dni, String direccion, String telefono, int edad, double estatura) {
        this(nombre, apellidos, dni, direccion);
        this.telefono = telefono;
        this.edad = edad;
        this.estatura = estatura;
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre Nombre de la persona (obligatorio).
     * @param apellidos Apellidos de la persona (obligatorio).
     * @param dni DNI de la persona (obligatorio).
     * @param direccion Dirección de la persona (obligatorio).
     * @param telefono Teléfono de la persona (opcional).
     * @param edad Edad de la persona (opcional).
     */
    public Persona(String nombre, String apellidos, int dni, String direccion, String telefono, int edad) {
        this(nombre, apellidos, dni, direccion);
        this.telefono = telefono;
        this.edad = edad;
    }

    public Persona(String nombre, String apellidos, int dni, String direccion, String telefono, int edad, double estatura, int peso, String mail) {
        this(nombre, apellidos, dni, direccion);
        this.telefono = telefono;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
        this.mail = mail;
    }

    /**
     * Método que devuelve el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método que devuelve el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public int getDni() {
        return dni;
    }

    /**
     * Método que establece el DNI de la persona.
     *
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Método que devuelve la dirección de la persona.
     *
     * @return La dirección de la persona.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método que establece la dirección de la persona.
     *
     * @param direccion La nueva dirección de la persona.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que devuelve el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que establece el teléfono de la persona.
     *
     * @param telefono El nuevo teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que devuelve la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método que establece la edad de la persona.
     *
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    /**
     * Método que devuelve la estatura de la persona en metros.
     *
     * @return La estatura de la persona en metros.
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * Método que establece la estatura de la persona en metros.
     *
     * @param estatura La nueva estatura de la persona en metros.
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /**
     * Método que calcula la letra correspondiente a un DNI.
     *
     * @param dni El número de DNI para el que se quiere calcular la letra.
     * @return La letra correspondiente al DNI.
     */
    private char calcularLetraDNI(int dni) {
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        char letra = juegoCaracteres.charAt(modulo);
        return letra;
    }

    /**
     * Método que devuelve el NIF a partir del DNI.
     *
     * @return El NIF correspondiente al DNI.
     */
    public String getNIF() {
        char letra = calcularLetraDNI(dni);
        return String.valueOf(dni) + letra;
    }

    /**
     * Método que convierte la estatura de metros a centímetros.
     *
     * @return La estatura de la persona en centímetros.
     */
    public double convertirEstaturaACentimetros() {
        return estatura * 100;
    }

    /**
     * Método que devuelve el número de personas creadas.
     *
     * @return El número de personas creadas.
     */
    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public void datos() {
        if (estatura != 0.0 && edad != 0 && telefono != null) {
            System.out.println(
                    "Nombre: " + nombre
                    + "  Apellidos: " + apellidos
                    + "  Direccion: " + direccion
                    + "  DNI: " + dni
                    + "  Estatura: " + estatura
                    + "  Edad: " + edad
                    + "  Telefono: " + telefono
                    + " "
            );
        } else {
            System.out.println(
                    "Nombre: " + nombre
                    + "  Apellidos: " + apellidos
                    + "  Direccion: " + direccion
                    + "  DNI: " + dni
            );
        }

    }
}
