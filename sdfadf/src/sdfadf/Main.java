package sdfadf;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		EscritorAPS es=new EscritorAPS("texto");
	
			Torre torre=new Torre();
			System.out.println("Escritura: "+es.escribirAPS(torre));
		
		LectorAPS lec = new LectorAPS("texto");
		
		leer();
		lec.leerAPS();
		
		System.out.println(":)");
	}
	
	public  static void leer() throws IOException, ClassNotFoundException {
		int contador=0;
		ObjectInputStream ois=null;
		try {
			
			File fichero=new File("texto");
			FileInputStream fis=new FileInputStream(fichero);
			ois=new ObjectInputStream(fis);
			
			while(true) {
				contador++;
				Torre t=(Torre) ois.readObject();
				System.out.println();
				System.out.println();
				System.out.println("Torre "+contador);
				System.out.println(t.toString());
				System.out.println();
				System.out.println();
			}
		}catch (IOException e) {
			System.out.println("fin");
		}finally {
			if (ois!=null) {
				ois.close();
			} else {
			System.out.println("ois esta null");
			}

		}
	}

}
