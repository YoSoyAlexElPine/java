package clases;

import java.io.Serializable;

/**
 * Ejemplo de clase Serializable para poder guardar y recuperar
 * objetos de este tipo en ficheros
 * @author Gema García Menchero <estadosduque@gmail.com>
 */
public class Pelicula implements Serializable{
    private String titulo;
    private String director;
    
    //Constructores
    
    /**
     * Constructor vacío
     */
    public Pelicula() {
    }
    
    /**
     * Constructor con todos los datos
     * @param titulo de la película
     * @param director 
     */
    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }
    
    //getters y setters
    
    /**
     * Obtiene el atributo título
     * @return el título de la película
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Da valor al título 
     * @param titulo de la película
     */    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Obtiene el atributo director
     * @return el director de la película
     */
    public String getDirector() {
        return director;
    }
    
    /**
     * Da valor al director 
     * @param director de la película
     */ 
    public void setDirector(String director) {
        this.director = director;
    }
    
    /**
     * Método heredado de Object y sobreescrito,
     * que devuelve si una película es igual a otra,
     * comparando el título.
     * 
     * @param p película para comprobar si es igual
     * @return true si son iguales; false si son distintas
     */
    public boolean equals(Pelicula p){        
        boolean igual = false;
        if (p != null){
            igual=this.getTitulo().equals(p.getTitulo());            
        }
        return igual;
    }
    
    /**
     * Método heredado de Object y sobreescrito,
     * que muestra toda la información de una película
     * @return una cadena con todos los atributos de la película
     */
    @Override
    public String toString(){        
        String infoPeli = "\t********** Título de la Película: " + this.getTitulo() + "\n\t ********** Director: " + this.getDirector() + "\n";
        return infoPeli;
    }
    
}
