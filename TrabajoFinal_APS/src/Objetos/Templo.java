
package Objetos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


/**
 *
 * @author b03-10t
 */
public class Templo extends Escenario {
	public static final String descripcion="""
			Los templos aqui son lugar abandonados con grandes reservas de oro pero habitado por un Dusknoir.
			Los Dusknoir son especies pasivas que no salen de su habitad, tranquilas pero muy curiosas y con gran cultura.
			Su especie habito la tierra antes que nosotros, sus padres, mientras ellos vivian tranquilamente en su casa sin salir, y tan solo leyendo libros.
			Tienen un comportamiento como de niños, jugetones, perezosos y curiosos en especial le gustan las peliculas y las preguntas absurdas que recuerda del colegio.
			Existen dos maneras de combartilos; usando la fuerza o la inteligencia.
			Un Dusknoir esta obsesionado por la cultura, por eso, si sabes responder a 3 de sus preguntas puedes ganarte su confiaza y aprovechar para robarle, aunque sea un poco cruel.
			
			Eso si, los Dusknoir son muy exigentes con las respuestas y aqui te doy unas normas para no enfadarle:
			-Ellos no conoces las tildes
			-Solo aceptan preguntas de una sola palabra
			-Los numeros no se escirben con letras (cinco) sino con numeros (5)
			
			Buena suerte
			""";

	protected String preguntas[][] = new String[2][100];

	public Templo() {
		
		nombre="Templo de oro";
		tamanio=20;
		hostilidad=Hostilidad.PASIVA;
		poder=(int)(Math.random()+100*1000);
		explorado=false;
		bloqueo=false;
		beneficios=0;
		botin=(int)(Math.random()+100*50);
		preguntas=generarPreguntas();
		
	}

	public Templo(float tamanio, String nombre, boolean bloqueo, Hostilidad hostilidad) {
		super(tamanio, nombre, bloqueo, hostilidad);
		System.out.println(preguntas[0][9]);
	}

	public void preguntar() throws IOException, InterruptedException {
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean auxiliar;
		int aciertos=0,pregunta;
		String respuesta;
		
		System.out.println("""
				-------------------------------------------------------------------
				-                      Informacion                                -
				-------------------------------------------------------------------
				- Vas ha hacer 5 preguntas.                                       -
				- Necesitas responder bien a 3 preguntas, empezemos.              -
				-------------------------------------------------------------------
				""");
		
		for (int i = 0; i < 5; i++) {
			pregunta=(int)(Math.random()*preguntas[0].length);
			
			System.out.println((i+1)+". "+preguntas[0][pregunta]);
			respuesta=reader.readLine();
			if (respuesta.toUpperCase().equals(preguntas[1][pregunta].toUpperCase())) {
				aciertos++;
				System.out.println("Correcto");
			} else {
				System.out.println("Mal, muy mal");
				System.out.println("La respuesta correcta era "+preguntas[1][pregunta]);
				
			}
			Thread.sleep(1000);
			if (i!=4) {
				System.out.println("Siguiente pregunta");
			}
		}
		
		switch (aciertos) {
		case 0:
			System.out.println("Lo has fallado todo ¡VETE!");
			break;
		case 1:
			System.out.println("JAJA Solo una acertaste casi tan tonto como un niño.");
			break;
		case 2:
			System.out.println("Has estado cerca pero eso no quita lo ignorante que eres.");
			break;
		case 3: 
			System.out.println("Bueno, por los pelos, asi que no queda otra que seguir aprendiendo.");
			break;
		case 4:
			System.out.println("Casi lo haces perfecto en serio enorabuena.");
			break;
		case 5:
			System.out.println("!Lo has hecho perfecto! Gracias por venir y espero que podamos hablar en un futuro y poder ser amigos.");
			break;
		default:
			break;
		}
		Thread.sleep(1000);
		if (aciertos>=3) {
			hostilidad=Hostilidad.PASIVA;
		}
		if (aciertos>=5) {
			hostilidad=Hostilidad.AMISTOSA;
		}
		
	}

	@Override
	public String toString() {
		return "Templo [botin=" + botin + ", poder=" + poder + ", beneficios=" + beneficios + ", tamanio=" + tamanio
				+ ", nombre=" + nombre + ", explorado=" + explorado + ", bloqueo=" + bloqueo + ", hostilidad="
				+ hostilidad + "]";
	}

	@Override
	public void generarEventoAleatorio() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
	public void hablar() {
		int aleatorio=(int)(Math.random()*5);
		int aleatorioEnciclopedia=(int)(Math.random()+100*69);
		
		if (hostilidad==Hostilidad.AMISTOSA) {
		switch (aleatorio) {
		case 0:
			System.out.println("Estaba dormido echanodme la sisesta pero ahora estoy a tope XD");
			break;
		case 1:
			System.out.println("Silencio, ha entrado una mariposa y tengo que cazarla :O");
			break;
		case 2:
			System.out.println("Me pregunto si Michael Jackson segira vivo XO");
			break;
		case 3:
			System.out.println("Dime que has traido mi refresco favorito la Mirinda, me recuerda tanto a mi infancia...");
			break;
		case 4:
			System.out.println("Que alegria verte de nuevo y que te acuerdes de tu viejo amigo, no tan viejo pero si amigo. :P");
			break;
		case 5:
			System.out.println("Hoy hacer excatamente 100 años de que pasase un siglo. :D");
			break;

		default:
			System.out.println("Ahora mismo estoy leyendo mi enciclopedia numero "+ aleatorioEnciclopedia);
			System.out.println("La mejor de todas las 9999 restantes sin duda.");
			break;
		}
		} else {
			System.out.println("Me temo de que aun no teneis la suficiente confianza");
			System.out.println("Quiza si respondes a sus preguntas hos haceis amigos");
		}
		
	}
	
	@Override
	public void menuOpciones() {
		System.out.println("""
				----------------------------------
				-		 Templo opciones         -
				----------------------------------
				- 1. Investigar                  -
				- 2. Consquistar                 -
				- 3. Juego preguntas             -
				- 4. Preguntarle que tal         -
				- 5. Informacion                 -
				----------------------------------
				- 0. Salir                       -
				----------------------------------
				""");
		
		
		
	}
	public String getNombre() {
		return nombre;
	}


	public String[][] generarPreguntas() {
		
		String preguntas[][]=new String[2][100];
		
		preguntas[0][0] = "¿Cual es el lugar mas frio de la tierra?";
		preguntas[1][0] = "ANTARTIDA";

		preguntas[0][1] = "¿Quien escribio La Odisea?";
		preguntas[1][1] = "HOMERO";

		preguntas[0][2] = " ¿Como se llama la capital de Mongolia?";
		preguntas[1][2] = "Ulan Bator";
		
		preguntas[0][3] = " ¿Cual es el rio mas largo del mundo?";
		preguntas[1][3] = "Amazonas";
		
		preguntas[0][4] = "¿Donde originaron los juegos olimpicos?";
		preguntas[1][4] = "Grecia";
		
		preguntas[0][5] = "¿Que tipo de animal es la ballena?";
		preguntas[1][5] = "mamifero";
		
		preguntas[0][6] = " ¿Que cantidad de huesos en el cuerpo humano?";
		preguntas[1][6] = "206";
		
		preguntas[0][7] = "¿Cuando acabo la II Guerra Mundial?";
		preguntas[1][7] = "1945";
		
		preguntas[0][8] = "¿Quien es el autor de el Quijote?";
		preguntas[1][8] = "Miguel de Cervantes";
		
		preguntas[0][9] = "¿Quien pinto “la ultima cena”?";
		preguntas[1][9] = "Leonardo da Vinci";
		
		preguntas[0][10] = "¿Que son los humanos: omnivoros, herbivoros o carnivoros?";
		preguntas[1][10] = "omnivoros";
		
		preguntas[0][11] = "¿Como se denomina el resultado de la multiplicacion?";
		preguntas[1][11] = "producto";
		
		preguntas[0][12] = "¿Que año llego Cristobal Colon a America?";
		preguntas[1][12] = "1492";
		
		preguntas[0][13] = "¿Quien es el padre del psicoanalisis?";
		preguntas[1][13] = "Sigmund Freud";
		
		preguntas[0][14] = "¿Cual es el disco mas vendido de la historia?";
		preguntas[1][14] = "Thriller";
		
		preguntas[0][15] = "¿Que producto cultiva mas Guatemala?";
		preguntas[1][15] = "cafe";
		
		preguntas[0][16] = "¿Quien es el famoso Rey de Rock en los Estados Unidos?";
		preguntas[1][16] = "Elvis Presley";
		
		preguntas[0][17] = "¿Que significa FIFA?";
		preguntas[1][17] = "Federation Internationale de Football Association";
		
		preguntas[0][18] = "¿En que se especializa la cartografia?";
		preguntas[1][18] = "mapas";
		
		preguntas[0][19] = "¿Cual es el pais mas grande del mundo?";
		preguntas[1][19] = "RUSIA";
		
		preguntas[0][20] = "¿En que año comenzo la II Guerra Mundial?";
		preguntas[1][20] = "1939";
		
		preguntas[0][21] = "Si 50 es el 100%, ¿cuanto es el 90%?";
		preguntas[1][21] = "45";
		
		preguntas[0][22] = " ¿Cual es segundo planeta en el sistema solar?";
		preguntas[1][22] = "venus";
		
		preguntas[0][23] = "¿Que pais tiene forma de bota?";
		preguntas[1][23] = "Italia";
		
		preguntas[0][24] = "¿Cual es la moneda del Reino Unido?";
		preguntas[1][24] = "libra";
		
		preguntas[0][25] = "¿Cual es pais mas poblado de la Tierra?";
		preguntas[1][25] = "china";
		
		preguntas[0][26] = "¿En que lugar del cuerpo se produce la insulina?";
		preguntas[1][26] = "pancreas";
		
		preguntas[0][27] = "¿Como se llama el himno nacional de Francia?";
		preguntas[1][27] = "Marsellesa";
		
		preguntas[0][28] = "De que estilo arquitectonico es la Catedral de Notre Dame en Paris?";
		preguntas[1][28] = "Gotico";
		
		preguntas[0][29] = "¿De que pais es el futbolista Zlatan Ibrahimović?";
		preguntas[1][29] = "suecia";
		
		preguntas[0][30] = "¿A que pais pertenecen los cariocas?";
		preguntas[1][30] = "brasil";
		
		preguntas[0][31] = "¿En que pais se encuentra el famoso monumento Taj Mahal?";
		preguntas[1][31] = "india";
		
		preguntas[0][32] = "¿Como se llama la estacion espacial rusa?";
		preguntas[1][32] = "mir";
		
		preguntas[0][33] = "¿Cual es el primero de la lista de los numeros primos?";
		preguntas[1][33] = "2";
		
		preguntas[0][34] = "¿Cual es el unico mamifero capaz de volar?";
		preguntas[1][34] = "murcielago";
		
		preguntas[0][35] = "¿Cual es el libro sagrado del Islam?";
		preguntas[1][35] = "coran";
		
		preguntas[0][36] = "¿Que es mas pequeño, un atomo o una molecula?";
		preguntas[1][36] = "atomo";
		
		preguntas[0][37] = "¿Quien gano el mundial de 2014?";
		preguntas[1][37] = "Alemania ";
		
		preguntas[0][38] = "¿Quien escribio “Hamlet”?";
		preguntas[1][38] = "William Shakespeare";
		
		preguntas[0][39] = "¿Cual es la moneda oficial de Estados Unidos?";
		preguntas[1][39] = "Dolar";
		
		preguntas[0][40] = "¿A que pais pertenece la ciudad de Varsovia?";
		preguntas[1][40] = "Polonia";
		
		preguntas[0][41] = "¿Cual es la nacionalidad de Pablo Neruda?";
		preguntas[1][41] = "chilena";
		
		preguntas[0][42] = "¿Que veterano musico es la cancion \"Tears in Heaven\"?";
		preguntas[1][42] = "Eric Clapton";
		
		preguntas[0][43] = "¿A quien le crecia la nariz cuando mentia?";
		preguntas[1][43] = "Pinocho";
		
		preguntas[0][44] = "¿Quien traiciono a Jesus?";
		preguntas[1][44] = "Judas";
		
		preguntas[0][45] = "¿Cuanto vale el numero pi? hasta 5 decimales";
		preguntas[1][45] = "3.14159";
		
		preguntas[0][46] = "¿Cual es la capital de Croacia?";
		preguntas[1][46] = "Zagreb";
		
		preguntas[0][47] = "¿Quien es el protagonista de la pelicula “Rocky”?";
		preguntas[1][47] = "Sylvester Stallone";
		
		preguntas[0][48] = "¿En que pais se uso la primera bomba atomica en combate?";
		preguntas[1][48] = "Japon";
		
		preguntas[0][49] = "¿Cual es el metal mas caro del mundo?";
		preguntas[1][49] = "rodio";
		
		preguntas[0][50] = "¿Cuantos años tiene un lustro?";
		preguntas[1][50] = "5";
		preguntas[0][51] = "¿Quien “sabia que no sabia nada”?";
		preguntas[1][51] = "Platon";
		preguntas[0][52] = "¿Cuando empezo la Primera Guerra Mundial?";
		preguntas[1][52] = "1914";
		preguntas[0][53] = "¿En que pais se encuentra el estadio de Wembley?";
		preguntas[1][53] = "Reino Unido";
		preguntas[0][54] = "¿Que instrumento tocaba Paco de Lucia?";
		preguntas[1][54] = "guitarra";
		preguntas[0][55] = "¿En que año se aprobo la actual Constitucion española?";
		preguntas[1][55] = "1978";
		preguntas[0][56] = "¿En que año aparecio en el mercado el primer videojuego protagonizado por Super Mario?";
		preguntas[1][56] = "1981";
		preguntas[0][57] = "¿Cual es el idioma mas antiguo de los que sobreviven en Europa?";
		preguntas[1][57] = "vasco";
		preguntas[0][58] = "¿Cuantos corazones tienen los pulpos?";
		preguntas[1][58] = "3";
		preguntas[0][59] = "¿En que año se produce la Revolucion Francesa?";
		preguntas[1][59] = "1789";
		preguntas[0][60] = "¿Cuantas estrellas aparecen en la bandera de la Republica Popular China?";
		preguntas[1][60] = "5";
		preguntas[0][61] = "¿De que pais es originario el cafe?";
		preguntas[1][61] = "etiopia";
		preguntas[0][62] = "¿Que seleccion nacional ha ganado mas Copas Mundiales de Futbol?";
		preguntas[1][62] = "brasil";
		preguntas[0][63] = "¿En que año murio Steve Jobs?";
		preguntas[1][63] = "2011";
		preguntas[0][64] = "¿En que año viajo al espacio el primer ser humano?";
		preguntas[1][64] = "1961";
		preguntas[0][65] = "¿Que cantante estadounidense es conocido como “The Boss”?";
		preguntas[1][65] = "Bruce Springsteen";
		preguntas[0][66] = "¿Que actriz ha ganado el mayor numero de Premios oscar?";
		preguntas[1][66] = "Katharine Hepburn";
		preguntas[0][67] = "¿En que año llego el ser humano a la Luna?";
		preguntas[1][67] = "1969";
		preguntas[0][68] = "¿En que año se inicia la Revolucion Rusa?";
		preguntas[1][68] = "1917";
		preguntas[0][69] = "¿En que pais se encuentra la ciudad de Calcuta?";
		preguntas[1][69] = "India";
		preguntas[0][70] = "¿En que año se independizo la India del Imperio Britanico?";
		preguntas[1][70] = "1947";
		preguntas[0][71] = "¿Cual es el himno de la Union Europea?";
		preguntas[1][71] = "Oda a la Alegria";
		preguntas[0][72] = "¿En que año murio Freddie Mercury?";
		preguntas[1][72] = "1991";
		preguntas[0][73] = "¿Quien fue el presidente estadounidense al inicio de la Segunda Guerra Mundial?";
		preguntas[1][73] = "Franklin Delano Roosevelt";
		preguntas[0][74] = "¿De quien es la cancion “Love me Tender”?";
		preguntas[1][74] = "Elvis Presley";
		preguntas[0][75] = "¿Cual es el “Pais del Sol Naciente”?";
		preguntas[1][75] = "Japon";
		preguntas[0][76] = "¿Quien dirigio “El Lobo de Wall Street”?";
		preguntas[1][76] = "Martin Scorsese";
		preguntas[0][77] = "¿Cual es la capital de Bolivia?";
		preguntas[1][77] = "La Paz";
		preguntas[0][78] = "¿Cual es la ciudad mas poblada del estado de Texas?";
		preguntas[1][78] = "Houston ";
		preguntas[0][79] = "¿En que pais se encuentra la region de Transilvania?";
		preguntas[1][79] = "rumania";
		preguntas[0][80] = "¿Quien dirigio “El padrino”?";
		preguntas[1][80] = "Francis Ford Coppola";
		preguntas[0][81] = "¿Quien dirigio “La naranja mecanica”?";
		preguntas[1][81] = "Stanley kubrick";
		preguntas[0][82] = "¿Quien interpreto a Forest Gump?";
		preguntas[1][82] = "Tom hanks";
		preguntas[0][83] = "¿Quien protagonizo la pelicula \"Scarface\"?";
		preguntas[1][83] = "Al pacino";
		preguntas[0][84] = "¿Que fue Forest Gump para ser millonario?";
		preguntas[1][84] = "mayorista";
		preguntas[0][85] = "¿Quien protagoniza Pretty Woman?";
		preguntas[1][85] = "Nicholas Cage";
		preguntas[0][86] = "¿Cuantos Oscars consiguio Titanic?";
		preguntas[1][86] = "11";
		preguntas[0][87] = "¿Con que pelicula recibio Marion Cotillard el oscar?";
		preguntas[1][87] = "La vie in rose";
		preguntas[0][88] = "¿Quien dirigio El Gran Lebowski?";
		preguntas[1][88] = "Hermanos Coen";
		preguntas[0][89] = "¿Cuantos Oscars consiguio West Side Story?";
		preguntas[1][89] = "10";
		preguntas[0][90] = "¿Quien dirigio American Beauty?";
		preguntas[1][90] = "Sam Mendes";
		preguntas[0][91] = "¿En que año se estreno Matrix?";
		preguntas[1][91] = "1999";
		preguntas[0][92] = "¿Cuantos oscars consiguio La Lista de Schindler?";
		preguntas[1][92] = "7";
		preguntas[0][93] = "¿En que año se estreno La Guerra de las galaxias?";
		preguntas[1][93] = "1977";
		preguntas[0][94] = "¿Quien protagonizo El Zorro?";
		preguntas[1][94] = "Antonio Banderas";
		preguntas[0][95] = "¿Quien fue el primer director español en conseguir un oscar?";
		preguntas[1][95] = "Jose Luis Garci";
		preguntas[0][96] = "¿Cuantas peliculas hay de Regreso al futuro?";
		preguntas[1][96] = "3";
		preguntas[0][97] = "¿Quien protagoniza Drive?";
		preguntas[1][97] = "Ryan Gosling";
		preguntas[0][98] = "¿En que año se estreno La Naranja Mecanica?";
		preguntas[1][98] = "1971";
		preguntas[0][99] = "¿Quien protagoniza El Silencio de los corderos?";
		preguntas[1][99] = "Jodie Foster";

		return preguntas;
	}



}
