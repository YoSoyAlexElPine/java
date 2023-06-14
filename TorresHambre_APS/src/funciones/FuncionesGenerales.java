package funciones;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import objetos.*;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class FuncionesGenerales {

    // Objeto perosnaje que utilizalemos durante los escenarios
    public static Usuario user = null;
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public static final String FUERTE = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z0-9!@#$%^&*()_+]{5,55}$";

    /**
     * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo
     * en trycath y de mas codigo; en valores int.
     *
     * @param texto -> Sera las indicaciones que mostrara al usuario
     * @return
     * @throws java.io.IOException
     *
     */
    public static int brInt(String texto) throws NumberFormatException, IOException {
        int retorno = -1;
        BufferedReader reader;
        try {
            System.out.print(texto);
            reader = new BufferedReader(new InputStreamReader(System.in));
            retorno = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
        } catch (NumberFormatException e) {
            System.out.println("Introduce datos numericos por favor");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block

            }
        }
        return retorno;
    }

    /**
     * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo
     * en trycath y de mas codigo; en valores int.
     *
     *
     * @return
     */
    public static int brInt() {
        int retorno = -1;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            retorno = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
        } catch (NumberFormatException e) {
            System.out.println("Introduce datos numericos por favor");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block

            }
        }
        return retorno;
    }

    /**
     * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo
     * en trycath y de mas codigo; en valores String.
     *
     * @param texto -> Sera las indicaciones que mostrara al usuario
     * @return
     *
     */
    public static String brString(String texto) {
        String retorno = " ";
        BufferedReader reader;
        try {
            System.out.print(texto);
            reader = new BufferedReader(new InputStreamReader(System.in));
            retorno = reader.readLine();
        } catch (IOException e) {
        } catch (NumberFormatException e) {
            System.out.println("Introduce datos numericos por favor");
        }
        return retorno;
    }

    /**
     * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo
     * en trycath y de mas codigo; en valores String.
     *
     *
     * @return
     */
    public static String brString() {
        String retorno = " ";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            retorno = reader.readLine();
            System.out.println();
        } catch (IOException e) {
        } catch (NumberFormatException e) {
            System.out.println("Introduce datos numericos por favor");
        }
        return retorno;
    }

    // fin funciones BufferedReader
    // Inicio funciones Torre
    public static void menuTorre() throws NumberFormatException, IOException, InterruptedException {

        // Variables
        int opc, opc2, fuerza = 999999999;
        Torre torre1 = null;
        if (user.isAdmin() == true) {
            System.out.println("""
					------------------------------
					-           Torre            -
					------------------------------
					- 1. Generar torre aleatoria -
					- 2. Crear torre             -
					------------------------------
					- 0. Salir                   -
					------------------------------
					""");

            opc2 = brInt("Introduzca una opcion valida: ");

            switch (opc2) {
                case 1 ->
                    Torre.generarTorre(user);
                case 2 ->
                    Torre.crearTorre(user);
                case 0 -> {
                }

                default -> {
                    System.out.println("Opcion no valida.");
                    System.out.println();
                    Thread.sleep(2000);
                }
            }
        } else {
            torre1 = Torre.generarTorre(user);
        }

        do {

            System.out.println("""
					-------------------------
					-      Torre opcion     -
					-------------------------
					- 1. Inspeccionar       -
					- 2. Saquear            -
					- 3. Conquistar         -
					- 4. Dibujar            -
					- 5. Evento aleatorio   -
					-------------------------
					- 0. Salir              -
					-------------------------
					""");

            opc = brInt("Elige opcion: ");
            System.out.println();
            switch (opc) {
                case 1 ->
                    torre1.investigar();
                case 2 ->
                    torre1.saquear();
                case 3 ->
                    torre1.conquistar(fuerza);
                case 4 ->
                    torre1.dibujar();
                case 5 ->
                    torre1.generarEventoAleatorio();
            }// fin del switch
            Thread.sleep(1000);
        } while (opc != 0);
    }// fin menuTorre()

    public static boolean validarEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static void jugar() throws IOException, ClassNotFoundException, NumberFormatException, InterruptedException {
        Usuario userBusqueda;
        LinkedList<Usuario> usuarios = new LinkedList<>();
        LinkedList<Torre> torres = new LinkedList<>();
        File usuarioFichero = new File("usuarios");
        File torreFichero = new File("torres");
        //Creo los objetos para acceder a los metodos de guardado uno para cada tipo de archivo que vaya a escribirAPS
        LectorAPS leerUsuario = new LectorAPS(usuarioFichero);
        EscritorAPS escribirUsuario = new EscritorAPS(usuarioFichero);
        LectorAPS leerTorre = new LectorAPS(torreFichero);
        EscritorAPS escribirTorre = new EscritorAPS(torreFichero);
        usuarios = leerUsuario.leerListaAPS();
        
        System.out.println(usuarios.size());
        //torres = leerTorre.leerListaAPS();

        int opcMenu = 0;

        do {

            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("-     Torres del hambre     -");
            System.out.println("-----------------------------");
            System.out.println("- 1. Jugar                  -");
            System.out.println("- 2. Ver datos usuario      -");
            System.out.println("- 3. Ver listado usuarios   -");
            System.out.println("- 4. Ver listado torres     -");
            System.out.println("- 5. Cambiar contrasena     -");
            System.out.println("- 6. Borrar usuario         -");
            System.out.println("-----------------------------");
            System.out.println("- 0. Salir                  -");
            System.out.println("-----------------------------");
            try {
                opcMenu = FuncionesGenerales.brInt("Elige opcion: ");
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Asegurate de escribir tan solo nuemeros de manera correcta");
            }

            switch (opcMenu) {
                case 1 ->
                    FuncionesGenerales.menuTorre();
                case 2 ->
                    user.toStringVoid();
                case 3 -> {
                    leerUsuario.leerAPS();
                }
                case 4 -> {
                    leerTorre.leerAPS();
                }
                case 5 -> {
                    String nuevaContrasena;
                    do {
                        System.out.println("Escribe una contrasena que contenga 5 letras, 1 numero y 1 caracter especial.");
                        nuevaContrasena = brString("Nueva contrasena: ");

                        if (!nuevaContrasena.matches(FUERTE)) {
                            System.out.println("");
                            System.out.println("La contrasena introducida no es fuerte");
                            System.out.println("Asegurate de que tenga minimo 5 letras, 1 numero y 1 caracter especial");
                            System.out.println("Ejemplo: MeGustaJava123+");
                            System.out.println("");
                        }
                    } while (!nuevaContrasena.matches(FUERTE));
                    //Guardamos los cambios que se hicieron
                    userBusqueda = buscarLista(usuarios, user.getNombre());
                    userBusqueda.setContrasena(nuevaContrasena);
                    escribirUsuario.escribirAPS(usuarios);
                    user=userBusqueda;
                    System.out.println("Contrasena guardada :)");
                }
                case 6 -> {
                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                            usuarios.remove(i);
                        }
                    }
                    usuarios.remove(buscarLista(usuarios, user.getNombre()));
                    escribirUsuario.escribirAPS(usuarios);
                    for (Torre t : torres) {
                        if (t.getUsuario().equalsIgnoreCase(user.getNombre())) {
                            torres.remove(t);
                        }
                    }
                    escribirTorre.escribirAPS(torres,true);
                    System.out.println("Usuario eliminado :(");
                }
                case 0 ->
                    System.out.println();

                default -> {
                    System.out.println("Opcion no valida");
                    Thread.sleep(2000);
                }
            }
        } while (opcMenu != 0);
    }

    /**
     * Metodo que busca la existencia de un usuario dentro de un linkedlist
     *
     * @param usuarios
     * @param usuario
     * @return El usuario buscado
     */
    private static Usuario buscarLista(LinkedList<Usuario> usuarios, String usuario) {
        Usuario retorno = null;
        for (Usuario userAux : usuarios) {
            if (usuario.equals(userAux.getNombre())) {
                retorno = userAux;
            }
        }
        return retorno;
    }

}
