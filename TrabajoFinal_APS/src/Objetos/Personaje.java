package Objetos;

import java.io.IOException;

import funciones.FuncionesGenerales;

public class Personaje {

	protected int dinero, fuerza, ariete, propiedades, cerdos;

	public int getAriete() {
		return ariete;
	}

	public void setAriete(int ariete) {
		this.ariete = ariete;
	}

	public int getCerdos() {
		return cerdos;
	}

	public void setCerdos(int cerdos) {
		this.cerdos = cerdos;
	}

	protected String nombre;
	protected Raza raza;
	protected double altura;

	public Personaje() {

	}

	

	public static Personaje personajePredeterminado() {

		Personaje pers = new Personaje();
		int opcMenu = -1;

		do {

			System.out.println("""
					--------------------------------
					-   Personajes predeterminados -
					--------------------------------
					- 1. Humano Elendil            -
					- 2. Hobbit Bilbo Bolson       -
					- 3. ENT Barbol                -
					- 4. Enano Bombur              -
					- 5. Elfo Gandalf              -
					--------------------------------
					- 0. Salir                     -
					--------------------------------
					""");
			opcMenu=FuncionesGenerales.brInt();
			switch (opcMenu) {
			case 1:
				pers.altura = 2.24d;
				pers.ariete = 2;
				pers.cerdos = 10;
				pers.dinero = 10000;
				pers.nombre = "Humano guerrero";
				pers.raza = Raza.HUMANO;
				pers.fuerza = 100;
				break;
			case 2:
				pers.altura = 1.16d;
				pers.ariete = 1;
				pers.cerdos = 5;
				pers.dinero = 1000000000;
				pers.nombre = "Bilbo Bolson";
				pers.raza = Raza.HUMANO;
				pers.fuerza = 120;
				break;
			case 3:
				pers.altura = 4.68d;
				pers.ariete = 999999999;
				pers.cerdos = 0;
				pers.dinero = 0;
				pers.nombre = "Barlbol";
				pers.raza = Raza.ENT;
				pers.fuerza = 10000;
				break;
			case 4:
				pers.altura = 1.40d;
				pers.ariete = 1;
				pers.cerdos = 20;
				pers.dinero = 10;
				pers.nombre = "Bombur";
				pers.raza = Raza.ENANO;
				pers.fuerza = 50;
				break;
			case 5:
				pers.altura = 1.63d;
				pers.ariete = 2;
				pers.cerdos = 0;
				pers.dinero = 23;
				pers.nombre = "Galdalf el gris";
				pers.raza = Raza.ELFO;
				pers.fuerza = 2000;
				break;
			case 0:

				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (opcMenu < 0 || opcMenu > 5);
		return pers;
	}

	public void personajeAzar() {
		this.altura = (Math.random() + 0.5 * 2);
		this.ariete = (int) (Math.random() * 10);
		this.cerdos = (int) (Math.random() * 10);
		this.dinero = (int) (Math.random() * 10);
		this.fuerza = (int) (Math.random() * 10);
		this.nombre = "Alexandru";
		switch ((int) (Math.random() * 4)) {
		case 0:
			this.raza=Raza.ELFO;
			break;
		case 1:
			this.raza=Raza.HUMANO;
			break;
		case 2:
			this.raza=Raza.HOBBIT;
			break;
		case 3:
			this.raza=Raza.ENANO;
			break;
		case 4:
			this.raza=Raza.ENT;
			break;

		default:
			this.raza=Raza.HUMANO;
			break;
		}
	}


	public Personaje(String nombre, Raza raza, double altura) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.altura = altura;
	}

	public void personajePersonalizado() throws NumberFormatException, IOException {
		
		int raza;
		System.out.println("------------------------------");
		System.out.println("\tCreacion de personaje");
		this.nombre = FuncionesGenerales.brString("Nombre de tu personaje: ");
		System.out.println("");
		this.altura = FuncionesGenerales.brInt("Altura: ");
		do {

			System.out.println("""
				-----------------
				-	1. Humano   -
				-	2. Elfo     -
				-	3. Ent      -
				-	4. Hobbit   -
				-	5. Enano    -
				-----------------
					""");
			raza = FuncionesGenerales.brInt();
		} while (raza < 1 || raza > 5);
		switch (raza) {
		case 1:
			this.raza = Raza.HUMANO;
			break;
		case 2:
			this.raza = Raza.ELFO;
			break;
		case 3:
			this.raza = Raza.ENT;
			break;
		case 4:
			this.raza = Raza.HOBBIT;
			break;
		case 5:
			this.raza = Raza.ENANO;
			break;
		default:
			this.raza = Raza.HUMANO;
			break;
		}

	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void inventario() {
		System.out.println("\t Inventario");
		System.out.println("Dinero: " + dinero);
		System.out.println("Cerdos: " + cerdos);
		System.out.println("Fuerza: " + fuerza);
		System.out.println("Ariete: " + ariete);
		System.out.println();
	}

	public void cazarCerdos() {

		int cerdos = (int) (Math.random() * 5);
		if (cerdos < 1) {
			System.out.println("Parece que no hubo suerte, o punteria.");
		} else {
			System.out.println("Tu caza ha dado frutos.");
		}
		System.out.println("Has cazado " + cerdos + " cerdos");
		this.cerdos = this.cerdos + cerdos;

	}

}
