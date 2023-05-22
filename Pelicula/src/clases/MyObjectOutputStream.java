/**
 * Clase para sobrescribir la clase ObjectOutputStream
 * para evitar que se cree la cabecera que impida que
 * la información añadida sea leída
 * @author Gema García Menchero <estadosduque@gmail.com>
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
    //Sobrescribimos el método que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException {
        //no se hace nada
    }
    
    //constructores
    public MyObjectOutputStream () throws IOException {
        super ();
    }
    
    public MyObjectOutputStream (OutputStream out) throws IOException {
        super (out);
    }
}
