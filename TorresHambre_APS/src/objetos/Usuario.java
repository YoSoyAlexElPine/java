package objetos;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import funciones.EscritorAPS;
import funciones.FuncionesGenerales;
import static funciones.FuncionesGenerales.user;
import funciones.LectorAPS;
import java.util.LinkedList;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String nombre, contrasena, colorFav = "no tiene", comidaFav = "no tiene", email = "no tiene";
    protected int numero = 0;
    protected double saldo = 0;
    protected File usuarios = new File("usuarios");
    protected boolean admin = false;

    static boolean login = false;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return Objects.equals(nombre, other.nombre);
    }

    /**
     * Constructor para Usuario basico
     *
     * @param nombre
     * @param contrasena
     */
    public Usuario(String nombre, String contrasena, boolean admin) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.admin = admin;

    }

    /**
     * Constructor para usuario completo
     *
     * @param nombre
     * @param contrasena
     * @param colorFav
     * @param comidaFav
     * @param email
     * @param numero
     * @param saldo
     */
    public Usuario(String nombre, String contrasena, String colorFav, String comidaFav, String email, int numero,
            double saldo) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.colorFav = colorFav;
        this.comidaFav = comidaFav;
        this.email = email;
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * Contructor de usuario hecho por consola
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public Usuario() throws IOException, InterruptedException {
        File file = new File("usuarios");
        LectorAPS lec = new LectorAPS(file);
        EscritorAPS es = new EscritorAPS(new File("usuarios"));
        String contrasenaAux;

        if (!file.exists()) {
            es.escribirAPS(new Usuario("admin", "admin123+", true), true);
        }

        System.out.println("--------------------------");
        System.out.println("-  Registro De Usuario   - ");
        System.out.println("--------------------------");
        System.out.println();
        do {

            nombre = FuncionesGenerales.brString("Nombre: ");
            if (lec.buscar2APS(nombre) != null) {
                System.out.println("Este nombre ya esta cogido.");
                System.out.println("Intenta otro Nombre.");
            }
        } while (lec.buscar2APS(nombre) != null);
        do {
            contrasenaAux = FuncionesGenerales.brString("Contrasena: ");
            if (!contrasenaAux.matches(FuncionesGenerales.FUERTE)) {
                System.out.println("");
                System.out.println("La contrasena introducida no es fuerte");
                System.out.println("Asegurate de que tenga minimo 5 letras, 1 numero y 1 caracter especial");
                System.out.println("Ejemplo: MeGustaJava123+");
                System.out.println("");
            }
        } while (!contrasenaAux.matches(FuncionesGenerales.FUERTE));
        this.contrasena = contrasenaAux;

        do {
            this.email = FuncionesGenerales.brString("Email: ");
            if (FuncionesGenerales.validarEmail(this.email) == false) {
                System.out.println();
                System.out.println("Porfavor, introduce un email valido");
                Thread.sleep(1000);

            }
        } while (FuncionesGenerales.validarEmail(this.email) == false);

        this.numero = FuncionesGenerales.brInt("Numero de telefono (opcional) : ");

        Thread.sleep(1000);

        es.escribirAPS(this, false);

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("-  Usuario registrado :) -");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("- Ya puedes logearte con tu usuario -");
        System.out.println();
        Thread.sleep(2000);
    }

    /**
     * Funcion que registra nuestro usuario en nuestro archivo de texto usuarios
     *
     * @param nombre
     * @param contrasena
     * @return
     * @throws IOException
     */
    public int registrar(String nombre, String contrasena) throws IOException {

        int retorno;
        LectorAPS lec = new LectorAPS();

        if (lec.buscarAPS(nombre).nombre.equals(nombre)) {

            retorno = -1;

        } else {

            Usuario usr = new Usuario(nombre, contrasena, false);
            EscritorAPS es = new EscritorAPS(usuarios);
            es.escribirAPS(usr, false);

            retorno = 1;
        }
        return retorno;
    }

    /**
     * Verifica la contrasena y hace un login clasico
     *
     * @return true = contrasena correcta; false = contrasena incorrecta
     * @throws IOException
     * @throws InterruptedException
     * @throws ClassNotFoundException
     */
    public static boolean login() throws IOException, InterruptedException, ClassNotFoundException {

        boolean retorno = false;
        String contrasena, nombre;
        int intentos = 3;
        File file = new File("usuarios");
        LectorAPS lec = new LectorAPS(file);
        EscritorAPS es = new EscritorAPS(new File("usuarios"));
        if (!file.exists()) {
            es.escribirAPS(new Usuario("admin", "admin123+", true), true);
        }

        nombre = FuncionesGenerales.brString("Nombre: ");

        Usuario user = lec.buscarAPS(nombre);

        if (user == null) {
            System.out.println("Usuario no encontrado");
            System.out.println("Asegurate de escribir bien el nombre o haberse resgistrado previamente");
            System.out.println();
            Thread.sleep(2000);
        } else {
            do {
                contrasena = FuncionesGenerales.brString("Contrasena: ");
                if (user.getContrasena().equals(contrasena)) {
                    System.out.println();
                    System.out.println("Contrasena correcta :)");
                    FuncionesGenerales.user = user;
                    retorno = true;
                } else {
                    intentos--;
                    System.out.println("Contrasena incorrecta.");
                    retorno = false;
                }
                Thread.sleep(1000);
            } while (retorno == false && intentos > 0);
            if (retorno == false) {

                // Declara las variables necesarias
                LinkedList<Usuario> usuarios = new LinkedList<>();
                LinkedList<Torre> torres = new LinkedList<>();
                File usuarioFichero = new File("usuarios");
                File torreFichero = new File("torres");

                // Crea los objetos para acceder a los métodos de guardado
                LectorAPS leerUsuario = new LectorAPS(usuarioFichero);
                EscritorAPS escribirUsuario = new EscritorAPS(usuarioFichero);
                LectorAPS leerTorre = new LectorAPS(torreFichero);
                EscritorAPS escribirTorre = new EscritorAPS(torreFichero);

                //Creamos una torre por defecto si ek archivo esta vacio
                if (!torreFichero.exists()) {
                    escribirTorre.escribirAPS(new Torre(user), true);
                }

                // Lee la lista de usuarios del archivo
                usuarios = leerUsuario.leerListaAPS();
                torres = leerTorre.leerLista();

                for (int i = 0; i < usuarios.size(); i++) {
                    // Comprueba si el nombre del usuario en la posición actual es igual al nombre del usuario actualmente logueado
                    if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                        // Si hay una coincidencia, elimina el usuario de la lista
                        usuarios.remove(i);
                    }
                }

                // Elimina el usuario actualmente logueado utilizando el método buscarLista()
                usuarios.remove(FuncionesGenerales.buscarLista(usuarios, user.getNombre()));

                // Escribe la lista de usuarios actualizada en el archivo
                escribirUsuario.escribirAPS(usuarios);

                // Recorre la lista de torres
                for (Torre t : torres) {
                    // Comprueba si el nombre de usuario asociado a la torre es igual al nombre del usuario actualmente logueado (ignorando mayúsculas y minúsculas)
                    if (t.getUsuario().equalsIgnoreCase(user.getNombre())) {
                        // Si hay una coincidencia, elimina la torre de la lista
                        torres.remove(t);
                    }
                }

                // Escribe la lista de torres actualizada en el archivo
                escribirTorre.escribir(torres);

                // Imprime un mensaje indicando que el usuario ha sido eliminado
                System.out.println("Usuario eliminado :(");
            }

        }

        return retorno;
    }

    /**
     * Verifica la contrasena y hace un login clasico
     *
     * @param nombre
     * @param contrasena
     * @return true = contrasena correcta; false = contrasena incorrecta
     * @throws IOException
     * @throws InterruptedException
     */
    public static boolean login(String nombre, String contrasena) throws IOException, InterruptedException {

        LectorAPS lec = new LectorAPS(new File("usuarios"));
        Usuario user = lec.buscarAPS(nombre);

        if (user == null) {

        } else {
            do {
                if (user.getContrasena().equals(contrasena)) {
                    login = true;
                } else {
                    login = false;
                }
            } while (login == false);
            if (login == false) {
            }

        }

        return login;
    }

    @Override
    public String toString() {
        System.out.println("");
        System.out.println("\t === Usuario ===");
        System.out.println("Nombre = " + nombre);
        System.out.println("Contrasena = " + contrasena);
        System.out.println("email = " + email);
        System.out.println("Numero = " + numero);
        System.out.println();
        return " ";
    }

    /**
     * Funcion que imprime los datos del usuario mas amigablemente y de tipo
     * void
     *
     */
    public void toStringVoid() {

        System.out.println("");
        System.out.println("\t === Usuario ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Contrasena: " + contrasena);
        System.out.println("email: " + email);
        System.out.println("Numero: " + numero);
        System.out.println();
    }

    /**
     * menu de inicio
     */
    public static void menu() {
        System.out.println("""
				-------------------
				- Incio de sesion -
				-------------------
				- 1. Logearse     -
				- 2. Registraese  -
				- -----------------
				- 0. Salir        -
				-------------------
				""");
    }

    /**
     * Getters y Setters:
     *
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getColorFav() {
        return colorFav;
    }

    public void setColorFav(String colorFav) {
        this.colorFav = colorFav;
    }

    public String getComidaFav() {
        return comidaFav;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isLogin() {
        return login;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {

        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
