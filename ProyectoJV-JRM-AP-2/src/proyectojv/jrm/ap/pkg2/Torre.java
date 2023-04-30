package proyectojv.jrm.ap.pkg2;

import java.util.Scanner;
import static proyectojv.jrm.ap.pkg2.Colores.ANSI_BLUE;
import static proyectojv.jrm.ap.Colores.ANSI_GREEN;
import static proyectojv.jrm.ap.Colores.ANSI_RED;

/**
 *
 * @author b03-10t
 */
public class Torre extends Escenario implements Dibujable {

    protected int nuPlanta, poder, botin,oferta;
    protected String tipoEdificacion;
    protected boolean fortificada, pertenece;

    public Torre() {
    }

    public Torre(int nuPlanta, boolean fortificada, int botin) {
        this.nuPlanta = nuPlanta;
        this.fortificada = fortificada;
        this.botin = botin;
    }

    public Torre(int nuPlanta, String tipoEdificacion, boolean fortificada, int botin) {
        this.nuPlanta = nuPlanta;
        this.tipoEdificacion = tipoEdificacion;
        this.fortificada = fortificada;
        this.botin = botin;
    }

    public Torre(int nuPlanta, String tipoEdificacion, boolean fortificada, int botin, Hostilidad hostilidad, int poder, boolean pertenece) {
        this.nuPlanta = nuPlanta;
        this.tipoEdificacion = tipoEdificacion;
        this.fortificada = fortificada;
        this.botin = botin;
        this.hostilidad = hostilidad;
        this.poder = poder;
        this.pertenece = pertenece;
    }

    public Torre(int nuPlanta, int poder, int botin,int oferta, String tipoEdificacion, boolean fortificada, boolean pertenece, Hostilidad hostilidad) {
        this.nuPlanta = nuPlanta;
        this.botin = botin;
        this.tipoEdificacion = tipoEdificacion;
        this.fortificada = fortificada;
        this.pertenece = pertenece;
        this.poder = poder;
        this.oferta=oferta;
        this.hostilidad = hostilidad;
    }

    public int getPoder() {
        return poder;
    }

    public Hostilidad getHostilidad() {
        return hostilidad;
    }

    public int getNuPlanta() {
        return nuPlanta;
    }

    public void setNuPlanta(int nuPlanta) {
        this.nuPlanta = nuPlanta;
    }

    public String getTipoEdificacion() {
        return tipoEdificacion;
    }

    public void setTipoEdificacion(String tipoEdificacion) {
        this.tipoEdificacion = tipoEdificacion;
    }

    public boolean isFortificada() {
        return fortificada;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setPertenece(boolean pertenece) {
        this.pertenece = pertenece;
    }

    public boolean getPertenece() {
        return this.pertenece;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public void setnZona(String nZona) {
        this.nZona = nZona;
    }

    public void setExplorado(boolean explorado) {
        this.explorado = explorado;
    }

    public void setHostilidad(Hostilidad hostilidad) {
        this.hostilidad = hostilidad;
    }

    public boolean isPertenece() {
        return pertenece;
    }

    public float getTamanio() {
        return tamanio;
    }

    public String getnZona() {
        return nZona;
    }

    public boolean isExplorado() {
        return explorado;
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
    public int generarEventoAleatorio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Torre{" + "nuPlanta=" + nuPlanta + ", poder=" + poder + ", botin=" + botin + ", oferta=" + oferta + ", tipoEdificacion=" + tipoEdificacion + ", fortificada=" + fortificada + ", pertenece=" + pertenece + '}';
    }

    public int saquear() {
        int botin;
        botin = this.botin;
        this.botin = 0;
        return botin;
    }

    public boolean conquistar() {
        boolean aux = true;
        return aux;
    }

    public int comerciar(int cerdos, int oferta) {
        Scanner teclado = new Scanner(System.in);
        int opc = 0;
        return 0;
    }

    public void dibujar() {
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
        }
        System.out.println("  /^\\");
        System.out.println("  |#|");
        System.out.println(" |===|");
        System.out.println("  |0|");
        for (int i = 0; i < nuPlanta; i++) {

            System.out.println("  | |");

        }
        System.out.println("""
                            =====
                           _||_||_
                           """);
    }
}
