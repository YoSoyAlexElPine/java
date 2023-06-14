package funciones;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import objetos.Usuario;

public class EscritorAPS {

    //Atrivutos
    File fichero;

    /**
     * Contructor de EscritorAPS
     *
     * @param fichero
     */
    public EscritorAPS(File fichero) {
        super();
        this.fichero = fichero;
        fichero.setReadable(true);
    }

    /**
     * Funcion que escriba en el fichero un objeto de la clase pasado como
     * parámetro.Tiene que devolver 1 si la operación de escritura tiene éxito;
     * -1 si ocurre alguna excepción. Debe comprobar si el fichero existe o no.
     *
     * @param objeto
     * @param sobreescribir
     * @return 1 o -1
     */
    public int escribirAPS(Object objeto, boolean sobreescribir) {
        ObjectOutputStream oos = null;
        int valorDevuelto;
        try { if (!sobreescribir) {
                //Evita colocar la cabecera
                oos = new ObjectOutputStreamAPS(new FileOutputStream(fichero, true));
            } else {
                //Para agregar la cabecera si el fichero es primera vez que entra al archivo, se debe desactivar el concatenar
                oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
            }
            oos.writeObject(objeto);
            valorDevuelto = 1;
            oos.flush();
        } catch (IOException ioe) {
            System.out.print("ERROR de E/S en la escritura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e) {
            System.out.print("Se ha producido una EXCEPCIÓN en la escritura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("No se puedo cerrar el stream en la escritura" + e.getMessage());
                }
            }
        }
        return valorDevuelto;

    }

    /**
     * Funcion que escriba en el fichero un conjunto de objetos de la clase,
     * almacenados en una lista dinámica que se le pasará como parámetro.Tiene
     * que devolver el nº de objetos escritos si la operación de escritura tiene
     * éxito; -1 si ocurre alguna excepción.Debe comprobar si el fichero existe
     * o no.
     *
     * @param listaObjetos
     * @return
     */
    public int escribirAPS(LinkedList<Usuario> listaObjetos) {
        boolean sobreescribir;
        ListIterator<Usuario> iteradorUser = listaObjetos.listIterator();
        Usuario u;
        int valorDevuelto = 0;
        // se recorre la lista de usuarios pasada por parametro
        while (iteradorUser.hasNext()) {
            //Determinamos si es la primera vez que se entra al bucle para sobreescribir la lista anterior y agregar cabecera
            sobreescribir = !iteradorUser.hasPrevious();
            u = iteradorUser.next();
            valorDevuelto = EscritorAPS.this.escribirAPS(u, sobreescribir);
        }
        if (valorDevuelto == 1) {
            return listaObjetos.size();
        } else {
            return -1;
        }
    }

}
