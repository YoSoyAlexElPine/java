package funciones;

import java.io.*;
import java.util.Scanner;
import static funciones.Colores.ANSI_BLUE;
import static funciones.Colores.ANSI_GREEN;
import static funciones.Colores.ANSI_RED;

public class Torre extends Escenario implements Dibujable, Serializable {

	private static final long serialVersionUID = 1L;
	protected int numPlanta, oferta;
	protected boolean fortificada;

	public Torre() {
		tamanio = 3f + numPlanta * 3.14f;
		poder = (int) (Math.random() * 1000);
		botin = (int) (Math.random() * 1000);
		numPlanta = (int) (Math.random() * 1000);
	}

	public Torre(int nuPlanta, int poder, int botin, int oferta, boolean fortificada) {
		super();
		this.numPlanta = nuPlanta;
		this.poder = poder;
		this.botin = botin;
		this.oferta = oferta;
		this.fortificada = fortificada;
	}

	/**
	 * @param nuPlanta
	 * @param oferta
	 * @param fortificada
	 */
	public Torre(int nuPlanta, int oferta, boolean fortificada) {
		super();
		this.numPlanta = nuPlanta;
		this.oferta = oferta;
		this.fortificada = fortificada;
	}

	public Torre(int numPlanta, int poder, int botin, int oferta, String string, String string2, boolean fortificado,
			boolean b, Hostilidad hostilidad) {
		this.numPlanta = numPlanta;
		this.poder = poder;
		this.botin = botin;
		this.oferta = oferta;
		this.bloqueo = fortificado;
	}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	public int getPoder() {
		return poder;
	}

	public Hostilidad getHostilidad() {
		return hostilidad;
	}

	public int getNuPlanta() {
		return numPlanta;
	}

	public void setNuPlanta(int nuPlanta) {
		this.numPlanta = nuPlanta;
	}

	public boolean isFortificada() {
		return fortificada;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public void setExplorado(boolean explorado) {
		this.explorado = explorado;
	}

	public void setHostilidad(Hostilidad hostilidad) {
		this.hostilidad = hostilidad;
	}

	public float getTamanio() {
		return tamanio;
	}

	public String getnombre() {
		return nombre;
	}

	public boolean isExplorado() {
		return explorado;
	}

	public void setFortificada(boolean fortificada) {
		this.fortificada = fortificada;
	}

	public int getBotin() {
		return botin;
	}

	public void setBotin(int botin) {
		this.botin = botin;
	}

	@Override
	public void generarEventoAleatorio() {
		int numero = (int) (Math.random() * 5);
		switch (numero) {
		case 1 -> {
			int numeroPisos = (int) (Math.random() * 5);
			System.out.println("Los dueños de la torre deciden mejorar su torre agregando " + numeroPisos + " más.");
			numPlanta = numPlanta + numeroPisos;
		}
		case 2 -> {
			int cosecha = (int) (Math.random() * 500);
			System.out.println("En la utlima cosecha la torre a obtenido " + cosecha + " a su botin.");
			botin = botin + cosecha;
		}
		case 3 -> {
			int perdida = (int) (Math.random() * 300);
			System.out.println("Ocurre una crisis con costes de " + perdida + ".");
			if (botin - perdida < 0) {
				botin = 0;
			} else {
				botin = botin - perdida;

			}
		}
		case 4 -> {
			Hostilidad h = null;
			do {
				int ruleta = (int) (Math.random() * 3);
				switch (ruleta) {
				case 0 -> h = Hostilidad.HOSTIL;
				case 1 -> h = Hostilidad.PASIVA;
				case 2 -> h = Hostilidad.AMISTOSA;
				case 3 -> h = Hostilidad.AMISTOSA;
				}
			} while (h == hostilidad);
			hostilidad = h;
			System.out.println("La torre ha decidido cambiar su hostilidad y ahora es " + hostilidad);

		}
		case 5 -> {
			int num = (int) (Math.random() * 2);
			oferta = oferta * num;
			System.out.println("Reoganizacion del mercado hace que la oferta ahora sea de " + oferta);
		}
		}
	}

	@Override
	public String toString() {
		return "Numero de plantas=" + numPlanta + ", poder=" + poder + ", botin=" + botin + ", oferta=" + oferta
				+ ", fortificada=" + fortificada + ", hostilidad=" + hostilidad + "]";
	}

	public void toStringVoid() {
		System.out.println("id = " + this.getCont());
		System.out.println("Numero de Plantas = " + numPlanta);
		System.out.println("Poder = " + poder);
		System.out.println("Botin = " + botin);
		System.out.println("Oferta = " + oferta);
		System.out.println("Fortificada = " + fortificada);
		System.out.println("Hostilidad = " + hostilidad);
	}

	public int saquear() {
		int memoria = botin;
		System.out.println("Has saqueado la torre, ahora el botin " + botin + " te pertenece");
		botin = 0;
		hostilidad = Hostilidad.HOSTIL;
		return memoria;
	}

	public boolean conquistar(int fuerza) {
		boolean resultadoBatalla;
		if (fuerza > poder) {
			System.out.println("Ahora la torre te pertenece");
			setHostilidad(Hostilidad.TUYA);
			resultadoBatalla = true;
		} else {
			System.out.println("No has logrado conquistar la torre y lo has perdido todo.");
			resultadoBatalla = false;
		}
		return resultadoBatalla;
	}

	public void comerciar(int mercancia, String nombre) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opc3, dinero = 0;
		if (hostilidad != Hostilidad.HOSTIL) {
			System.out.println("tienes " + mercancia + " " + nombre);
			System.out.println("Ofrecen " + oferta + " por cada unidad");
			do {
				System.out.println("Cuantos quieres comerciar? (Pulsa 0 para dejar de comerciar).");
				opc3 = scanner.nextInt();
				if (opc3 != 0) {
					if (opc3 > mercancia) {
						System.out.println("No tienes " + opc3 + " " + nombre + ", por favor sea serio.");
					} else {
						dinero = dinero + opc3 * oferta;
						mercancia = mercancia - opc3;
						System.out.println("Has recivido " + opc3 * oferta + " dinero");
						System.out.println("Tienes " + dinero + " dinero y " + mercancia + " " + nombre);
					}
					if (mercancia == 0) {
						System.out.println("No te quedan " + nombre + ".");
					}
				}
			} while (opc3 != 0);
		} else {
			System.out.println("No puedes comerciar con torres hostiles");
		}

	}

	public void investigar() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		if (explorado == true) {
			System.out.println(toString());
		} else {
			System.out.println("Parece que es una torre desconocida.");
			System.out.println("Quieres investigarla? (0 = no, 1 = si");
			int opcInves = teclado.nextInt();
			if (opcInves == 1) {
				explorado = true;
				System.out.println("Parece que es una torre " + getHostilidad());
				System.out.println(toString());
				dibujar();
			} else {
				System.out.println("La torre sigue siendo desconocida");
			}
		}
	}

	public void dibujar() {
		if (explorado == true) {
			Hostilidad valor = this.getHostilidad();
			switch (valor) {
			case HOSTIL -> {
				System.out.println(ANSI_RED + "    __ ");
				System.out.println(ANSI_RED + "   |  ");
				System.out.println(ANSI_RED + "   |");
			}
			case PASIVA -> {
				System.out.println(ANSI_BLUE + "    __ ");
				System.out.println(ANSI_BLUE + "   |  ");
				System.out.println(ANSI_BLUE + "   |");
			}
			case AMISTOSA -> {
				System.out.println(ANSI_GREEN + "    __ ");
				System.out.println(ANSI_GREEN + "   |  ");
				System.out.println(ANSI_GREEN + "   |");
			}
			case TUYA -> {
				System.out.print("\u001B[0m");
				System.out.println("    __ ");
				System.out.println("   |  ");
				System.out.println("   |");
			}
			}
			System.out.print("\u001B[0m");
			System.out.println("  /^\\");
			System.out.println("  |#|");
			System.out.println(" |===|");
			System.out.println("  |0|");
			for (int i = 0; i < numPlanta; i++) {

				System.out.println("  | |");

			}
			System.out.println("""
					 =====
					_||_||_
					""");
		} else {
			System.out.println("Esta torre aun es desconocida para ti");
		}

	}

	@Override
	public void menuOpciones() {
		// TODO Auto-generated method stub

	}
}
