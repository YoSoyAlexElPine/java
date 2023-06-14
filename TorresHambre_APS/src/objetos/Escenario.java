
package objetos;

import java.io.*;
import funciones.FuncionesGenerales;

/**
 *
 * @author Alex Pineño Sanchez
 */
public abstract class Escenario implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static int cont = 0;
	protected int botin, poder, beneficios;
	protected float tamanio;
	protected String nombre;
	protected boolean explorado, bloqueo;
	protected Hostilidad hostilidad = Hostilidad.PASIVA;

	public Escenario() {
		cont++;
	}

	public Escenario(float tamanio, String nombre, boolean explorado, Hostilidad hostilidad) {
		this.tamanio = tamanio;
		this.nombre = nombre;
		this.explorado = explorado;
		this.hostilidad = hostilidad;
		cont++;
	}

	public Escenario(String nombre, boolean explorado, Hostilidad hostilidad) {
		this.nombre = nombre;
		this.explorado = explorado;
		this.hostilidad = hostilidad;
		cont++;
	}

	public boolean conquistar(int fuerza) {
		boolean auxiliar;
		if (fuerza > poder) {
			botin = 0;
			hostilidad = Hostilidad.TUYA;
			auxiliar = true;

		} else {
			hostilidad = Hostilidad.HOSTIL;
			auxiliar = false;
		}
		
		if (auxiliar==true) {
			System.out.println("Has ganado la batalla :O");
		} else {
			System.out.println("Has perido :C");
		}
		
		return auxiliar;
	}

	public float getTamanio() {
		return tamanio;
	}

	public void setTamanio(float tamanio) {
		this.tamanio = tamanio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isExplorado() {
		return explorado;
	}

	public void setExplorado(boolean explorado) {
		this.explorado = explorado;
	}

	public void setHostilidad(Hostilidad hostilidad) {
		this.hostilidad = hostilidad;
	}

	public int getCont() {
		return cont;
	}

	public Hostilidad getHostilidad() {
		return hostilidad;
	}

	abstract public void generarEventoAleatorio();

	abstract public void menuOpciones();

	@Override
	public String toString() {
			return "tamanio:" + tamanio + "\nombre:" + nombre + "\nbloqueo:" + explorado + "\nhostilidad:" + hostilidad;
	}
	

	public void investigar() throws NumberFormatException, IOException {

		if (explorado == true) {
			System.out.println(toString());
		} else {
			System.out.println("Parece que es desconocida.");
			System.out.println("Quieres investigarla? (0 = no, 1 = si) ");
			int opcInves = FuncionesGenerales.brInt();
			if (opcInves == 1) {
				explorado = true;
				System.out.println("Parece que es " + getHostilidad());
				System.out.println(toString());
			} else {
				System.out.println("Sigue siendo desconocida");
			}
		}
	}

	public void toStringVoid() {
		// TODO Auto-generated method stub

	}



}
