package sdfadf;
import java.io.*;
import java.util.List;



public class EscritorAPS {


	String nombreFichero;
	File fichero;

	public String getNombreFichero() {
		return nombreFichero;
	}

	public EscritorAPS() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Dime el nombre del fichero que quieras: ");
		nombreFichero = reader.readLine();
		System.out.println();
		
		ObjectOutputStreamAPS oos = new ObjectOutputStreamAPS(new FileOutputStream(nombreFichero));
		
		
		fichero = new File(nombreFichero);
		fichero.setReadable(true);
	}

	public EscritorAPS(String nombreFichero) throws FileNotFoundException, IOException {
		this.nombreFichero = nombreFichero;
		fichero = new File(nombreFichero);
		fichero.setReadable(true);
	}

	/**
	 * Funcion que escriba en el fichero un objeto de la clase pasado como
	 * parámetro. Tiene que devolver 1 si la operación de escritura tiene éxito; -1
	 * si ocurre alguna excepción. Debe comprobar si el fichero existe o no.
	 * 
	 * @param objeto
	 * @return 1 o -1
	 */

	public int escribirAPS(Escenario objeto) {

		try {	

			if (!fichero.exists()) {
				System.out.println("El fichero donde se quiere escribir no exsite");
				return -1;
			} 
				FileOutputStream fos=new FileOutputStream(fichero);
				ObjectOutputStreamAPS oos = new ObjectOutputStreamAPS(fos);
				oos.writeObject(objeto);
				oos.close();
				fos.close();

				return 1; // Éxito en la escritura
			
		} catch (IOException e) {
			return -1; // Error durante la escritura
		}

	}

	/**
	 * Funcion que escriba en el fichero un conjunto de objetos de la clase,
	 * almacenados en una lista dinámica que se le pasará como parámetro. Tiene que
	 * devolver el nº de objetos escritos si la operación de escritura tiene éxito;
	 * -1 si ocurre alguna excepción. Debe comprobar si el fichero existe o no.
	 * 
	 * @param List<Escenario> Lista donde se almacenaran los objetos
	 * @return
	 */

	public int escribirAPS(List<Escenario> listaObjetos) {
		File fichero = new File(nombreFichero);
		try {
			if (!fichero.exists()) {
				System.out.println("El fichero donde se quiere escribir no exsite");
				return -1;
			} else {
				ObjectOutputStreamAPS oos = new ObjectOutputStreamAPS(new FileOutputStream(fichero));
				FileOutputStream fos = new FileOutputStream(nombreFichero);

				for (Escenario escenario : listaObjetos) {
					oos.writeObject(escenario);
				}

				oos.close();
				fos.close();

				return listaObjetos.size();
			}
		} catch (IOException e) {

			return -1;
		}
	}
}
