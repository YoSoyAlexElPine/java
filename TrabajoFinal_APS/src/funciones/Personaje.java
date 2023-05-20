package funciones;

import java.util.Scanner;

public class Personaje {

	int dinero, fuerza, ariete,propiedades;
	String nombre;
	Raza raza;
	double altura;

	public Personaje() {
		dinero = 0;
		fuerza = 0;
		ariete = 0;
		nombre = "Alex";
		raza = Raza.HUMANO;
		altura = 1.8d;

	}

	public Personaje(String nombre, Raza raza, double altura) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.altura = altura;
	}

	public void personajePersonalizado() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int raza;

		System.out.println("\tCreacion de personaje");
		System.out.print("Nombre de tu personaje: ");
		this.nombre = scanner.nextLine();
		System.out.println("");
		System.out.print("Altura: ");
		this.altura = scanner.nextDouble();
		do {

			System.out.println("""
					Raza:
					1. Humano
					2. Elfo
					3. Ent
					4. Hobbit
					5. Enano
					""");
			raza = scanner.nextInt();
		} while (raza < 1 || raza > 5);
		switch (raza) {
		case 1:
			this.raza=Raza.HUMANO;
			break;
		case 2:
			this.raza=Raza.ELFO;
			break;
		case 3:
			this.raza=Raza.ENT;
			break;
		case 4:
			this.raza=Raza.HOBBIT;
			break;
		case 5:
			this.raza=Raza.ENANO;
			break;
		default:
			this.raza=Raza.HUMANO;
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

}
