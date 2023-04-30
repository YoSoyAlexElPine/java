
package proyectojv.jrm.ap;

/**
 *
 * @author b03-10t
 */
public class CasaEncantada extends Escenario{
    protected String tipoEspiritu;

    public CasaEncantada() {
    }
    
    
    public CasaEncantada(float tamanio, String nZona, boolean bloqueo, Hostilidad hostilidad,String tipoEspiritu ) {
        super(tamanio, nZona, bloqueo, hostilidad);
        this.tipoEspiritu = tipoEspiritu;
    }

    public String getTipoEspiritu() {
        return tipoEspiritu;
    }

    public void setTipoEspiritu(String tipoEspiritu) {
        this.tipoEspiritu = tipoEspiritu;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCasaEncantada" + "\ntipoEspiritu:" + tipoEspiritu;
    }
    @Override
    public int generarEventoAleatorio(){
        return 1;
    };
    protected String casaEncantada(){return " ";};
    
    
}
