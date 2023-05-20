package sdfadf;

import java.io.Serializable;

public class Torre extends Escenario implements Serializable {
	
	@Override
	public String toString() {
		return "Torre [numPlanta=" + numPlanta + ", oferta=" + oferta + ", fortificada=" + fortificada + "]";
	}

	protected int numPlanta,oferta;
    protected boolean fortificada;
    
    public Torre() {
    	tamanio=3f+numPlanta*3.14f;
    	poder=(int)(Math.random()*1000);
    	botin=(int)(Math.random()*1000);
    	oferta=(int)(Math.random()*1000);
    	numPlanta=(int)(Math.random()*1000);
    }

	public int getNumPlanta() {
		return numPlanta;
	}

	public void setNumPlanta(int numPlanta) {
		this.numPlanta = numPlanta;
	}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	public boolean isFortificada() {
		return fortificada;
	}

	public void setFortificada(boolean fortificada) {
		this.fortificada = fortificada;
	}

}
