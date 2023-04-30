package credencial;

import java.util.Random;

public class Credencial {

    private final int longitud = 10;
    private final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private String contraseña;
    private String usuario;
    public int contador = 0;

    public Credencial(String usuario) {
        this.usuario = usuario.trim();
        contador++;
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }

        String stringAleatorio = sb.toString();
        this.contraseña = stringAleatorio;
    }

    public Credencial(String usuario, String contraseña) {
        contraseña=contraseña.trim();
        if (contraseña == "") {
            StringBuilder sb = new StringBuilder(longitud);
            Random random = new Random();

            for (int i = 0; i < longitud; i++) {
                int indice = random.nextInt(caracteres.length());
                sb.append(caracteres.charAt(indice));
            }

            String stringAleatorio = sb.toString();
            contraseña = stringAleatorio;
        }
        contador++;
        this.usuario = usuario.trim();
        this.contraseña = contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getContador() {
        return contador;
    }

    public void cambiarNombre(String nuevoNom) {
        usuario = nuevoNom;
    }

    public void esContraseñaFuerte() {
        int contador1 = 0, requisitos = 0;
        if (contraseña.length() > 8) {
            requisitos++;
        }
        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.charAt(i) == '0' || contraseña.charAt(i) == '1' || contraseña.charAt(i) == '2' || contraseña.charAt(i) == '3' || contraseña.charAt(i) == '4' || contraseña.charAt(i) == '5' || contraseña.charAt(i) == '6' || contraseña.charAt(i) == '7' || contraseña.charAt(i) == '8' || contraseña.charAt(i) == '9') {
                contador1++;
            }
        }
        if (contador1 > 2) {
            requisitos++;
        }
        if (contraseña.equalsIgnoreCase(contraseña.toUpperCase())) {
            requisitos++;
        }
        if (requisitos == 3) {
            System.out.println("La contraseña es fuerte");
        } else {
            System.out.println("La contraseña es debil");
        }
    }

    public void reset() {
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }

        String stringAleatorio = sb.toString();
        contraseña = stringAleatorio;
    }

    public String cifrar() {
        String resultado = "";
        for (int i = 0; i < contraseña.length(); i++) {
            char caracter = contraseña.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isUpperCase(caracter)) {
                    caracter = (char) ((caracter + 2 - 'A') % 26 + 'A');
                } else {
                    caracter = (char) ((caracter + 2 - 'a') % 26 + 'a');
                }
            }
            resultado += caracter;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Credencial{" + "longitud=" + longitud + ", caracteres=" + caracteres + ", contrase\u00f1a=" + contraseña + ", usuario=" + usuario + ", contador=" + contador + '}';
    }

    public void datos() {
        System.out.println("----------------------");
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + contraseña);
        System.out.println("Contraseña cifrada: " + cifrar());
        esContraseñaFuerte();
        System.out.println("Total usuarios: " + this.contador);
    }

}
