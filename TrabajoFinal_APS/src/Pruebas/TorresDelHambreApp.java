package Pruebas;

import java.io.IOException;

import Objetos.Personaje;
import funciones.*;

public class TorresDelHambreApp {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Variables
		int opc;

		titulo();
		do {
			Usuario.menu();
			opc = FuncionesGenerales.brInt();
			switch (opc) {
			case 1:
				if (Usuario.login()==true) {
					Thread.sleep(1000);
					FuncionesGenerales.seleccionPersonaje();
				}
				break;
			case 2:
				Usuario.registrar();
				break;
			case 0:

				break;
			default:
				break;
			}
		} while (opc !=0);
		despedida();
	}

	private static void titulo() {
		System.out.println(
				" _                    _______                                _      _      _                     _              ");
		System.out.println(
				"| |                  |__   __|                              | |    | |    | |                   | |             ");
		System.out.println(
				"| |     __ _ ___        | | ___  _ __ _ __ ___  ___       __| | ___| |    | |__   __ _ _ __ ___ | |__  _ __ ___ ");
		System.out.println(
				"| |    / _` / __|       | |/ _ \\| '__| '__/ _ \\/ __|     / _` |/ _ \\ |    | '_ \\ / _` | '_ ` _ \\| '_ \\| '__/ _ \\");
		System.out.println(
				"| |___| (_| \\__ \\       | | (_) | |  | | |  __/\\__ \\    | (_| |  __/ |    | | | | (_| | | | | | | |_) | | |  __/");
		System.out.println(
				"|______\\__,_|___/       |_|\\___/|_|  |_|  \\___||___/     \\__,_|\\___|_|    |_| |_|\\__,_|_| |_| |_|_.__/|_|  \\___|");

	}
	private static void despedida() {
		  System.out.println("              _ _           ");
	        System.out.println("     /\\      | (_)          ");
	        System.out.println("    /  \\   __| |_  ___  ___ ");
	        System.out.println("   / /\\ \\ / _` | |/ _ \\/ __|");
	        System.out.println("  / ____ \\ (_| | | (_) \\__ \\");
	        System.out.println(" /_/    \\_\\__,_|_|\\___/|___/");   
	    
	}
}
