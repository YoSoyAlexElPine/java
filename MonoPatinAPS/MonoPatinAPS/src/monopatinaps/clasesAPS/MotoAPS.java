package monopatinaps.clasesAPS;

public class MotoAPS extends Transporte {

	boolean deportiva;
	Cilindrada cc;

	public MotoAPS(boolean deportiva, Cilindrada cc, int valoracion, int precio, String referencia, String descripcion, boolean electrico) {
		super(valoracion, precio, referencia, descripcion, electrico);
		this.deportiva = deportiva;
		this.cc = cc;
		cont++;
	}

	public MotoAPS(boolean deportiva, Cilindrada cc, String referencia, String descripcion) {
		super(referencia, descripcion);
		this.deportiva = deportiva;
		this.cc = cc;
		cont++;
	}

	public MotoAPS(boolean deportiva, Cilindrada cc) {
		this.deportiva = deportiva;
		this.cc = cc;
		cont++;
	}

	public MotoAPS() {
		cont++;
	}

	public void setDeportiva(boolean deportiva) {
		this.deportiva = deportiva;
	}

	public void setElectrico(boolean electrico) {
		this.electrico = electrico;
	}

	public Cilindrada getCc() {
		return cc;
	}

	public void setCc(Cilindrada cc) {
		this.cc = cc;
	}

	public boolean isDeportiva() {
		return deportiva;
	}

	public void imprimir() {
		System.out.println("Cuando tenga tiempo dibujo una moto");
	}

	/**
	 * Metodo el cual introducinos dos objetos tipo MotoAPS y nos devuele cual es
	 * mayor en funcion de la cilindrada asignando a cada cilindrada un dato tipo
	 * int y comparandolo despues
	 */

	public void mayorQue(MotoAPS a, MotoAPS b) {
		int tamanioa = 0, tamaniob = 0;
		
		Cilindrada[] cilindrada=new Cilindrada[5];
		
		cilindrada[0]=Cilindrada.CC50;
		cilindrada[1]=Cilindrada.CC125;
		cilindrada[2]=Cilindrada.CC250;
		cilindrada[3]=Cilindrada.CC500;
		cilindrada[4]=Cilindrada.CC1000;
		
		for (int i = 0; i < cilindrada.length; i++) {
			if (cilindrada[i]==a.getCc()) {
				tamanioa=i;
			}
			if (cilindrada[i]==b.getCc()) {
				tamaniob=i;
			}
		}
		
		if (tamanioa == tamaniob) {
			System.out.println("Ambas motos son de igual tamaño");
		}
		if (tamanioa > tamaniob) {
			System.out.println("Moto de referencia " + a.getReferencia() + " es mayor que la moto de referencia "
					+ b.getReferencia());
		} else {
			System.out.println("Moto de referencia " + b.getReferencia() + " es mayor que la moto de referencia "
					+ a.getReferencia());
		}

	}

}
