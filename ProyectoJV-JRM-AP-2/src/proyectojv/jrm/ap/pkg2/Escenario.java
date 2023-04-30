
package proyectojv.jrm.ap.pkg2;

public abstract class Escenario {
    private static int cont=0;
    protected int numeroZona=0;
    protected float tamanio;
    protected String nZona;
    protected boolean explorado;
    protected Hostilidad hostilidad;

    public Escenario() {
        cont++;
        this.numeroZona=cont;
    }

    public Escenario(float tamanio, String nZona, boolean explorado, Hostilidad hostilidad) {
        this.tamanio = tamanio;
        this.nZona = nZona;
        this.explorado = explorado;
        this.hostilidad = hostilidad;
        cont++;
        this.numeroZona=cont;
    }
    
    public Escenario(String nZona, boolean explorado, Hostilidad hostilidad) {
        this.nZona = nZona;
        this.explorado = explorado;
        this.hostilidad = hostilidad;
        cont++;
        this.numeroZona=cont;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public String getnZona() {
        return nZona;
    }

    public int getNumeroZona() {
        return numeroZona;
    }

    public void setNumeroZona(int numeroZona) {
        this.numeroZona = numeroZona;
    }
      
    public void setnZona(String nZona) {
        this.nZona = nZona;
    }

    public boolean isExplorado() {
        return explorado;
    }

    public void setExplorado(boolean explorado) {
        this.explorado = explorado;
    }

    
    
    public void setHostilidad(Hostilidad hostilidad) {
        this.hostilidad = hostilidad;
    }

    public int getCont() {
        return cont;
    }

    public Hostilidad getHostilidad() {
        return hostilidad;
    }
    
    abstract public int generarEventoAleatorio();
    
    @Override
    public String toString() {
        return  "\nNumeroZona:" + numeroZona + "\ntamanio:" + tamanio + "\nZona:" + nZona + "\nbloqueo:" + explorado + "\nhostilidad:" + hostilidad;
    }
    
    
}
