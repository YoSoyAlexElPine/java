package funciones;

import java.io.*;

import java.util.LinkedList;
import objetos.Torre;
import objetos.Usuario;

public class LectorAPS {

    //Atributos de clse
    String nombreFichero;
    File fichero;

    /**
     * Constructor vacio pedira al usuario introducir el nombre del fichero que
     * quiera leer
     *
     * @throws IOException
     */
    public LectorAPS() throws IOException {

        nombreFichero = FuncionesGenerales.brString("Dime el nombre del fichero que quieras: ");
        System.out.println();
        fichero = new File(nombreFichero);

    }

    /**
     * Leer el fichero del nombre introducido
     *
     * @param nombreFichero
     */
    public LectorAPS(String nombreFichero) {
        this.nombreFichero = nombreFichero;
        fichero = new File(nombreFichero);
    }

    /**
     * Leera el fichero introducido
     *
     * @param fichero
     */
    public LectorAPS(File fichero) {
        this.fichero = fichero;
    }

    /**
     * Fucniones que lee todos los escenarios de y retorna -1 en caso fallido o
     * el numero de objetos leidos en caso exitoso
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int leerAPS() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        Object o;
        int v = 0;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
            o = (Usuario) ois.readObject();
            while (o != null) {
                v++;
                System.out.println("Datos del usuario " + (v));
                System.out.println(o.toString());
                o = (Usuario) ois.readObject();
            }
        } catch (EOFException eofe) {
            System.out.println("Hay un total de " + v + " objetos registrados");
        } catch (IOException ioe) {
            System.out.println("Error en la lectura" + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no ha sido encontrada" + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error en la lectura " + e.getMessage());
        }
        return v;
    }
    public int leer() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        Object o;
        int v = 0;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
            o = (Torre) ois.readObject();
            while (o != null) {
                v++;
                System.out.println("Datos del usuario " + (v));
                System.out.println(o.toString());
                o = (Torre) ois.readObject();
            }
        } catch (EOFException eofe) {
            System.out.println("Hay un total de " + v + " objetos registrados");
        } catch (IOException ioe) {
            System.out.println("Error en la lectura" + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no ha sido encontrada" + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error en la lectura " + e.getMessage());
        }
        return v;
    }

    /**
     * Funcion que lea del fichero todos los objetos de la clase y devuelva una
     * lista dinámica con todos ellos.Si el fichero estuviese vacío o se
     * produjese alguna excepción la lista estará vacía.Debe comprobar si el
     * fichero existe o no.
     *
     * @return
     */
   public LinkedList<Usuario> leerListaAPS() {
        LinkedList<Usuario> listaUsuario = new LinkedList<>();
        Usuario u;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
            //Se recorre el fichero hasta que se lean todos, cuando ya no haya salta la excepcion eofe y se muestra la cantidad de usuarios que se leyeron
            u = (Usuario) ois.readObject();
            while (u != null) {
                listaUsuario.add(u);
                u = (Usuario) ois.readObject();
            }//Fin del while 
        } catch (EOFException eofe) {
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción al recorrer el fichero: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        return listaUsuario;
    }
    public LinkedList<Torre> leerLista() {
        LinkedList<Torre> listaTorre = new LinkedList<>();
        Torre u;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
            //Se recorre el fichero hasta que se lean todos, cuando ya no haya salta la excepcion eofe y se muestra la cantidad de Torres que se leyeron
            u = (Torre) ois.readObject();
            while (u != null) {
                listaTorre.add(u);
                u = (Torre) ois.readObject();
            }//Fin del while 
        } catch (EOFException eofe) {
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción al recorrer el fichero: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        return listaTorre;
    }



    /**
     *
     * Funcion que busque y recupere el objeto cuyo valor coincida con el
     * indicado en el parámetro que le debes pasar, tú decides el parámetro por
     * el que buscar, pero ten en cuenta que debe tener sentido y debe ser
     * único.Devuelve el objeto de la clase si es que existe; null si no se
     * encontró o se produce alguna excepción.Debe comprobar si el fichero
     * existe o no.
     *
     * @param nombre
     * @return
     */
    public Usuario buscarAPS(String nombre) {        
        Usuario usuario = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero)); 
            usuario = (Usuario) ois.readObject();
            while (usuario != null && !encontrado) {
                if (usuario.getNombre().equals(nombre)) {
                        encontrado = true;
                } else {
                    usuario = (Usuario)ois.readObject();
                }  
            }//Fin del while 
            if (!encontrado){
                usuario = null;
            }
        } catch (EOFException eofe) {
            System.out.println("Se ha recorrido todo el fichero sin encontrar el usuario cuyo nombre es: " + nombre);
            usuario = null;   
        } catch (IOException ioe) {
            System.out.println("ERROR de E/S: " + ioe.getMessage());
            usuario = null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR al leer datos: " + ex.getMessage());
            usuario = null;
             } catch (ClassCastException ex) {
            System.out.println("ClassCastException");
            usuario = null;
        }finally{
            try{
                if (ois != null) {
                    ois.close();}
            }catch(IOException ioe){
                System.out.println("Error al cerrar el stream de lectura durante la búsqueda " + ioe.getMessage());
            } 
        }//Fin del  try
        return usuario;
    }

    /**
     * Funcion personalizada para realizar subconsultas sin imprimir nada por
     * pantalla
     *
     * @param nombre
     * @return
     */
    public Usuario buscar2APS(String nombre) {
        Usuario u = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichero));
            while (true) {
                u = (Usuario) ois.readObject();
                if (u.getNombre().equals(nombre)) {
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
            u = null;
        }
        return u;
    }

}
