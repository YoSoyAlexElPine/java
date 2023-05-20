package sdfadf;


import java.io.*;



import java.util.ArrayList;
import java.util.List;



public class LectorAPS {

	String nombreFichero;
	File fichero;

	/*
	 * public LectorAPS() throws IOException { BufferedReader reader = new
	 * BufferedReader(new InputStreamReader(System.in));
	 * System.out.print("Dime el nombre del fichero que quieras: "); nombreFichero =
	 * reader.readLine(); System.out.println(); fichero = new File(nombreFichero); }
	 */

	public LectorAPS(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		fichero = new File(nombreFichero);
	}

	public void leerAPS() throws IOException, ClassNotFoundException {
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

		int contador=0;
		ObjectInputStream ois=null;
		try {
			File fichero=new File(nombreFichero);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe");
			}
			FileInputStream fis=new FileInputStream(fichero);
			ois=new ObjectInputStream(fis);
			while(true) {
				contador++;
				System.out.println();
				System.out.println();
				System.out.println("Torre "+contador);
				Torre t=(Torre) ois.readObject();
				System.out.println(t.toString());
				System.out.println();
				System.out.println();
			}
		}catch (IOException e) {
			System.out.println("fin");
		}finally {
			if (ois!=null) {
				ois.close();
			}
			System.out.println("ois esta null");
		}

	}

	public List<Escenario> leerListaAPS() {
		List<Escenario> listaObjetos = new ArrayList<>();

		try {
			File fichero = new File(nombreFichero);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe.");
				return listaObjetos;
			}

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));

			while (true) {
				try {
					Object objeto = entrada.readObject();
					if (objeto instanceof Torre) {
						Torre miObjeto = (Torre) objeto;
						listaObjetos.add(miObjeto);
					}
				} catch (EOFException e) {
					break;
				}
			}

			entrada.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listaObjetos;
	}

	@SuppressWarnings("unlikely-arg-type")
	public Torre buscarAPS(String nombreFichero, String parametroBusqueda) {
		try {
			File fichero = new File(nombreFichero);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe.");
				return null;
			}

			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));
			Torre objetoEncontrado = null;

			while (true) {
				try {
					Torre objeto = (Torre) entrada.readObject();
					if (objeto instanceof Torre) {
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
