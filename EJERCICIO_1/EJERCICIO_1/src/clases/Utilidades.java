package clases;
/**
 * 
 * @author Pablo
 * @version
 *
 */
public class Utilidades {
	
	public Utilidades() {

	}

	/**
	 * Metodo para rellenar de forma aleatoria un array 
	 * @param listaArray
	 * @param min
	 * @param max
	 */
	public  void rellenarArray(int listaArray[],int min,int max) {

		for (int i = 0; i < listaArray.length; i++) {

			listaArray[i] = (int) (Math.random() * (max - min + 1) + min);

		}
	

	}

	/**
	 * Metodo de busqueda secuencial (modificarlo para que en vez de true o false devuela -1 o 1
	 * segun si encuentra eel num o no
	 * @param lista
	 * @param valor
	 * @return
	 */
	public  boolean busquedaSecuencial(int lista[], int valor) {

		int i;

		boolean encontrado = false;

		for (i = 0; i < lista.length && encontrado; i++) {

			if (lista[i] == valor) {

				encontrado = true;

			}

		}

		return encontrado;

	}

	public boolean busquedaBinIterativa(int lista[], int valor) {

		int cen = 0;

		int izq = 0;

		int der = lista.length;

		boolean encontrado = false;

		while (izq <= der && encontrado) {

			cen = (int) ((izq + der) / 2);

			if (lista[cen] == valor) {

				encontrado = true;

			} else {

				if (lista[cen] > valor) {

					izq = cen + 1;

				} else {

					der = cen - 1;

				}

			}

		}

		return encontrado;

	}

	public void ordenarBurbuja(int lista[]) {

		boolean ordenado = false;

		int aux, i;

		while (!ordenado) {

			ordenado = true;

			for (i = 0; i < lista.length - 1; i++) {

				if (lista[i] > lista[i + 1]) {

					// se realiza el intercambio

					aux = lista[i];

					lista[i] = lista[i + 1];

					lista[i + 1] = aux;

					// se cambia el valor a la variable bandera

					ordenado = false;

				}

			}

		}

	}

	public void ordenarQuicksortArray(int lista[], int izq, int der) {

		int i, j, cen, aux;

		i = izq;

		j = der;

		cen = lista[(izq + der) / 2];

		do {

			while (lista[i] < cen) {

				i++;

			}

			while (lista[j] > cen) {

				j--;

			}

			if (i <= j) {

				aux = lista[i];

				lista[i] = lista[j];

				lista[j] = aux;

				i++;

				j--;

			}

		} while (i <= j);

		if (izq < j) {

			ordenarQuicksortArray(lista, izq, j);

		}

		if (i < der) {

			ordenarQuicksortArray(lista, i, der);

		}

	}
}
