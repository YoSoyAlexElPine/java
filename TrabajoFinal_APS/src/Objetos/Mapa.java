package Objetos;

import java.util.Iterator;

public class Mapa {

	Escenario mapa[][] = new Escenario[10][10];
	
	Torre sauron = new Torre(100, 999999, 999999999, 0, true);

	public Mapa() {
		mapa[0][9] = sauron;
		
		mapa[5][4] = new Torre();
		mapa[6][1] = new Torre();
		mapa[2][6] = new Torre();
		mapa[1][5] = new Torre();
		mapa[4][2] = new Torre();
		
		mapa[2][4] = new Cueva();
		mapa[5][6] = new Cueva();
		mapa[6][1] = new Cueva();
		mapa[4][9] = new Cueva();
		mapa[7][0] = new Cueva();
		
		mapa[3][6] = new Templo();
		mapa[4][4] = new Templo();
		mapa[9][7] = new Templo();
		mapa[7][6] = new Templo();
		mapa[0][1] = new Templo();
		
		for (int i = 0; i < 5; i++) {
			Torre torre = new Torre();
			Cueva cueva = new Cueva();
			Templo templo = new Templo();
			
		}
	}

	public void dibujar() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
			}
			System.out.println();
		}
	}
}
