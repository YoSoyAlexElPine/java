package proyectojv.jrm.ap.pkg2;


public class Mazmorra extends Escenario implements Dibujable {

    protected int altura = 0;
    protected int evento = 1;
    final private int MIN = 2, MAX = 10;

    public Mazmorra(int altura, String nZona, Hostilidad hostilidad) {
        super(nZona, true, hostilidad);
        this.altura = altura;
        this.evento = generarEventoAleatorio();

    }

    public Mazmorra(String nZona, Hostilidad hostilidad) {
        super(nZona, false, hostilidad);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public void ejecutarEvento() {

    }

    @Override
    public int generarEventoAleatorio() {
        return (int) (Math.random() * (this.MAX - this.MIN + 1) + this.MIN);
    }

    @Override
    public String toString() {
        return super.toString() + "\naltura:" + altura + "\nevento:" + evento;
    }

    @Override
    public void dibujar() {
        Hostilidad valor = (Hostilidad) this.getHostilidad();
        char caracter;
        if (!super.isExplorado()) {
            caracter='o';
        }else{
            caracter='x';
        }
        switch (valor) {
            case HOSTIL -> {
                System.out.print(ANSI_RED + "|"+caracter+"|");
            }
            case PASIVA -> {
                System.out.print(ANSI_BLUE + "|"+caracter+"|");
            }
            case AMISTOSA -> {
                System.out.print(ANSI_GREEN + "|"+caracter+"|");
            }
            default -> {
                System.out.println("No valido");
            }
        }
    }
}
