package Pruebas;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class AplicacionLogin {
    private static final String FICHERO_USUARIOS = "usuarios.txt";
    private static final int MAX_INTENTOS = 3;

    public static void login() throws IOException {
    	 @SuppressWarnings("unused")
		List<Usuario> usuarios = new ArrayList<>();
    	new Usuario("Alex","1234");
    	
    	
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean loggedIn = false;
        int intentos = 0;

        while (!loggedIn) {
            System.out.println("Ingrese su nombre de usuario: ");
            String nombreUsuario = reader.readLine();

            System.out.println("Ingrese su contraseña: ");
            String contrasena = reader.readLine();

            Usuario usuario = validarCredenciales(nombreUsuario, contrasena);
            if (usuario != null) {
                System.out.println("¡Inicio de sesión exitoso!");
                loggedIn = true;
                // Continuar con el resto de la aplicación...
            } else {
                System.out.println("Credenciales incorrectas.");
                intentos++;

                if (intentos >= MAX_INTENTOS) {
                    System.out.println("Has superado el número máximo de intentos. Debes volver a registrarte.");
                    eliminarUsuario(nombreUsuario);
                    break;
                }
            }
        }

        reader.close();
    }

    private static Usuario validarCredenciales(String nombreUsuario, String contrasena) {
        List<Usuario> usuarios = leerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                if (usuario.getContrasena().equals(contrasena)) {
                    return usuario; // Credenciales válidas
                } else {
                    return null; // Contraseña incorrecta
                }
            }
        }
        return null; // Usuario no encontrado
    }

    private static List<Usuario> leerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        //usuarios.add(new Usuario("Alex","1234"));

        try {
            File archivo = new File(FICHERO_USUARIOS);
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

    private static void guardarUsuarios(List<Usuario> usuarios) {
        try {
            File archivo = new File(FICHERO_USUARIOS);
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));

            for (Usuario usuario : usuarios) {
                salida.writeObject(usuario);
            }

            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void eliminarUsuario(String nombreUsuario) {
        List<Usuario> usuarios = leerUsuarios();
        Usuario usuarioAEliminar = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                usuarioAEliminar = usuario;
                break;
            }
        }

        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
            guardarUsuarios(usuarios);
        }
    }
}
