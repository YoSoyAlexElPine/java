/**
kkkk * Clase que permite recuperar un conjunto de objetos Pelicula almacenadas en un fichero
 * @author Gema <estadosduque@gmail.com>
 * 
 */
package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
//import java.util.LinkedList;

public class LectorObjetos {
   File fichLector;
    
    //Constructores    
    public LectorObjetos (){       
    }

    public LectorObjetos(File fichLector) {
        this.fichLector = fichLector;
    }
    
    // get & set
    public File getFichLector() {
        return fichLector;
    }
   
    public void setFichLector(File fichLector) {    
        this.fichLector = fichLector;
    }

    /**
     * Método que recorre un fichero y lista todas los Películas almacenadas en él
     * @return nº de películas leídas si se ha podido leer; -1 si no ha podido leer
     */
    public int verContenido()  {
        ObjectInputStream ois = null;
        int valorDevuelto = 0;
        Pelicula p;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector)); 
            p = (Pelicula) ois.readObject();
            while (p != null){   
                valorDevuelto++;
                System.out.println("\t***********PELÍCULA " + (valorDevuelto));
                System.out.println(p.toString());
                p = (Pelicula) ois.readObject();                
            }            
        }catch (EOFException eofe){           
            System.out.println("\t********************************************************************"); 
            System.out.println("\t*SE HAN LISTADO TODOS LOS DATOS DEL FICHERO. EN TOTAL: " + valorDevuelto + " PELÍCULAS*");
            System.out.println("\t********************************************************************");                    
        } catch (IOException ioe){
            System.out.println("\t***********ERROR de E/S en la lectura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (ClassNotFoundException cnfe){
            System.out.print("\t***********La clase no se ha encontrado " + cnfe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e){
            System.out.print("\t***********Se ha producido una EXCEPCIÓN en la lectura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
            if (ois!=null){
                try{
                    ois.close();
                } catch (IOException e){
                    System.out.println("\t***********No se puedo cerrar el stream en la lectura " + e.getMessage());
                }                
            }
        }       
        return valorDevuelto;
    }
    
     /**
     * Método que lee de un fichero todos los objetos de la clase Película y 
     * busca el que coincida con el título que se pasa por parámetro, 
     * cuando lo encuentra escribe su información en consola
     * @param titulo de la Película a buscar
     * @return el objeto Película si se ha encontrado; null si no se ha encontrado 
     */
    public Pelicula busca(String titulo){        
        Pelicula p = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector)); 
            p = (Pelicula) ois.readObject();
            while (p != null && !encontrado) {
                if (p.getTitulo().equals(titulo)) {
                        encontrado = true;
                } else {
                    p = (Pelicula)ois.readObject();
                }  
            }//Fin del while 
            if (!encontrado){
                p = null;
            }
        } catch (EOFException eofe) {
            System.out.println("Se ha recorrido todo el fichero sin encontrar la película cuyo nombre es: " + titulo);
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
    }//Fin de busca
    
    /**
     * Método que lee de un fichero todos los objetos de la clase Película
     * y los almacena en una lista dinámica
     * @return LinkedList con todos las Películas
     */
    public LinkedList<Pelicula> lee(){
        LinkedList<Pelicula> listaPeliculas = new LinkedList<>();
        Pelicula p;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            //Mientras haya Películas en el fichero se ejecuta el while
            //Cuando salte la excepcion de EOF sale del bucle
            p = (Pelicula)ois.readObject();
            while (p != null) {
                listaPeliculas.add(p);
                p = (Pelicula)ois.readObject();
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
        return listaPeliculas;
    }//Fin de lee*/
}
