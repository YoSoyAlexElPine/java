
package funciones;

import java.io.*;

/**
 *
 * @author Alex Pineño Sanchez
 */
public abstract class Escenario implements Serializable{
	private static final long serialVersionUID = 1L;
	protected static int cont=0;
    protected int botin,poder,beneficios;
    protected float tamanio;
    protected String nombre;
    protected boolean explorado,bloqueo;
    protected Hostilidad hostilidad;

    public Escenario() {
        cont++;
    }

    public Escenario(float tamanio, String nombre, boolean explorado, Hostilidad hostilidad) {
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.explorado = explorado;
        this.hostilidad = hostilidad;
        cont++;
    }
    
    public Escenario(String nombre, boolean explorado, Hostilidad hostilidad) {
        this.nombre = nombre;
        this.explorado = explorado;
        this.hostilidad = hostilidad;
        cont++;
    }
    
    public boolean conquistar(int fuerza) {
    	boolean auxiliar;
    	if (fuerza>poder) {
			botin=0;
			hostilidad=Hostilidad.TUYA;
			auxiliar=true;
			
		} else {
			hostilidad=Hostilidad.HOSTIL;
			auxiliar=false;
		}
    	return auxiliar;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public String getnombre() {
        return nombre;
    }
    
    public void setnombre(String nombre) {
        this.nombre = nombre;
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
    
    abstract public void generarEventoAleatorio();
    abstract public void menuOpciones();
    
    @Override
    public String toString(){
    	
    	String opcion = "";
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    	boolean explorado=false;
		if (explorado==false) {
			System.out.println("Esta construccion aun no la conoces.");
			do {
			
			System.out.println("¿Quieres explorarla? (S/N)");
				try {
					opcion=reader.readLine();
					opcion=opcion.toUpperCase();
				} catch (IOException e) {
				}

			} while (!opcion.equals("S") && !opcion.equals("N"));
			if (opcion=="S") {
				explorado=true;
			}
		} 
		if (explorado==true) {
			return  "tamanio:" + tamanio + "\nombre:" + nombre + "\nbloqueo:" + explorado + "\nhostilidad:" + hostilidad;
		}else {
			return "Construccion desconocida";
		}
        
    }

	public void toStringVoid() {
		// TODO Auto-generated method stub
		
	}
    
    
}
