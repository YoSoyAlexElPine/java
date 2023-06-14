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
        // Declara las variables necesarias
        Usuario userBusqueda;
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
                opcMenu = FuncionesGenerales.brInt("Elige opcion: "); // Lee la opción elegida por el usuario
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Asegurate de escribir tan solo nuemeros de manera correcta");
            }

            switch (opcMenu) {
                case 1 ->
                    FuncionesGenerales.menuTorre(); // Llama a la función para mostrar el menú de la torre
                case 2 ->
                    user.toStringVoid(); // Muestra los datos del usuario actual
                case 3 -> {
                    leerUsuario.leerAPS(); // Lee y muestra el listado de usuarios desde el archivo
                }
                case 4 -> {
                    leerTorre.leer(); // Lee y muestra el listado de torres desde el archivo
                }
                case 5 -> {
                    String nuevaContrasena;  // Variable para almacenar la nueva contraseña
                    do {
                        System.out.println("Escribe una contrasena que contenga 5 letras, 1 numero y 1 caracter especial.");
                        nuevaContrasena = brString("Nueva contrasena: ");  // Leer la nueva contraseña desde la entrada del usuario

                        if (!nuevaContrasena.matches(FUERTE)) {  // Verificar si la contraseña cumple con los requisitos de fuerza
                            System.out.println("");
                            System.out.println("La contrasena introducida no es fuerte");
                            System.out.println("Asegurate de que tenga minimo 5 letras, 1 numero y 1 caracter especial");
                            System.out.println("Ejemplo: MeGustaJava123+");
                            System.out.println("");
                        }
                    } while (!nuevaContrasena.matches(FUERTE));  // Repetir el bucle mientras la contraseña no cumpla con los requisitos de fuerza

                    // Guardamos los cambios que se hicieron
                    userBusqueda = buscarLista(usuarios, user.getNombre());  // Buscar el Usuario en la lista de usuarios
                    userBusqueda.setContrasena(nuevaContrasena);  // Establecer la nueva contraseña en el Usuario encontrado
                    escribirUsuario.escribirAPS(usuarios);  // Escribir la lista actualizada en el archivo
                    user = userBusqueda;  // Actualizar la referencia al Usuario actual con el Usuario modificado
                    System.out.println("Contrasena guardada :)");  // Mostrar mensaje de confirmación

                }
                case 6 -> {
                    for (int i = 0; i < usuarios.size(); i++) {
                        // Comprueba si el nombre del usuario en la posición actual es igual al nombre del usuario actualmente logueado
                        if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                            // Si hay una coincidencia, elimina el usuario de la lista
                            usuarios.remove(i);
                        }
                    }

                    // Elimina el usuario actualmente logueado utilizando el método buscarLista()
                    usuarios.remove(buscarLista(usuarios, user.getNombre()));

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
                    escribirTorre.escribirAPS(torres, true);

                    // Imprime un mensaje indicando que el usuario ha sido eliminado
                    System.out.println("Usuario eliminado :(");

                    // Establece opcMenu en 0 para salir del bucle do-while
                    opcMenu = 0;

                }
                case 0 ->
                    System.out.println();

                default -> {
                    System.out.println("Opcion no valida");
                    Thread.sleep(2000);
                }
            }

        } while (opcMenu
                != 0);
    }

    /**
     * Busca un usuario en una lista de usuarios.
     *
     * @param usuarios la lista de usuarios en la que buscar.
     * @param usuario el nombre del usuario a buscar.
     * @return el usuario encontrado o null si no se encuentra.
     */
    private static Usuario buscarLista(LinkedList<Usuario> usuarios, String usuario) {
        Usuario retorno = null;
        for (Usuario userAux : usuarios) {
            // Compara el nombre del usuario en la lista con el nombre proporcionado
            if (usuario.equals(userAux.getNombre())) {
                retorno = userAux; // Asigna el usuario encontrado a la variable retorno
            }
        }
        return retorno; // Devuelve el usuario encontrado o null si no se encontró
    }

}
