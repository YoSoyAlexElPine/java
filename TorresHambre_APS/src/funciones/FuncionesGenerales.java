package funciones;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ConcurrentModificationException;
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
    public static Usuario userAdmin;
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
        int opc, fuerza = 999999999;
        Torre torre1;

        //Generacion de torre
        torre1 = Torre.generarTorre(user);

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
        Torre torreBusqueda;
        boolean una = false;

        LinkedList<Usuario> usuarios = new LinkedList<>();
        LinkedList<Torre> torres = new LinkedList<>();

        File usuarioFichero = new File("usuarios");
        File torreFichero = new File("torres");

        String nuevaContrasena, nombreBusqueda;

        // Crea los objetos para acceder a los métodos de guardado
        LectorAPS leerUsuario = new LectorAPS(usuarioFichero);
        EscritorAPS escribirUsuario = new EscritorAPS(usuarioFichero);
        LectorAPS leerTorre = new LectorAPS(torreFichero);
        EscritorAPS escribirTorre = new EscritorAPS(torreFichero);

        //Creamos una torre por defecto si ek archivo esta vacio
        if (!torreFichero.exists()) {
            escribirTorre.escribirAPS(new Torre(userAdmin, "TorreAdmin"), true);
        }

        // Lee la lista de usuarios del archivo
        usuarios = leerUsuario.leerListaAPS();
        torres = leerTorre.leerLista();

        int opcMenu = 0;

        do {
            if (una) {
                System.out.println("");
                System.out.println("Volviendo al menu...");
                Thread.sleep(3000);

            }
            una = true;
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("-     Torres del hambre     -");
            System.out.println("-----------------------------");
            System.out.println("- 1. Jugar                  -");
            System.out.println("-----------------------------");
            System.out.println("- 2. Ver datos usuario      -");
            System.out.println("- 3. Ver listado usuarios   -");
            System.out.println("- 4. Ver listado torres     -");
            System.out.println("-----------------------------");
            System.out.println("- 5. Cambiar contrasena     -");
            System.out.println("- 6. Borrar usuario         -");
            System.out.println("- 7. Buscar usuario         -");
            System.out.println("- 8. Dar de alta            -");
            System.out.println("- 9. Dar de baja            -");
            System.out.println("-----------------------------");
            System.out.println("- 10. Buscar torre          -");
            System.out.println("- 11. Eliminar torre        -");
            System.out.println("-----------------------------");
            System.out.println("- 0. Salir                  -");
            System.out.println("-----------------------------");
            try {
                opcMenu = FuncionesGenerales.brInt("Elige opcion: "); // Lee la opción elegida por el usuario
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Asegurate de escribir tan solo nuemeros de manera correcta");
            }

            switch (opcMenu) {
                case 1 -> {
                    if (user.isAlta()) {
                        FuncionesGenerales.menuTorre(); // Llama a la función para mostrar el menú de la torre
                        torres = leerTorre.leerLista();
                    } else {
                        System.out.println("");
                        System.out.println("No puedes jugar si no das de alta a tu usuario");
                    }

                }
                case 2 ->
                    user.toStringVoid(); // Muestra los datos del usuario actual
                case 3 -> {
                    leerUsuario.leerAPS(); // Lee y muestra el listado de usuarios desde el archivo
                }
                case 4 -> {
                    leerTorre.leer(); // Lee y muestra el listado de torres desde el archivo
                }
                case 5 -> {
                    //nuevaContrasena: Variable para almacenar la nueva contraseña
                    do {
                        System.out.println("");
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
                    System.out.println("");
                    System.out.println("Contrasena guardada :)");  // Mostrar mensaje de confirmación

                }
                case 6 -> {
                    if (!"admin".equals(user.getNombre())) {
                        try {
                            for (int i = 0; i < usuarios.size(); i++) {
                                // Comprueba si el nombre del usuario en la posición actual es igual al nombre del usuario actualmente logueado
                                if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                                    // Si hay una coincidencia, elimina el usuario de la lista
                                    usuarios.remove(i);
                                    i--; // Decrementa el índice para compensar la eliminación
                                }
                            }

                            // Elimina el usuario actualmente logueado utilizando el método buscarLista()
                            usuarios.remove(buscarLista(usuarios, user.getNombre()));

                            // Escribe la lista de usuarios actualizada en el archivo
                            escribirUsuario.escribirAPS(usuarios);

                            // Crea una copia de la lista de torres para evitar ConcurrentModificationException
                            LinkedList<Torre> torresCopy = new LinkedList<>(torres);
                            for (Torre t : torresCopy) {
                                // Comprueba si el nombre de usuario asociado a la torre es igual al nombre del usuario actualmente logueado (ignorando mayúsculas y minúsculas)
                                if (t.getUsuario().equalsIgnoreCase(user.getNombre())) {
                                    // Si hay una coincidencia, elimina la torre de la lista
                                    torres.remove(t);
                                    System.out.println(t.getUsuario() + " = " + t.getNombre());
                                }
                            }

                            // Escribe la lista de torres actualizada en el archivo
                            escribirTorre.escribir(torres);

                            // Imprime un mensaje indicando que el usuario ha sido eliminado
                            System.out.println("");
                            System.out.println("Usuario eliminado :(");
                            System.out.println("");

                            // Establece opcMenu en 0 para salir del bucle do-while
                            opcMenu = 0;
                        } catch (ConcurrentModificationException e) {
                            System.out.println("Parece que los archivos se han dañado");
                            System.out.println("Elimina los archivos usuarios y torres");
                        } catch (Exception e) {
                            System.out.println("Se produjo un error al eliminar el usuario: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No puedes eliminar el usuario administrador");
                    }

                }
                case 7 -> {
                    System.out.println("");
                    nombreBusqueda = brString("Introduce el nombre del usuario a buscar: ");
                    userBusqueda = buscarLista(usuarios, nombreBusqueda);  // Buscar el Usuario en la lista de usuarios
                    if (userBusqueda == null) {
                        System.out.println("El usuario " + nombreBusqueda + " no existe :(");
                    } else {
                        System.out.println("Datos del usuario " + nombreBusqueda);
                        userBusqueda.toString();
                    }
                }
                case 8 -> {
                    userBusqueda = buscarLista(usuarios, user.getNombre());  // Buscar el Usuario en la lista de usuarios
                    userBusqueda.setAlta(true);  // Establecer la nueva contraseña en el Usuario encontrado
                    escribirUsuario.escribirAPS(usuarios);  // Escribir la lista actualizada en el archivo
                    user = userBusqueda;  // Actualizar la referencia al Usuario actual con el Usuario modificado
                    System.out.println("");
                    System.out.println("Usuario dado de alta :)");  // Mostrar mensaje de confirmación
                }
                case 9 -> {
                    userBusqueda = buscarLista(usuarios, user.getNombre());  // Buscar el Usuario en la lista de usuarios
                    userBusqueda.setAlta(false);  // Establecer la nueva contraseña en el Usuario encontrado
                    escribirUsuario.escribirAPS(usuarios);  // Escribir la lista actualizada en el archivo
                    user = userBusqueda;  // Actualizar la referencia al Usuario actual con el Usuario modificado
                    System.out.println("");
                    System.out.println("Usuario dado de baja :(");  // Mostrar mensaje de confirmación
                }
                case 10 -> {
                    nombreBusqueda = brString("Introduce el nombre de la torre a buscar: ");
                    torreBusqueda = buscaLista(torres, nombreBusqueda);  // Buscar el Usuario en la lista de usuarios
                    if (torreBusqueda == null) {
                        System.out.println("");
                        System.out.println("La torre no existe :(");
                    } else {
                        System.out.println("");
                        System.out.println("=====================");
                        torreBusqueda.toString();
                    }
                }
                case 11 -> {
                    System.out.println("");
                    nombreBusqueda = brString("Introduce el nombre de la torre a eliminar: ");
                    torreBusqueda = buscaLista(torres, nombreBusqueda);  // Buscar la torre en la lista de usuarios
                    if (torreBusqueda == null) {
                        System.out.println("");
                        System.out.println("La torre " + nombreBusqueda + " no existe :(");
                    } else {
                        if (!"TorreAdmin".equals(nombreBusqueda)) {
                            try {
                                for (int i = 0; i < usuarios.size(); i++) {
                                    // Comprueba si el nombre del usuario en la posición actual es igual al nombre del usuario actualmente logueado
                                    if (usuarios.get(i).getNombre().equals(nombreBusqueda)) {
                                        // Si hay una coincidencia, elimina el usuario de la lista
                                        usuarios.remove(i);
                                    }
                                }

                                // Elimina el usuario actualmente logueado utilizando el método buscarLista()
                                torres.remove(buscaLista(torres, nombreBusqueda));

                                // Escribe la lista de usuarios actualizada en el archivo
                                escribirTorre.escribir(torres);

                                // Escribe la lista de torres actualizada en el archivo
                                escribirTorre.escribir(torres);

                                // Imprime un mensaje indicando que el usuario ha sido eliminado
                                System.out.println("");
                                System.out.println("Torre eliminada :(");
                                torres = leerTorre.leerLista();

                            } catch (ConcurrentModificationException e) {
                                System.out.println("");
                                System.out.println("Parece que los archivos se han daniado");
                                System.out.println("Elmina los archivos usuarios y torres");

                            } catch (Exception e) {
                                System.out.println("");
                                System.out.println("Se produjo un error al eliminar el usuario: " + e.getMessage());
                            }

                        } else {
                            System.out.println("");
                            System.out.println("No puedes eliminar la torre administrador");
                        }

                    }
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
    public static Usuario buscarLista(LinkedList<Usuario> usuarios, String usuario) {
        Usuario retorno = null;
        for (Usuario userAux : usuarios) {
            // Compara el nombre del usuario en la lista con el nombre proporcionado
            if (usuario.equals(userAux.getNombre())) {
                retorno = userAux; // Asigna el usuario encontrado a la variable retorno
            }
        }
        return retorno; // Devuelve el usuario encontrado o null si no se encontró
    }

    public static Torre buscaLista(LinkedList<Torre> usuarios, String usuario) {
        Torre retorno = null;
        for (Torre userAux : usuarios) {
            // Compara el nombre del usuario en la lista con el nombre proporcionado
            if (usuario.equals(userAux.getNombre())) {
                retorno = userAux; // Asigna el usuario encontrado a la variable retorno
            }
        }
        return retorno; // Devuelve el usuario encontrado o null si no se encontró
    }

}
