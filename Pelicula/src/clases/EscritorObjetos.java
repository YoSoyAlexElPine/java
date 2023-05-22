/**
 * 
 * Clase que permite guardar un conjunto de objetos Película en un fichero
 * @author Gema <estadosduque@gmail.com>
 */
package clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;

public class EscritorObjetos {
    File fichEscritor;
    
    //Constructores
    
    public EscritorObjetos (){       
    }

    public EscritorObjetos(File fichEscritor) {
        this.fichEscritor = fichEscritor;
    }
    
    // get & set
    public File getFichEscritor() {
        return fichEscritor;
    }

    public void setFichEscritor(File fichEscritor) {    
        this.fichEscritor = fichEscritor;
    }

    /**
     * Método que escribe un objeto Película en un fichero
     * @param p objeto Pelicula a escribir en el fichero
     * @return 1 si se ha podido escribir; -1 si no ha podido escribir
     */
    public int escribe(Pelicula p) {
        ObjectOutputStream oos = null;
        int valorDevuelto;
        try {
            if (fichEscritor.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(fichEscritor,true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fichEscritor,true));
            }
            oos.writeObject(p);
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
    /**
     * Escribe en el fichero un conjunto de objetos de la clase Pelicula, 
     * almacenados en un array
     * @param lista array dinámico de Peliculas a guardar en el fichero
     * @return el número de peliculas escritas si todo ha ido bien; -1 en caso de error
     */
    public int escribe(LinkedList<Pelicula> lista){
        // uso de LinkedList
        ListIterator<Pelicula> iteradorPel = lista.listIterator();
        Pelicula p;
        int valorDevuelto = 0;
        
        // se recorre la lista
        while (iteradorPel.hasNext()) {
            p = iteradorPel.next();
            valorDevuelto = escribe(p);
        }
        if (valorDevuelto == 1){
            return lista.size();
        }
        else{
            return -1;
        }        
    }
}
