package Pruebas;

import java.io.*;
import java.util.*;

import Objetos.Torre;

public class Main_Pruebas {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File fichero=new File("usuarios");
		LectorAPS lec= new LectorAPS (fichero);
		EscritorAPS es = new EscritorAPS(fichero);
		
		/*Usuario t1=new Usuario("alex","pizza");
		Usuario t2 = new Usuario("maria", "hamburguesa");
		Usuario t3 = new Usuario("juan", "sushi");
		Usuario t4 = new Usuario("laura", "pasta");

		LinkedList<Usuario>list2=new LinkedList<>();
		
		list2.add(t1);
		list2.add(t2);
		list2.add(t3);
		list2.add(t4);
		
		es.escribirUsuarioAPS(list2);*/
		
		LinkedList<Usuario>list=new LinkedList<>();
		lec.leerUsuarioAPS();
		list=lec.leerListaUsuarioAPS();
	

		
		
		
		System.out.println("Algoritmo finalizado :)");
	}

}
