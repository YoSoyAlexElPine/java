package Pruebas;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import funciones.*;

public class Main_Pruebas {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//EscritorAPS 
		
		Torre torre=new Torre();
		
		List<Escenario> listaObjetos = new ArrayList<>();
		List<Escenario> listaObjetos2 = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			Torre torre2=new Torre();
			listaObjetos.add(torre);
		}
		
		EscritorAPS es = new EscritorAPS();
		
		System.out.println("Escritura: "+es.escribirAPS(torre));
		
		
		//LectorAPS
		
		LectorAPS lec=new LectorAPS(es.getNombreFichero());
		lec.leerAPS();
		listaObjetos2.addAll(lec.leerListaAPS());

		System.out.println(listaObjetos.toString());
		System.out.println(listaObjetos2.toString());
		
		
		
		
		
		System.out.println(":)");
	}
	
	public static void chatgpt() {
		 String filePath = "pene"; // Ruta del archivo serializado
	        
	        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {
	            Escenario object;
	            int objectCount = 0;

	            while ((object = (Escenario)input.readObject()) != null) {
	                // Hacer algo con cada objeto leído
	                // Por ejemplo, imprimir su información por consola
	                object.toString();
	                objectCount++;
	            }

	            System.out.println("Número total de objetos leídos: " + objectCount);
	        } catch (EOFException e) {
	            // Se alcanzó el final del archivo, salir del bucle
	            System.out.println("Fin del archivo.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
