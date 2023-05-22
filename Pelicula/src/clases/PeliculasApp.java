/**
 * Aplicación Java para gestionar las películas de un videoclub, por ejemplo.
 * Los datos, se almacenarán en un fichero serializado.
 * 
 * @author Gema García Menchero <estadosduque@gmail.com>
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class PeliculasApp {

    public static void main(String[] args) throws Exception{ 
        String fich, titulo, director;        
        String respuesta; // variable para saber si continuar o no introduciendo datos
        boolean continuar; //de películas en un LinkedList
        int numPel = 0; // variable para almacenar el número de películas añadidas
        // variables para manejar los distintos objetos necesarios
        Pelicula pelicula; 
        EscritorObjetos escritor;
        LectorObjetos lector;
        // variables para arrays dinámicos
        LinkedList<Pelicula> listaPeliculas;
        ListIterator<Pelicula> iteradorPel;
                
        // buffer para leer datos desde el teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\t***********Introduce el nombre del fichero: ");
        // el nombre del fichero que introduciremos 
        fich = br.readLine();
        
        buscar();
        
        // se crean los objetos escritor y lector pasándoles el nombre del fichero a utilizar
        escritor = new EscritorObjetos (new File (fich));
        lector = new LectorObjetos (new File (fich));
        
        try {
            // se añaden 3 películas  
            System.out.println("\t***********Creando y Escribiendo películas en el fichero... " + fich);
            pelicula = new Pelicula("Joker", "Todd Phillips");            
            /* llamamos al método escribir de la clase EscritorObjetos,
            encargado de añadir el objeto al fichero*/
            escritor.escribe(pelicula);
            pelicula = new Pelicula("Avatar", "James Cameron");           
            escritor.escribe(pelicula);
            pelicula = new Pelicula("Batman", "Matt Reeves");            
            escritor.escribe(pelicula);
            // muestra las películas guardadas
            System.out.println("\t***********Leyendo películas del fichero... " + fich);
            lector.verContenido();
                    
            /* insertar en el fichero una colección de datos almacenados en una LinkedList*/
            listaPeliculas = new LinkedList<>();
            System.out.println("\t***********Vas a crear una lista de películas...");
            System.out.println("\t***********¿Quieres introducir una película? (S/N)...");
            respuesta = br.readLine().toUpperCase();                        
            continuar = respuesta.equals("S");
            
            while (continuar){
                pelicula = new Pelicula();
                System.out.println("\t********** Introduce el título de la película...");
                titulo = br.readLine();
                System.out.println("\t********** Introduce el director de la película...");
                director = br.readLine();
                // asigna los valores leídos por teclado al objeto
                pelicula.setTitulo(titulo);
                pelicula.setDirector(director);
                
                //se añade la pelicula en una lista dinámica 
                listaPeliculas.add(pelicula);
                
                // añade el objeto al fichero
                //escritor.escribe(pelicula);                
                               
                System.out.println("\t***********¿Quieres introducir otra película? (S/N)...");
                respuesta = br.readLine().toUpperCase();                        
                continuar = respuesta.equals("S");
            }
            numPel = escritor.escribe(listaPeliculas); 
            if (numPel != -1){
                System.out.println("\t***********SE HAN AÑADIDO " + numPel + " PELÍCULAS AL FICHERO");
            } else {
                System.out.println("\t***********NO SE HA AÑADIDO NINGUNA PELÍCULA");
            }
            
            //listar todos las películas se llama al método verContenido del objeto lector
            System.out.println("\t***********************************************");
            System.out.println("\t***********EL LISTADO DE PELÍCULAS ES***********");
            System.out.println("\t***********************************************"); 
            lector.verContenido();                                                                                             
                        
                                       
        }//fin try
        catch (IOException e){
           System.out.println("\t***********Se ha producido un error al ejecutar la aplicación " + e.getMessage());            
        }
    }//fin de main    
     
    public static void buscar() throws InterruptedException {
    	
    	File fichero=new File("cagarruta");
    	LectorObjetos lec=new LectorObjetos(fichero);
    	
    	System.out.println("Pollon duro "+lec.busca("bocadillo").getDirector());
    	Thread.sleep(5000);
    }
    
    
}//fin PeliculasApp
