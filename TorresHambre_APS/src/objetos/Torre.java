package objetos;

import java.io.*;
import static funciones.Colores.*;
import funciones.EscritorAPS;
import funciones.FuncionesGenerales;
import funciones.LectorAPS;
import java.util.LinkedList;
import java.util.Objects;

public class Torre extends Escenario implements Dibujable, Serializable {

    private static final long serialVersionUID = 1L;
    public int torreId = 0;
    public String usuario,nombre;
    protected int numPlanta, oferta;
    protected boolean fortificada;

    /**
     * Contructor vacio de Torre que rellena automatiucamente sus campos
     *
     * @param user
     * @param nombre
     */
    public Torre(Usuario user, String nombre) {
        this.nombre = nombre;
        usuario = user.getNombre();
        torreId++;
        tamanio = 3f + numPlanta * 3.14f;
        poder = (int) (Math.random() * 1000);
        botin = (int) (Math.random() * 1000);
        numPlanta = (int) (Math.random() * 1000);
    }

    /**
     * Constructor de Torre completo
     *
     * @param user
     * @param numPlanta
     * @param poder
     * @param botin
     * @param oferta
     * @param string
     * @param string2
     * @param fortificado
     * @param b
     * @param hostilidad
     * @param nombre
     */
    public Torre(Usuario user, int numPlanta, int poder, int botin, int oferta, String string, String string2, boolean fortificado,
            boolean b, Hostilidad hostilidad, String nombre) {
        torreId++;
        usuario = user.getNombre();
        this.numPlanta = numPlanta;
        this.poder = poder;
        this.botin = botin;
        this.oferta = oferta;
        this.bloqueo = fortificado;
        this.nombre = nombre;
    }

    public static Torre generarTorre(Usuario user) throws IOException, InterruptedException {

        File fichero = new File("torres");
        LectorAPS lec = new LectorAPS(fichero);
        EscritorAPS es = new EscritorAPS(fichero);
        LinkedList<Torre> torres = new LinkedList<>();
        LectorAPS leerTorre = new LectorAPS(fichero);
        torres = leerTorre.leerLista();

        int numPlanta, botin, poder, oferta;
        boolean fortificado;
        Hostilidad hostilidad = null;
        String nombre;

        do {
            System.out.println("");
            System.out.println("=== Nombre de tu torre ===");
            nombre = FuncionesGenerales.brString("Nombre: ");
            System.out.println("");
            if (FuncionesGenerales.buscaLista(torres, nombre) != null) {
                System.out.println("");
                System.out.println("Este nombre ya esta cogido");
                System.out.println("Intenta otro nombre");
            }
        } while (FuncionesGenerales.buscaLista(torres, nombre) != null);

        numPlanta = (int) (Math.random() * 10);
        botin = (int) (Math.random() * 10000);
        oferta = (int) (Math.random() * 500);
        poder = (int) (Math.random() * 1000);
        int aux = (int) (Math.random());
        if (aux == 1) {
            fortificado = false;
        } else {
            fortificado = true;
        }

        int aux2 = (int) (Math.random() * 3);
        switch (aux2) {
            case 0 ->
                hostilidad = Hostilidad.AMISTOSA;
            case 1 ->
                hostilidad = Hostilidad.PASIVA;
            case 2 ->
                hostilidad = Hostilidad.HOSTIL;
            case 3 ->
                hostilidad = Hostilidad.HOSTIL;
        }// fin del switch
        Torre torre = new Torre(user, numPlanta, poder, botin, oferta, "Elfica", "Norte", fortificado, false, hostilidad, nombre);

        es.escribirAPS(torre, false);
        return torre;
    }// fin de la generacion de torre

    /**
     * Generacion de evento aleatorio funcional pero no implementado finalmente
     *
     */
    @Override
    public void generarEventoAleatorio() {
        int numero = (int) (Math.random() * 5);
        switch (numero) {
            case 1 -> {
                int numeroPisos = (int) (Math.random() * 5);
                System.out.println("Los duenios de la torre deciden mejorar su torre agregando " + numeroPisos + " mas.");
                numPlanta = numPlanta + numeroPisos;
            }
            case 2 -> {
                int cosecha = (int) (Math.random() * 500);
                System.out.println("En la utlima cosecha la torre a obtenido " + cosecha + " a su botin.");
                botin = botin + cosecha;
            }
            case 3 -> {
                int perdida = (int) (Math.random() * 300);
                System.out.println("Ocurre una crisis con costes de " + perdida + ".");
                if (botin - perdida < 0) {
                    botin = 0;
                } else {
                    botin = botin - perdida;

                }
            }
            case 4 -> {
                Hostilidad h = null;
                do {
                    int ruleta = (int) (Math.random() * 3);
                    switch (ruleta) {
                        case 0 ->
                            h = Hostilidad.HOSTIL;
                        case 1 ->
                            h = Hostilidad.PASIVA;
                        case 2 ->
                            h = Hostilidad.AMISTOSA;
                        case 3 ->
                            h = Hostilidad.AMISTOSA;
                    }
                } while (h == hostilidad);
                hostilidad = h;
                System.out.println("La torre ha decidido cambiar su hostilidad y ahora es " + hostilidad);

            }
            case 5 -> {
                int num = (int) (Math.random() * 2);
                oferta = oferta * num;
                System.out.println("Reoganizacion del mercado hace que la oferta ahora sea de " + oferta);
            }
        }
        System.out.println();
    }

    /**
     * toString Clasico
     */
    @Override
    public String toString() {

        System.out.println("Usuario = " + usuario);
        System.out.println("Nombre = " + nombre);
        System.out.println("Numero de plantas = " + numPlanta);
        System.out.println("poder = " + poder);
        System.out.println("botin = " + botin);
        System.out.println("oferta = " + oferta);
        System.out.println("fortificada = " + fortificada);
        System.out.println("hostilidad = " + hostilidad);
        System.out.println("=====================");
        System.out.println("");
        return " ";
    }

    /**
     * toString perosnalizado Void y mas amigable :)
     */
    @Override
    public void toStringVoid() {
        System.out.println("id = " + this.getCont());
        System.out.println("Numero de Plantas = " + numPlanta);
        System.out.println("Poder = " + poder);
        System.out.println("Botin = " + botin);
        System.out.println("Oferta = " + oferta);
        System.out.println("Fortificada = " + fortificada);
        System.out.println("Hostilidad = " + hostilidad);
    }

    /**
     * Metodo que saqueamos la torre sin necesitar fuerza y obteniendo solo su
     * botin y su enemistad
     *
     * @return
     */
    public int saquear() {
        int memoria = botin;
        System.out.println("Has saqueado la torre, ahora el botin " + botin + " te pertenece");
        System.out.println("");
        botin = 0;
        hostilidad = Hostilidad.HOSTIL;
        return memoria;
    }

    /**
     * metodo con el cual nos pertenece la torre si tenemos la suficiente fuerza
     *
     * @param fuerza
     * @return
     */
    @Override
    public boolean conquistar(int fuerza) {
        boolean resultadoBatalla;
        if (fuerza > poder) {
            System.out.println("Ahora la torre te pertenece");
            setHostilidad(Hostilidad.TUYA);
            resultadoBatalla = true;
        } else {
            System.out.println("No has logrado conquistar la torre y lo has perdido todo.");
            resultadoBatalla = false;
        }
        System.out.println("");
        return resultadoBatalla;
    }

    /**
     * Metodo comerciar con el cual podremos obtener dinero a cambio de cerdos
     *
     * @param mercancia
     * @param nombre
     * @return
     * @throws NumberFormatException
     * @throws IOException
     * @throws InterruptedException
     */
    /**
     * Metodo que dibuja la torre por pantalla
     */
    @Override
    public void dibujar() {
        if (explorado == true) {
            Hostilidad valor = this.getHostilidad();
            switch (valor) {
                case HOSTIL -> {
                    System.out.println(ANSI_RED + "    __ ");
                    System.out.println(ANSI_RED + "   |  ");
                    System.out.println(ANSI_RED + "   |");
                }
                case PASIVA -> {
                    System.out.println(ANSI_BLUE + "    __ ");
                    System.out.println(ANSI_BLUE + "   |  ");
                    System.out.println(ANSI_BLUE + "   |");
                }
                case AMISTOSA -> {
                    System.out.println(ANSI_GREEN + "    __ ");
                    System.out.println(ANSI_GREEN + "   |  ");
                    System.out.println(ANSI_GREEN + "   |");
                }
                case TUYA -> {
                    System.out.print("\u001B[0m");
                    System.out.println("    __ ");
                    System.out.println("   |  ");
                    System.out.println("   |");
                }
            }
            System.out.print("\u001B[0m");
            System.out.println("  /^\\");
            System.out.println("  |#|");
            System.out.println(" |===|");
            System.out.println("  |0|");
            for (int i = 0; i < numPlanta; i++) {

                System.out.println("  | |");

            }
            System.out.println("""
					 =====
					_||_||_
					""");
        } else {
            System.out.println("Esta torre aun es desconocida para ti");
        }

    }

    /**
     * Getters y Setters:
     *
     * @return
     */
    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public int getPoder() {
        return poder;
    }

    public int getNuPlanta() {
        return numPlanta;
    }

    public void setNuPlanta(int nuPlanta) {
        this.numPlanta = nuPlanta;
    }

    public boolean isFortificada() {
        return fortificada;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setFortificada(boolean fortificada) {
        this.fortificada = fortificada;
    }

    public int getBotin() {
        return botin;
    }

    public void setBotin(int botin) {
        this.botin = botin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void menuOpciones() {
        // TODO Auto-generated method stub

    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        return hash;
    }
}
