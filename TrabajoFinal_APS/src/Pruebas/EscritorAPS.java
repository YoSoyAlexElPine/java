package Pruebas;

import java.io.*;


import java.util.LinkedList;
import java.util.ListIterator;

import Objetos.Escenario;
import funciones.*;

public class EscritorAPS {

	File fichero;

	/**
	 * @param fichero
	 */
	public EscritorAPS(File fichero) {
		super();
		this.fichero = fichero;
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

	public int escribirEscenarioAPS(Escenario objeto) {
		   ObjectOutputStream oos = null;
	        int valorDevuelto;
	        try {
	            if (fichero.exists()){
	                oos = new ObjectOutputStreamAPS(new FileOutputStream(fichero,true));
	            } else {
	                oos = new ObjectOutputStream(new FileOutputStream(fichero,true));
	            }
	            oos.writeObject(objeto);
	            valorDevuelto = 1; 
	            oos.flush();            
	        } catch (IOException ioe){
	            System.out.print("ERROR de E/S en la escritura " + ioe.getMessage());
	            valorDevuelto = -1;
	        } catch (Exception e){
	            System.out.print("Se ha producido una EXCEPCIÓN en la escritura " + e.getMessage());
	            valorDevuelto = -1;
	        }finally {
	            if (oos!=null){
	                try{
	                    oos.close();
	                } catch (IOException e){
	                    System.out.println("No se puedo cerrar el stream en la escritura" + e.getMessage());
	                }                
	            }
	        }
	        return valorDevuelto;

	}
	
	public int escribirUsuarioAPS(Usuario objeto) {
        ObjectOutputStream oos = null;
        int retorno;
        try {
            if (fichero.exists()){
                oos = new ObjectOutputStreamAPS(new FileOutputStream(fichero,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fichero,true));
            }
            oos.writeObject(objeto);
            retorno = 1; 
            oos.flush();            
        }  catch (IOException ioe){
            System.out.print("ERROR de E/S en la escritura " + ioe.getMessage());
            retorno = -1;
        } catch (Exception e){
            System.out.print("Se ha producido un error en la escritura " + e.getMessage());
            retorno = -1;
        }finally {
            if (oos!=null){
                try{
                    oos.close();
                } catch (IOException e){
                    System.out.println("No se puedo cerrar el stream en la escritura" + e.getMessage());
                }                
            }
        }
        return retorno;

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

	public int escribirEscenarioAPS(LinkedList<Escenario> listaObjetos) {
		
		  // uso de LinkedList
        ListIterator<Escenario> iteradorPel = listaObjetos.listIterator();
        Escenario p;
        int retorno = 0;
        
        // se recorre la lista
        while (iteradorPel.hasNext()) {
            p = iteradorPel.next();
            retorno = escribirEscenarioAPS(p);
        }
        if (retorno == 1){
            return listaObjetos.size();
        }
        else{
            return -1;
        }   
	}
	
	public int escribirUsuarioAPS(LinkedList<Usuario> listaObjetos) {
		
		  // uso de LinkedList
      ListIterator<Usuario> iteradorPel = listaObjetos.listIterator();
      Usuario p;
      int retorno = 0;
      
      // se recorre la lista
      while (iteradorPel.hasNext()) {
          p = iteradorPel.next();
          retorno = escribirUsuarioAPS(p);
      }
      if (retorno == 1){
          return listaObjetos.size();
      }
      else{
          return -1;
      }   
	}
}
