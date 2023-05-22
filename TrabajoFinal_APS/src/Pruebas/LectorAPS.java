package Pruebas;

import java.io.*;



import java.util.LinkedList;
import java.util.List;

import Objetos.Escenario;
import funciones.*;

public class LectorAPS {

	String nombreFichero;
	File fichero;

	public LectorAPS() throws IOException {
		
		nombreFichero = FuncionesGenerales.brString("Dime el nombre del fichero que quieras: ");
		System.out.println();
		fichero = new File(nombreFichero);
		
	}

	public LectorAPS(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		fichero = new File(nombreFichero);
	}
	public LectorAPS(File fichero) {
        this.fichero = fichero;
    }

	public int leerEscenarioAPS() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        int valorDevuelto = 0;
        Escenario p;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero)); 
            p = (Escenario) ois.readObject();
            while (p != null){   
                valorDevuelto++;
                System.out.println("\t          Escenario " + (valorDevuelto));
                System.out.println(p.toString());
                p = (Escenario) ois.readObject();                
            }            
        }catch (EOFException eofe){           
            System.out.println("\t--------------------------------------------------------------------"); 
            System.out.println("\t-SE HAN LISTADO TODOS LOS DATOS DEL FICHERO. EN TOTAL: " + valorDevuelto + " OBJETOS-");
            System.out.println("\t--------------------------------------------------------------------");                    
        } catch (IOException ioe){
            System.out.println("\t-----------ERROR de E/S en la lectura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (ClassNotFoundException cnfe){
            System.out.print("\t-----------La clase no se ha encontrado " + cnfe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e){
            System.out.print("\t-----------Se ha producido una EXCEPCIÓN en la lectura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
            if (ois!=null){
                try{
                    ois.close();
                } catch (IOException e){
                    System.out.println("\t-----------No se puedo cerrar el stream en la lectura " + e.getMessage());
                }                
            }
        }       
        return valorDevuelto;

		}
	
	
	
	
	
	public int leerUsuarioAPS() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        int valorDevuelto = 0;
        Usuario p;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero)); 
            p = (Usuario) ois.readObject();
            while (p != null){   
                valorDevuelto++;
                System.out.println("\t          Usuario " + (valorDevuelto));
                p.toStringVoid();
                p = (Usuario) ois.readObject();                
            }            
        }catch (EOFException eofe){           
            System.out.println("\t--------------------------------------------------------------------"); 
            System.out.println("\t-SE HAN LISTADO TODOS LOS DATOS DEL FICHERO. EN TOTAL: " + valorDevuelto + " OBJETOS-");
            System.out.println("\t--------------------------------------------------------------------");                    
        } catch (IOException ioe){
            System.out.println("\t-----------ERROR de E/S en la lectura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (ClassNotFoundException cnfe){
            System.out.print("\t-----------La clase no se ha encontrado " + cnfe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e){
            System.out.print("\t-----------Se ha producido una EXCEPCIÓN en la lectura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
            if (ois!=null){
                try{
                    ois.close();
                } catch (IOException e){
                    System.out.println("\t-----------No se puedo cerrar el stream en la lectura " + e.getMessage());
                }                
            }
        }       
        return valorDevuelto;

		}
	

	

	/**
	 * Funcion que lea del fichero todos los objetos de la clase y devuelva una
	 * lista dinámica con todos ellos. Si el fichero estuviese vacío o se produjese
	 * alguna excepción la lista estará vacía. Debe comprobar si el fichero existe o
	 * no.
	 * 
	 */

	public List<Escenario> leerListaEscenarioAPS() throws IOException, ClassNotFoundException {

        LinkedList<Escenario> listaEscenarios = new LinkedList<>();
        Escenario p;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(fichero));
            //Mientras haya Películas en el fichero se ejecuta el while
            //Cuando salte la excepcion de EOF sale del bucle
            p = (Escenario)ois.readObject();
            while (p != null) {
                listaEscenarios.add(p);
                p = (Escenario)ois.readObject();
            }//Fin del while 
        } catch(EOFException eofe){
            System.out.println("EOF. Se ha guardado todo el fichero en la lista");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción al recorrer el fichero: " + e.getMessage());
        }finally{
            try{
                if (ois != null) {
                    ois.close();
                }
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            } 
        }//Fin try
        return listaEscenarios;
    
	}
	
	
	
	public LinkedList<Usuario> leerListaUsuarioAPS() throws IOException, ClassNotFoundException {

        LinkedList<Usuario> listaUsuarios = new LinkedList<>();
        Usuario p;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(fichero));
            //Mientras haya Películas en el fichero se ejecuta el while
            //Cuando salte la excepcion de EOF sale del bucle
            p = (Usuario)ois.readObject();
            while (p != null) {
                listaUsuarios.add(p);
                p = (Usuario)ois.readObject();
            }//Fin del while 
        } catch(EOFException eofe){
            System.out.println("EOF. Se ha guardado todo el fichero en la lista");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción al recorrer el fichero: " + e.getMessage());
        }finally{
            try{
                if (ois != null) {
                    ois.close();
                }
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            } 
        }//Fin try
        return listaUsuarios;
    
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

	public Escenario buscarEscenarioAPS(int cont) {
		Escenario p = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero)); 
            p = (Escenario) ois.readObject();
            while (p != null && !encontrado) {
                if (p.getCont()==cont) {
                        encontrado = true;
                } else {
                    p = (Escenario)ois.readObject();
                }  
            }//Fin del while 
            if (!encontrado){
                p = null;
            }
        } catch (EOFException eofe) {
            System.out.println("Se ha recorrido todo el fichero sin encontrar el escenario cuyo ID es: " + cont);
            p = null;   
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
            p = null;
        } catch (Exception ex) {
            System.out.println("ERROR al leer datos: " + ex.getMessage());
            p = null;
        }finally{
            try{
                if (ois != null) {
                    ois.close();}
            }catch(IOException ioe){
                System.out.println("Error al cerrar el stream de lectura durante la búsqueda " + ioe.getMessage());
            } 
        }//Fin del  try
        return p;
	}
	
	
	public Usuario buscarUsuarioAPS(String nombre) {
	    Usuario p = null;
	    boolean encontrado = false;
	    ObjectInputStream ois = null;
	    try {
	        ois = new ObjectInputStream(new FileInputStream(fichero));
	        while (true) {
	            p = (Usuario) ois.readObject();
	            if (p.getNombre().equals(nombre)) {
	                encontrado = true;
	                break;
	            }
	        }
	    } catch (EOFException eofe) {
	        System.out.println("Se ha recorrido todo el fichero sin encontrar al usuario con el nombre: " + nombre);
	    } catch (IOException ioe) {
	        System.out.println("ERROR de E/S: " + ioe.getMessage());
	    } catch (ClassNotFoundException cnfe) {
	        System.out.println("ERROR al leer el objeto Usuario: " + cnfe.getMessage());
	    } finally {
	        try {
	            if (ois != null) {
	                ois.close();
	            }
	        } catch (IOException ioe) {
	            System.out.println("Error al cerrar el stream de lectura: " + ioe.getMessage());
	        }
	    }
	    if (!encontrado) {
	        p = null;
	    }
	    return p;
	}
	
	
	/**
	 * 
	 * Misma funcion que la anterior pero sin escribir nada por conola
	 * 
	 * */
	
	public Usuario buscarUsuario2APS(String nombre) {
	    Usuario p = null;
	    boolean encontrado = false;
	    ObjectInputStream ois = null;
	    try {
	        ois = new ObjectInputStream(new FileInputStream(fichero));
	        while (true) {
	            p = (Usuario) ois.readObject();
	            if (p.getNombre().equals(nombre)) {
	                encontrado = true;
	                break;
	            }
	        }
	    } catch (EOFException eofe) {
	        //System.out.println("Se ha recorrido todo el fichero sin encontrar al usuario con el nombre: " + nombre);
	    } catch (IOException ioe) {
	        System.out.println("ERROR de E/S: " + ioe.getMessage());
	    } catch (ClassNotFoundException cnfe) {
	        System.out.println("ERROR al leer el objeto Usuario: " + cnfe.getMessage());
	    } finally {
	        try {
	            if (ois != null) {
	                ois.close();
	            }
	        } catch (IOException ioe) {
	            System.out.println("Error al cerrar el stream de lectura: " + ioe.getMessage());
	        }
	    }
	    if (!encontrado) {
	        p = null;
	    }
	    return p;
	}

	
	
}
