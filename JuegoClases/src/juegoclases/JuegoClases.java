    package juegoclases;

public class JuegoClases {

   
    public static void main(String[] args) {
        Juego jg=new Juego();
        jg.generar();
        do {
        jg.Leer();
        jg.comprovar(); 
        } while (jg.numeroIntentos>0 && jg.numeroAdivinar!=jg.numeroIntroducido);

    }
    
}
