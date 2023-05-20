package Pruebas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AplicacionDatos {
    private static final String FICHERO_DATOS = "datos.txt";

    public static void run() throws IOException {
    	
    	
     	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	

        boolean loggedIn = false;
        Usuario usuario = null;
        realizarOperaciones(usuario, reader);
        while (!loggedIn) {
            System.out.println("Ingrese su nombre de usuario: ");
            String nombreUsuario = reader.readLine();

            System.out.println("Ingrese su contraseña: ");
            String contrasena = reader.readLine();

            usuario = validarCredenciales(nombreUsuario, contrasena);
            if (usuario != null) {
                System.out.println("¡Inicio de sesión exitoso!");
                loggedIn = true;
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        }

        if (usuario != null) {
            realizarOperaciones(usuario,reader);
        }

        try {
			reader.close();
		} catch (IOException e) {
		}
    }

    private static Usuario validarCredenciales(String nombreUsuario, String contrasena) {
        List<Usuario> usuarios = leerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario; // Credenciales válidas
            }
        }
        return null; // Usuario no encontrado o credenciales incorrectas
    }

    private static List<Usuario> leerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            File archivo = new File(FICHERO_DATOS);
            if (!archivo.exists()) {
                return usuarios; // No hay usuarios registrados aún
            }

            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));

            while (true) {
                try {
                    Usuario usuario = (Usuario) entrada.readObject();
                    usuarios.add(usuario);
                } catch (EOFException e) {
                    break;
                }
            }

            entrada.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @SuppressWarnings("unused")
	private static void guardarUsuarios(List<Usuario> usuarios) {
        try {
            File archivo = new File(FICHERO_DATOS);
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));

            for (Usuario usuario : usuarios) {
                salida.writeObject(usuario);
            }

            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void realizarOperaciones(Usuario usuario,BufferedReader reader) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar dato");
            System.out.println("2. Eliminar dato");
            System.out.println("3. Modificar dato");
            System.out.println("4. Buscar dato");
            System.out.println("5. Obtener listado de datos");
            System.out.println("6. Salir");

            int opcion=0;
			try {
				opcion = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
			}


            switch (opcion) {
                case 1:
                    agregarDato(usuario);
                    break;
                case 2:
                    eliminarDato(usuario);
                    break;
                case 3:
                    modificarDato(usuario);
                    break;
                case 4:
                    buscarDato(usuario);
                    break;
                case 5:
                    obtenerListado(usuario);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void agregarDato(Usuario usuario) {
        // Lógica para agregar un nuevo dato usando los datos del usuario
        // ...
        System.out.println("Dato agregado exitosamente.");
    }

    private static void eliminarDato(Usuario usuario) {
        // Lógica para eliminar un dato usando los datos del usuario
        // ...
        System.out.println("Dato eliminado exitosamente.");
    }

    private static void modificarDato(Usuario usuario) {
        // Lógica para modificar un dato usando los datos del usuario
        // ...
        System.out.println("Dato modificado exitosamente.");
    }

    private static void buscarDato(Usuario usuario) {
        // Lógica para buscar un dato usando los datos del usuario
        // ...
        System.out.println("Dato encontrado.");
    }

    private static void obtenerListado(Usuario usuario) {
        // Lógica para obtener el listado de datos usando los datos del usuario
        // ...
        System.out.println("Listado de datos:");
    }
}
