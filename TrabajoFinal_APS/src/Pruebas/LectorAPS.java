package Pruebas;

import java.io.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import funciones.*;

public class LectorAPS {

	String nombreFichero = "casa";
	File fichero;

	public LectorAPS() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Dime el nombre del fichero que quieras: ");
		nombreFichero = reader.readLine();
		System.out.println();
		fichero = new File(nombreFichero);
	}

	public LectorAPS(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		fichero = new File(nombreFichero);
	}

	public int leerAPS() throws IOException, ClassNotFoundException {
		/*
		 * ObjectInputStream ois=null; File fichero = new File(nombreFichero+".obj"); if
		 * (!fichero.exists()) { System.out.println("El fichero no existe."); return -1;
		 * }
		 * 
		 * try (ObjectInputStream entrada = new ObjectInputStream(new
		 * FileInputStream(fichero))) {
		 * 
		 * @SuppressWarnings("unused") int contador=0; fichero=new
		 * File(nombreFichero+".obj"); FileInputStream fis=new FileInputStream(fichero);
		 * ois=new ObjectInputStream(fis);
		 * 
		 * while (true) { try { Object objeto = entrada.readObject(); // Realizar las
		 * operaciones necesarias con el objeto leído
		 * System.out.println(objeto.toString()); contador++; } catch
		 * (ClassNotFoundException e) {
		 * System.out.println("Error: No se pudo encontrar la clase para deserializar."
		 * ); return -1; } catch (IOException e) {
		 * System.out.println("Error de lectura del archivo."); return -1; } } } catch
		 * (IOException e) {
		 * System.out.println("Error al abrir el archivo para lectura."); return -1; }
		 */

		int contador = 0;
		ObjectInputStream ois = null;

		try {
			 fichero = new File(nombreFichero);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe");
				return -1;
			} else {
;
				while (true) {
					contador++;
					System.out.println();
					FileInputStream fis = new FileInputStream(fichero);
					ois = new ObjectInputStream(fis);
					Escenario t = (Escenario) ois.readObject();
					// Punto de rotura
					System.out.println("-----------------------");
					System.out.println("Escenario " + contador);
					t.toStringVoid();
					System.out.println("-----------------------");
					System.out.println();
				}
			}
		} catch (IOException e) {
			return contador;
		} finally {
			if (ois != null) {
				ois.close();
			} else {
				System.out.println("ois esta null");
				return -1;
			}

		}

	}

	/**
	 * Funcion que lea del fichero todos los objetos de la clase y devuelva una
	 * lista dinámica con todos ellos. Si el fichero estuviese vacío o se produjese
	 * alguna excepción la lista estará vacía. Debe comprobar si el fichero existe o
	 * no.
	 * 
	 */

	public List<Escenario> leerListaAPS() throws IOException, ClassNotFoundException {
		List<Escenario> listaObjetos = new ArrayList<>();

		fichero = new File(nombreFichero);
		ObjectInputStream ois = null;
		FileInputStream fis = new FileInputStream(fichero);
		ois = new ObjectInputStream(fis);
		try {

			if (!fichero.exists()) {
				System.out.println("El fichero no existe.");
				return listaObjetos;
			}

			Escenario objeto;
			while ((objeto = (Escenario) ois.readObject()) != null) {
				Escenario tuObjeto = (Escenario) objeto;
				listaObjetos.add(tuObjeto);
			}

		} catch (IOException e) {

		} finally {
			if (ois != null) {
				ois.close();
			} else {
				System.out.println("No se ha podido leer");
			}

		}
		System.out.println(listaObjetos.toString());

		return listaObjetos;
	}

	/**
	 * 
	 * Funcion que busque y recupere el objeto cuyo valor coincida con el indicado
	 * en el parámetro que le debes pasar, tú decides el parámetro por el que
	 * buscar, pero ten en cuenta que debe tener sentido y debe ser único. Devuelve
	 * el objeto de la clase si es que existe; null si no se encontró o se produce
	 * alguna excepción. Debe comprobar si el fichero existe o no.
	 * 
	 */

	public Escenario buscarAPS(String nombreFichero, String parametroBusqueda) {
		try {
			File fichero = new File(nombreFichero);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe.");
				return null;
			}

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));
			Escenario objetoEncontrado = null;

			while (true) {
				try {
					Escenario objeto = (Escenario) entrada.readObject();
					if (objeto instanceof Escenario) {
						Torre miObjeto = new Torre();
						if (miObjeto.equals(parametroBusqueda)) {
							objetoEncontrado = miObjeto;
							break;
						}
					}
				} catch (EOFException e) {
					break;
				}
			}

			entrada.close();
			return objetoEncontrado;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null; // Error durante la lectura
		}
	}
}
