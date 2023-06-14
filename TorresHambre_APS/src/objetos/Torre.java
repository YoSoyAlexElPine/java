package objetos;

import java.io.*;

import funciones.FuncionesGenerales;

import static funciones.Colores.*;
import funciones.EscritorAPS;

public class Torre extends Escenario implements Dibujable, Serializable {

    private static final long serialVersionUID = 1L;
    public static int torreId = 0;
    public static String usuario;
    protected int numPlanta, oferta;
    protected boolean fortificada;

    /**
     * Contructor vacio de Torre que rellena automatiucamente sus campos
     *
     * @param user
     */
    public Torre(Usuario user) {
        usuario = user.getNombre();
        torreId++;
        tamanio = 3f + numPlanta * 3.14f;
        poder = (int) (Math.random() * 1000);
        botin = (int) (Math.random() * 1000);
        numPlanta = (int) (Math.random() * 1000);
    }

    /**
     * Contructor de torre Basico
     *
     * @param user
     * @param nuPlanta
     * @param poder
     * @param botin
     * @param oferta
     * @param fortificada
     */
    public Torre(Usuario user, int nuPlanta, int poder, int botin, int oferta, boolean fortificada) {
        super();
        usuario = user.getNombre();
        torreId++;
        this.numPlanta = nuPlanta;
        this.poder = poder;
        this.botin = botin;
        this.oferta = oferta;
        this.fortificada = fortificada;
    }

    /**
     * Contructor de torre mas simple
     *
     * @param user
     * @param nuPlanta
     * @param oferta
     * @param fortificada
     */
    public Torre(Usuario user, int nuPlanta, int oferta, boolean fortificada) {
        super();
        usuario = user.getNombre();
        torreId++;
        this.numPlanta = nuPlanta;
        this.oferta = oferta;
        this.fortificada = fortificada;
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
     */
    public Torre(Usuario user, int numPlanta, int poder, int botin, int oferta, String string, String string2, boolean fortificado,
            boolean b, Hostilidad hostilidad) {
        torreId++;
        usuario = user.getNombre();
        this.numPlanta = numPlanta;
        this.poder = poder;
        this.botin = botin;
        this.oferta = oferta;
        this.bloqueo = fortificado;
    }

    public static Torre generarTorre(Usuario user) {
        int numPlanta, botin, poder, oferta;
        usuario = user.getNombre();
        boolean fortificado;
        Hostilidad hostilidad = null;
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
        Torre torre = new Torre(user, numPlanta, poder, botin, oferta, "Elfica", "Norte", fortificado, false, hostilidad);
        EscritorAPS es = new EscritorAPS(new File("torres"));
        es.escribirAPS(torre,true);
        return torre;
    }// fin de la generacion de torre

    /**
     *
     * Creacion de torre personalizada
     *
     * @param user
     * @return
     * @throws InterruptedException
     * @throws java.io.IOException
     *
     */
    public static Torre crearTorre(Usuario user) throws NumberFormatException, IOException, InterruptedException {
        int numPlantas, botin, aux, aux2;
        usuario = user.getNombre();
        Hostilidad aux3 = null;
        boolean fort;

        numPlantas = FuncionesGenerales.brInt("Introducce numero de plantas: ");

        botin = FuncionesGenerales.brInt("Introdicce el botin que tendra tu torre: ");

        System.out.println("Esta fortificada? (0 = no, 1 = si) : ");

        aux = FuncionesGenerales.brInt();

        System.out.println("Como es su temperamento? (0 = amistoso | 1 = neutral | 2 = hostil | 3 = tuyo) : ");

        aux2 = FuncionesGenerales.brInt("Introducce numero de plantas: ");

        switch (aux2) {
            case 0 ->
                aux3 = Hostilidad.AMISTOSA;
            case 1 ->
                aux3 = Hostilidad.PASIVA;
            case 2 ->
                aux3 = Hostilidad.HOSTIL;
            case 3 ->
                aux3 = Hostilidad.TUYA;
        }

        if (aux == 0) {
            fort = false;
        } else {
            fort = true;
        }
        Torre torre = new Torre(user, numPlantas, 100, botin, 200, "Humana", "Oeste", fort, false, aux3);
        EscritorAPS es = new EscritorAPS(new File("torres"));
        es.escribirAPS(torre,true);
        return torre;
    }// fin clase

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
                System.out.println("Los dueños de la torre deciden mejorar su torre agregando " + numeroPisos + " más.");
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
        return "Usuario =" + usuario +"Numero de plantas=" + numPlanta + ", poder=" + poder + ", botin=" + botin + ", oferta=" + oferta
                + ", fortificada=" + fortificada + ", hostilidad=" + hostilidad + "]";
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
    public static int getTorreId() {
        return torreId;
    }

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

    @Override
    public void menuOpciones() {
        // TODO Auto-generated method stub

    }

    public static String getUsuario() {
        return usuario;
    }
}
