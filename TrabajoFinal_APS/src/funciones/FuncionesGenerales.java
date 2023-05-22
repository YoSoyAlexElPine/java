package funciones;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import Objetos.Hostilidad;
import Objetos.Personaje;
import Objetos.*;
import Objetos.Torre;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class FuncionesGenerales {

	// Objeto perosnaje que utilizalemos durante los escenarios
	static Personaje personaje = new Personaje();

	/**
	 * 
	 * Funcion que ejecutara todas las funciones del esceratio Torre
	 * 
	 * @param personaje Objeto Perosnaje que se utilizara durante los escenarios
	 * 
	 */

	// Inicio funciones BufferedReader

	/**
	 * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo en
	 * trycath y de mas codigo; en valores int.
	 * 
	 * @param texto -> Sera las indicaciones que mostrara al usuario
	 * 
	 */

	public static int brInt(String texto) throws NumberFormatException, IOException {
		int retorno = -1;
		BufferedReader reader = null;
		try {
			System.out.print(texto);
			reader = new BufferedReader(new InputStreamReader(System.in));
			retorno = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Introduce datos numericos por favor");
		}
		return retorno;
	}

	/**
	 * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo en
	 * trycath y de mas codigo; en valores int.
	 * 
	 * 
	 */

	public static int brInt() {
		int retorno=-1;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			retorno = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Introduce datos numericos por favor");
		}
		return retorno;
	}

	/**
	 * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo en
	 * trycath y de mas codigo; en valores String.
	 * 
	 * @param texto -> Sera las indicaciones que mostrara al usuario
	 * 
	 */

	public static String brString(String texto) {
		String retorno = " ";
		BufferedReader reader = null;
		try {
			System.out.print(texto);
			reader = new BufferedReader(new InputStreamReader(System.in));
			retorno = reader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Introduce datos numericos por favor");
		}
		return retorno;
	}

	/**
	 * Esta funcion leera datos con el BufferedReader ahorrandonos mucho codigo en
	 * trycath y de mas codigo; en valores String.
	 * 
	 * 
	 */

	public static String brString() {
		String retorno = " ";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			retorno = reader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Introduce datos numericos por favor");
		}
		return retorno;
	}

	// fin funciones BufferedReader

	// Inicio funciones Personaje

	/**
	 * Seleccion de personaje
	 * 
	 * @see menuPersonaje()
	 * 
	 */

	public static void seleccionPersonaje() throws NumberFormatException, IOException, InterruptedException {

		boolean creacion=false;
		int opc = -1;

		do {

			menuPersonaje();
			opc = brInt("Elige opcion: ");
			switch (opc) {
			case 1:
				personaje.personajePersonalizado();
				creacion=true;
				break;
			case 2:
				personaje = Personaje.personajePredeterminado();
				creacion=true;
				break;
			case 3:
				personaje.personajeAzar();
				creacion=true;
				break;
			case 0:
				break;

			default:
				System.out.println("Opcion no valida");
				Thread.sleep(1000);
				break;
			}
			if (creacion==true && opc != 0) {
				System.out.println(personaje.getNombre()+" ha sido creado con exito :)");
				Thread.sleep(1000);
				seleccionEscenario();// Se avanza al escenarao
			}

		} while (opc != 0);// pero con posivilidad de cambiar de personaje, hasta que no decidamos salir
	}

	/**
	 * Funcion void que muestra el menu de personaje y opciones validas
	 * 
	 */

	private static void menuPersonaje() {
		System.out.println("""
						----------------------------
						-        Personajes        -
						----------------------------
						- 1. Crear personaje       -
						- 2. Seleccionar personaje -
						- 3. Generar al azar       -
						----------------------------
						- 0. Salir                 -
						----------------------------
				""");

	}

	// fin de las funciones Personaje

	// inicio funciones Escenario

	/**
	 * Funcion que muestra por pantalla las opciones de escenario a elegir
	 * 
	 */

	private static void menuEscenario() {
		System.out.println("""
				----------------------------
				-        Escenarios        -
				----------------------------
				- 1. Torre                 -
				- 2. Cueva                 -
				- 3. Templo                -
				----------------------------
				- 0. Salir                 -
				----------------------------
				""");
	}

	/**
	 * Funcion que aplica la funcion menuEscenario() para elegir el escenario
	 * 
	 * @see menuEscenario()
	 * 
	 */

	public static void seleccionEscenario() throws NumberFormatException, IOException, InterruptedException {

		int opcMenu = -1;

		do {

			menuEscenario();
			opcMenu = brInt("Elige opcion: ");
			switch (opcMenu) {
			case 1:
				menuTorre();
				break;
			case 2:
				menuCueva();
				break;
			case 3:
				menuTemplo();
				break;
			case 0:

				break;

			default:
				System.out.println("Opcion no valida");
				System.out.println("Vuelve a introducir otra opcion por favor");
				Thread.sleep(1000);
				break;
			}// fin del switch
		} while (opcMenu != 0);
	}// fin seleccionEscenario

	// fin funciones Escenario

	// Inicio funciones Torre

	public static void menuTorre() throws NumberFormatException, IOException, InterruptedException {

		// Variables
		boolean uno = false;
		int opc = -1, opc2 = -1, fuerza = 999999999;
		Torre torre1 = null;
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

		if (opc2 == 1) {
			torre1 = generarTorre();
		} else {
			torre1 = crearTorre();
		}

		do {
			if (uno) {
				Thread.sleep(4000);
				uno = true;
			} // Simple mecanismo que sirve para que no se ejecute la pimera vez que se pasa

			System.out.println("""
					-------------------------
					-      Torre opcion     -
					-------------------------
					- 1. Inspeccionar       -
					- 2. Saquear            -
					- 3. Conquistar         -
					- 4. Vender cerdos      -
					- 5. Dibujar            -
					- 6. Evento aleatorio   -
					- 7. Cazar cerdos       -
					- 8. Inventario         -
					- 9. Comerciar          -
					-------------------------
					- 0. Salir              -
					-------------------------
					""");

			opc = brInt("Elige opcion: ");
			System.out.println("Opción introducida: " + opc);
			switch (opc) {
			case 1 -> torre1.investigar();
			case 2 -> personaje.setDinero(personaje.getDinero()+torre1.saquear());
			case 3 -> torre1.conquistar(fuerza);
			case 4 -> {
				personaje.setDinero(personaje.getDinero()+torre1.comerciar(personaje.getCerdos(), "cerdos"));
			}
			case 5 -> torre1.dibujar();
			case 6 -> torre1.generarEventoAleatorio();
			case 7 -> {
				personaje.cazarCerdos();
			}
			case 8 -> {
				personaje.inventario();
			}
			case 9 -> {
				int opcArmas = 0;
				do {
					int precioArma = 0, fuerzaArma = 0;
					System.out.println("""
							-----------------------------------------------------------
							-                 Tienda de armas                         -
							-----------------------------------------------------------
							- 1. Espada de madera - 100 dinero - 10 fuerza            -
							- 2. Espada de hierro - 500 dinero - 100 fuerza           -
							- 3. Espada de adamatium - 10.000 dinero - 20.000 fuerza  -
							-----------------------------------------------------------
							- 0. Salir                                                -
							-----------------------------------------------------------
							""");

					opcArmas = brInt();

					switch (opcArmas) {
					case 0: {
						break;
					}
					case 1: {
						precioArma = 100;
						fuerzaArma = 10;
						break;
					}
					case 2: {
						precioArma = 500;
						fuerzaArma = 100;
						break;
					}
					case 3: {
						precioArma = 10000;
						fuerzaArma = 20000;
						break;
					}
					default:
						throw new IllegalArgumentException("Valor incorrecto: " + opcArmas);
					}
					if (personaje.getDinero() - precioArma < 0) {
						System.out.println("Mas te gustaria, pero no tienes dinero suficiente.");
					} else {
						personaje.setDinero(personaje.getDinero() - precioArma);
						personaje.setFuerza(personaje.getFuerza()+fuerzaArma);
						personaje.inventario();
					}
				} while (opcArmas != 0);

			}
			case 10 -> {
				System.out.println(torre1.getTamanio() + " metros.");
			}

			}// fin del switch
		} while (opc != 0);
	}// fin menuTorre()

	/**
	 * 
	 * Constructor automatico de Torres
	 *
	 */

	private static Torre generarTorre() {
		int numPlanta, botin, poder, oferta;
		boolean fortificado;
		Hostilidad hostilidad = null;
		numPlanta = (int) (Math.random() * 10);
		botin = (int) (Math.random() * 10000);
		oferta = (int) (Math.random() * 500);
		poder = (int) (Math.random() * 1000);
		int aux = (int) (Math.random());
		if (aux == 1) {
			fortificado = false;
		} else {
			fortificado = true;
		}

		int aux2 = (int) (Math.random() * 3);
		switch (aux2) {
		case 0 -> hostilidad = Hostilidad.AMISTOSA;
		case 1 -> hostilidad = Hostilidad.PASIVA;
		case 2 -> hostilidad = Hostilidad.HOSTIL;
		case 3 -> hostilidad = Hostilidad.HOSTIL;
		}// fin del switch
		Torre torre = new Torre(numPlanta, poder, botin, oferta, "Elfica", "Norte", fortificado, false, hostilidad);
		return torre;
	}// fin de la generacion de torre

	/**
	 * 
	 * Creacion de torre personalizada
	 * 
	 */

	private static Torre crearTorre() throws NumberFormatException, IOException {
		int numPlantas = 0, botin = 0, aux = 0, aux2 = 0;

		Hostilidad aux3 = null;
		boolean fort;

		numPlantas = brInt("Introducce numero de plantas");

		botin = brInt("Introdicce el botin que tendra tu torre");

		System.out.println("Esta fortificada? 0 = no, 1 = si");

		aux = brInt();

		System.out.println("Como es su temperamento? 0 = amistoso | 1 = neutral | 2 = hostil | 3 = tuyo");
		try {
			aux2 = brInt("Introducce numero de plantas");
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (aux2) {
		case 0 -> aux3 = Hostilidad.AMISTOSA;
		case 1 -> aux3 = Hostilidad.PASIVA;
		case 2 -> aux3 = Hostilidad.HOSTIL;
		case 3 -> aux3 = Hostilidad.TUYA;
		}

		if (aux == 0) {
			fort = false;
		} else {
			fort = true;
		}
		Torre torre = new Torre(numPlantas, 100, botin, 200, "Humana", "Oeste", fort, false, aux3);
		return torre;
	}// fin clase

	// fin funciones Torre

	// Inicio funciones

	/**
	 * Menu con todas las funciones del objeto templo
	 * 
	 * @param personaje2
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */

	private static void menuTemplo() throws NumberFormatException, IOException, InterruptedException {

		int opcMenu = -1;
		Templo templo = new Templo();

		do {

			System.out.println("""
					----------------------------------
					-		 Templo opciones         -
					----------------------------------
					- 1. Investigar                  -
					- 2. Consquistar                 -
					- 3. Ganar confianza             -
					- 4. Preguntarle que tal         -
					- 5. Informacion                 -
					----------------------------------
					- 0. Salir                       -
					----------------------------------
					""");
			opcMenu = brInt("Elige opcion: ");
			switch (opcMenu) {
			case 1:
				templo.investigar();
				break;
			case 2:
				templo.conquistar(personaje.getFuerza());
				break;
			case 3:
				templo.preguntar();
				break;
			case 4:
				templo.hablar();

				break;
			case 5:
				System.out.println(Templo.descripcion);
				break;
			case 0:

				break;

			default:
				break;
			}

		} while (opcMenu != 0);
	}

	private static void menuCueva() throws NumberFormatException, IOException {
		int opcMenu = -1;
		Cueva cueva = new Cueva();

		do {

			System.out.println("""
					----------------------------------
					-		 Cueva opciones          -
					----------------------------------
					- 1. Investigar                  -
					- 2. Saquear                     -
					- 3. Informacion                 -
					----------------------------------
					- 0. Salir                       -
					----------------------------------
					""");
			opcMenu = brInt("Elige opcion: ");
			switch (opcMenu) {
			case 1:
				cueva.investigar();
				break;
			case 2:
				cueva.conquistar(personaje.getFuerza());
				break;
			case 3:
				System.out.println(Cueva.descripcion);
				break;
			case 0:

				break;

			default:
				System.out.println("Opcion no valida");
				System.out.println("Elige de nuevo");
				break;
			}

		} while (opcMenu != 0);

	}

}
