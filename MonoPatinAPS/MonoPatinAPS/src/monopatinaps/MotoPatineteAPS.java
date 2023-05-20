package monopatinaps;

import java.util.ArrayList;
import java.util.Scanner;
import monopatinaps.clasesAPS.Cilindrada;
import monopatinaps.clasesAPS.MotoAPS;
import monopatinaps.clasesAPS.PatineteAPS;
import monopatinaps.clasesAPS.Transporte;

public class MotoPatineteAPS {

	public static void main(String[] args) {

		// Variables

		MotoAPS[] arrMoto = new MotoAPS[3];
		PatineteAPS[] arrPatin = new PatineteAPS[2];
		ArrayList<MotoAPS> array;

		// Creacion de objetos

		MotoAPS moto1 = new MotoAPS();
		MotoAPS moto2 = new MotoAPS(true, Cilindrada.CC1000);
		MotoAPS moto3 = new MotoAPS(true, Cilindrada.CC500, "2486-PSA", "Es diesel");

		PatineteAPS pt1 = new PatineteAPS(100, 50);
		PatineteAPS pt2 = new PatineteAPS(250);

		// Asignacion de datos a matrices

		arrMoto[0] = moto1;
		arrMoto[1] = moto2;
		arrMoto[2] = moto3;

		arrPatin[0] = pt1;
		arrPatin[1] = pt2;

		// Mostrar por pantalla datos

		System.out.println("--------------- Listado motos: ---------------");
		System.out.println();

		for (int i = 0; i < arrMoto.length; i++) {
			arrMoto[i].datos();
		}
		System.out.println("--------------- Listado patinetes: --------------- ");
		System.out.println();

		for (int i = 0; i < arrPatin.length; i++) {
			arrPatin[i].datos();
		}
	}

}
