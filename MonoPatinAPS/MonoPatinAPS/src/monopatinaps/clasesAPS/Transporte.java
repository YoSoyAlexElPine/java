package monopatinaps.clasesAPS;

public class Transporte {

	// Variables

	protected int valoracion, precio;
	protected String referencia, descripcion;
	protected boolean electrico;
	protected static int cont = 0;

	// Constructor 1

	public Transporte() {
		cont++;
		this.referencia = generarReferencia();
	}

	// Constructor 2

	public Transporte(int valoracion, int precio, String referencia, String descripcion, boolean electrico) {
		this.valoracion = valoracion;
		this.precio = precio;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.electrico = electrico;
		cont++;
	}

	// Constructor 3

	public Transporte(int valoracion, int precio, String referencia, String descripcion) {
		this.valoracion = valoracion;
		this.precio = precio;
		this.referencia = referencia;
		this.descripcion = descripcion;
		electrico = true;
		cont++;
	}

	// Constructor 4

	public Transporte(String referencia, String descripcion) {
		this.referencia = referencia;
		this.descripcion = descripcion;
		cont++;
		electrico = true;
	}

	// Implementacion

	public void imprimir() {
	}

	/**
	 * Datos de objetos tipo transporte
	 */

	public void datos() {
		System.out.println("=== Datos Transporte ===");
		System.out.print("Valoracion = ");
		
		for (int i = 0; i < valoracion; i++) {
			System.out.print("* ");
		}

		System.out.println("");
		
		System.out.println("Precio = " + precio);
		System.out.println("Referencia = " + referencia);
		System.out.println("Descripcion = " + descripcion);
		System.out.println("Electrico = " + electrico);
		
		System.out.println("");

	}
	
	/**
	 * Metodo que valida la referencia
	 * 
	 */
	
	public boolean validarReferencia(String ref) {
		boolean valida=false;
		String patron="[0-9]{4}-[A-Z]{3}";
		return true;
	}

	/**
	 * Mediante uso de string builder y Math.random createmos una referencia valida
	 * y aleatoria
	 */

	public String generarReferencia() {
		StringBuilder sb = new StringBuilder();
		int a = (int) (Math.random() * 9999);
		String s1 = "QWERTYUIOPASDFGHJKLZXCVBNM", resultado;
		sb.append(a);
		sb.append("-");
		for (int i = 0; i < 3; i++) {
			sb.append(s1.charAt((int) (Math.random() * s1.length())));
		}
		resultado = sb.toString();
		return resultado;
	}
	
	//Getters y setters

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
	}

	public int getValoracion() {
		return valoracion;
	}

	public int getPrecio() {
		return precio;
	}

	public int getCont() {
		return cont;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isElectrico() {
		return electrico;
	}



}
