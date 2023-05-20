package test;
/**
 * @author Pablo
 * @version 1.0
 * @since 4/05/2023
 * 
 */
import static org.junit.Assert.*;


import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clases.Utilidades;

public class TestUtilidades {

	
	static Utilidades util;
	static int[] listaPequeña;
	static int[] listaGrande;
	

	/**
	 * Metodo que realiza lo que le escribamos al inicio de la ejecuccion * @throws
	 * Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Inicializamos un objeto de la clase Utilidades para cada vez que se inicia el
		// test
		util = new Utilidades();
		// Inicializamos una lista pequeña(tamaño 5)
		listaPequeña = new int[5];

		// Inicializamos un array MUY GRANDE (tamaño 15000)
		listaGrande = new int[15000];
		
	}

	/**
	 * Metodo que realiza lo que le escribamos antes de CADA PRUEBA
	 */
	@Before
	public void setUp() {
		// Vamos a rellenar los valores de la lista pequeña a mano y la grande
		// aleatoriamente
		listaPequeña[0] = 4;
		listaPequeña[1] = 2;
		listaPequeña[2] = 5;
		listaPequeña[3] = 1;
		listaPequeña[4] = 3;

		util.rellenarArray(listaGrande, 1, 15000); // El grande con numeros del 1 al 15000 desordenado
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test para ordenar con metodo Burbuja
	 */
	@Test (timeout = 1000)
	public void testOrdenarBurbuja() {
		
		System.out.println("*******************************************");
		System.out.println("ORDENACION CON BURBUJA");
		System.out.println("La lista pequeña se ha ordenado correctamente : ");
		System.out.print("Lista pequeña antes: " + Arrays.toString(listaPequeña));
		System.out.println();
		
		int[] listaPequeñaEsperada = { 1, 2, 3, 4, 5 };
		int[] listaGrandeEsperada = new int[15000];
		// Ordenamos los arrays pequeños y grande con el metodo burbuja
		util.ordenarBurbuja(listaPequeña);
		util.ordenarBurbuja(listaGrande);

		// Rellenamos y ordenamos el array grande ESPERADO
		util.rellenarArray(listaGrandeEsperada, 1, 15000);
		Arrays.sort(listaGrandeEsperada);

		// Usamos assertArrayEquals porque necesitamos comparar 2 arrays
		assertArrayEquals(listaPequeñaEsperada, listaPequeña);
		// assertArrayEquals(listaGrandeEsperada,listaGrande);

		System.out.println("Lista pequeña despues: " + Arrays.toString(listaPequeña));
		System.out.println("*******************************************");
		System.out.println("");
	}

	/**
	 * Test para ordenar con método QuickSort
	 */
	@Test (timeout = 2000)
	public void testOrdenarQuicksortArray() {
		System.out.println("*******************************************");
		System.out.println("ORDENACION CON QUICKSORT");
		System.out.println("La lista pequeña se ha ordenado correctamente : ");
		System.out.print("Lista pequeña antes: " + Arrays.toString(listaPequeña));
		System.out.println();
		int[] listaPequeñaEsperada = { 1, 2, 3, 4, 5 };
		int[] listaGrandeEsperada = new int[15000];
		// Ordenamos los arrays pequeños y grande con el metodo burbuja
		util.ordenarQuicksortArray(listaPequeña, 0, listaPequeña.length - 1);
		util.ordenarBurbuja(listaGrande);

		// Rellenamos y ordenamos el array grande ESPERADO
		util.rellenarArray(listaGrandeEsperada, 1, 15000);
		Arrays.sort(listaGrandeEsperada);

		// Usamos assertArrayEquals porque necesitamos comparar 2 arrays
		assertArrayEquals(listaPequeñaEsperada, listaPequeña);

		// assertArrayEquals(listaGrandeEsperada,listaGrande);

		System.out.println("Lista pequeña despues: " + Arrays.toString(listaPequeña));
		System.out.println("*******************************************");
		System.out.println("");

	}

	/**
	 * Test para buscar en el array con método Secuencial
	 */
	@Test
	public void testBusquedaSecuencial() {
		System.out.println("*******************************************");
		System.out.println("BUSQUEDA SECUENCIAL");
		System.out.println("Caso 1: El numero no esta: ");
		System.out.println("Caso 2: El numero es el primero: ");
		System.out.println("Caso 3: El numero es el ultimo: ");
		System.out.println("Caso 4: El numero esta");
		System.out.println("");
		
		// Llamamos al metodo de busqueda secuencial para cada array
		// Caso 1:
		assertFalse(util.busquedaSecuencial(listaPequeña, 8));
		assertFalse(util.busquedaSecuencial(listaGrande, 8));
		// Case 2:
		if (1 == listaPequeña[0] || 1 == listaGrande[0]) {
			assertTrue(util.busquedaSecuencial(listaPequeña, 1));
			assertTrue(util.busquedaSecuencial(listaGrande, 1));
		}

		// Caso 3:
		if (2 == listaPequeña[listaPequeña.length-1] || 1 == listaGrande[listaGrande.length-1]) {
			assertTrue(util.busquedaSecuencial(listaPequeña, 2));
			assertTrue(util.busquedaSecuencial(listaGrande, 2));
		}
		// Caso 4:
		assertFalse(util.busquedaSecuencial(listaPequeña, 4));
		assertFalse(util.busquedaSecuencial(listaGrande, 4));
	System.out.println("*******************************************");
	System.out.println("");

	}

	/**
	 * Test of buscar en el array con metodo Binaria
	 */
	@Test
	public void testBusquedaBinIterativa() {
		System.out.println("*******************************************");
		System.out.println("BUSQUEDA BINARIA");
		System.out.println("Caso 1: El numero no esta: ");
		System.out.println("Caso 2: El numero es el primero: ");
		System.out.println("Caso 3: El numero es el ultimo: ");
		System.out.println("Caso 4: El numero esta");
		System.out.println("");

		// Llamamos al metodo de busqueda secuencial para cada array
		// Caso 1:
		assertFalse(util.busquedaBinIterativa(listaPequeña, 8));
		assertFalse(util.busquedaBinIterativa(listaGrande, 8));
		// Case 2:
		if (1 == listaPequeña[0] || 1 == listaGrande[0]) {
			assertTrue(util.busquedaBinIterativa(listaPequeña, 1));
			assertTrue(util.busquedaBinIterativa(listaGrande, 1));
		}
		

		// Caso 3:
		if (2 == listaPequeña[listaPequeña.length-1] || 1 == listaGrande[listaGrande.length-1]) {
			assertTrue(util.busquedaBinIterativa(listaPequeña, 2));
			assertTrue(util.busquedaBinIterativa(listaGrande, 2));
		}
		// Caso 4:
		assertFalse(util.busquedaBinIterativa(listaPequeña, 4));
		assertFalse(util.busquedaBinIterativa(listaGrande, 4));
	System.out.println("*******************************************");
	System.out.println("");
	}

	/**
	 * Test para ordenar el array grande y luego buscar el ultimo numero del array
	 */
	@Test
	public void testRendimiento1() {
		
		//Ordenamos el array
		util.ordenarQuicksortArray(listaGrande, 0, listaGrande.length-1);
		//Buscamos el ultimo elemento
		assertFalse(util.busquedaBinIterativa(listaGrande, listaGrande[listaGrande.length-1]));
	}
	
	/**
	 * 
	 */
	@Test
	public void testRendimiento2() {
		
		assertFalse(util.busquedaSecuencial(listaGrande, listaGrande[listaGrande.length-1]));
	}
}
