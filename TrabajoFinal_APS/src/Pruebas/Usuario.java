package Pruebas;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import funciones.FuncionesGenerales;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String nombre, contrasena, colorFav = "no tiene", comidaFav = "no tiene", email = "no tiene";
	protected int numero = 0;
	protected double saldo = 0;
	protected File usuarios = new File("usuarios");

	static boolean login = false;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	/**
	 * @param nombre
	 * @param contrasena
	 */
	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;

	}

	public String getNombreUsuario() {

		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public static boolean login() throws IOException, InterruptedException {

		String contrasena,nombre;
		int intentos = 3;
		
		nombre=FuncionesGenerales.brString("Nombre: ");
		
		LectorAPS lec = new LectorAPS(new File("usuarios"));
		Usuario user = lec.buscarUsuarioAPS(nombre);

		if (user == null) {
			System.out.println("Usuario no encontrado");
			System.out.println("Asegurate de escribir bien el nombre o haberse resgistrado previamente");
		Thread.sleep(2000);
		} else {
			do {
				contrasena = FuncionesGenerales.brString("Contrasena: ");
				if (user.getContrasena().equals(contrasena)) {
					System.out.println("Contraseña correcta :)");
					login = true;
				} else {
					intentos--;
					System.out.println(user.getContrasena());
					System.out.println("Contraseña incorrecta.");
					login = false;
				}
			} while (login == false && intentos>0);
				if (login==false) {
					System.out.println("Tu usario se ha elimidado. :(");
				}

		}

		return login;
	}

	public static void registrar() throws IOException, InterruptedException {
		File file = new File("usuarios");
		LectorAPS lec = new LectorAPS(file);
		String nombre, contras;

		System.out.println("\tRegistro De Usuario");

		do {

			nombre = FuncionesGenerales.brString("Nombre: ");
			if (lec.buscarUsuario2APS(nombre) != null) {
				System.out.println("Este nombre ya esta cogido.");
				System.out.println("Intenta otro Nombre.");
			}
		} while (lec.buscarUsuario2APS(nombre) != null);
		contras = FuncionesGenerales.brString("Contraseña: ");

		Usuario usr = new Usuario(nombre, contras);
		EscritorAPS es = new EscritorAPS(new File("usuarios"));
		es.escribirUsuarioAPS(usr);

		System.out.println("Usuario registrado :)");
		Thread.sleep(2000);
	}

	public int registrar(String nombre, String contrasena) throws IOException {

		int retorno = 0;
		LectorAPS lec = new LectorAPS();

		if (lec.buscarUsuarioAPS(nombre).nombre == nombre) {

			retorno = -1;

		} else {

			Usuario usr = new Usuario(nombre, contrasena);
			EscritorAPS es = new EscritorAPS(usuarios);
			es.escribirUsuarioAPS(usr);

			retorno = 1;
		}
		return retorno;
	}

	public void toStringVoid() {

		System.out.println("\t === Usuario ===");
		System.out.println();
		System.out.println("Nombre: " + nombre);
		System.out.println("Contrasena: " + contrasena);
		System.out.println("Color Favorito: " + colorFav);
		System.out.println("Comida favorita: " + comidaFav);
		System.out.println("email: " + email);
		System.out.println("Numero: " + numero);
		System.out.println("Saldo: " + saldo);
		System.out.println();
	}

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
				Elige:
				""");
	}

	private static void menuPersonalizarUsuario() {
		System.out.println("""
				------------------------------
				- Personalizacion de usuario -
				------------------------------
				- 1. Cambiar contrasenia     -
				- 2. Cambiar email           -
				- 3. Cambiar telefono        -
				------------------------------
				- 4. Comida favorita         -
				- 5. Color favorito          -
				- ----------------------------
				- 0. Salir        			 -
				------------------------------
				Elige:
				""");
	}

	public void personalizarUsuario() throws NumberFormatException, IOException, InterruptedException {

		@SuppressWarnings("unused")
		LectorAPS lec = new LectorAPS();
		int opc = 0;
		String str;

		while (opc != 0) {
			menuPersonalizarUsuario();
			opc = FuncionesGenerales.brInt();
			switch (opc) {
			case 1:
				str = FuncionesGenerales.brString("Nueva contraseña: ");
				this.contrasena = str;
				System.out.println("Cambio de contraseña exitoso :)");
				Thread.sleep(1000);
				System.out.println();
				break;
			case 2:
				str = FuncionesGenerales.brString("Nueva email: ");
				email = str;
				System.out.println("Cambio de email exitoso :)");
				Thread.sleep(1000);
				System.out.println();
				break;
			case 3:
				str = FuncionesGenerales.brString("Nueva contraseña: ");
				contrasena = str;
				System.out.println("Cambio de contraseña exitoso :)");
				Thread.sleep(1000);
				System.out.println();
				break;
			case 4:
				str = FuncionesGenerales.brString("Nueva comida favorita: ");
				comidaFav = str;
				System.out.println("Que rico.");
				System.out.println("Cambio de comida favorita exitoso :)");
				Thread.sleep(1000);
				System.out.println();
				break;
			case 5:
				str = FuncionesGenerales.brString("Nueva color: ");
				colorFav = str;
				System.out.println("Que color tan bonito.");
				System.out.println("Cambio de color exitoso :)");
				Thread.sleep(1000);
				System.out.println();
				break;
			default:
				System.out.println("Valor no valido.");
				Thread.sleep(null);
				break;
			}
		}

	}

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

}
