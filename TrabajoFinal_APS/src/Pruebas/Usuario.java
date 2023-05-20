package Pruebas;

public class Usuario {
	String nombre,contrasena;
	/**
	 * @param nombre
	 * @param contrasena
	 */
	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public Object getNombreUsuario() {
		
		return nombre;
	}

	public Object getContrasena() {
		return contrasena;
	}

}
