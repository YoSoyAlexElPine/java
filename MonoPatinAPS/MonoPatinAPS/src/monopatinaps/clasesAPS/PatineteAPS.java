package monopatinaps.clasesAPS;

public class PatineteAPS extends Transporte {

    int peso, alturaManillar;

    public PatineteAPS(int peso, int alturaManillar) {
        this.peso = peso;
        this.alturaManillar = alturaManillar;
        cont++;
        electrico = true;
    }

    public PatineteAPS(int peso, int alturaManillar, int valoracion, int precio, String referencia, String descripcion, boolean electrico) {
        super(valoracion, precio, referencia, descripcion, electrico);
        this.peso = peso;
        this.alturaManillar = alturaManillar;
        cont++;
    }

    public PatineteAPS(int peso, int alturaManillar, String referencia, String descripcion) {
        super(referencia, descripcion);
        this.peso = peso;
        this.alturaManillar = alturaManillar;
        cont++;
    }

    public PatineteAPS(int peso) {
        this.peso = peso;
        cont++;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setAlturaManillar(int alturaManillar) {
        this.alturaManillar = alturaManillar;
    }

    public int getPeso() {
        return peso;
    }

    public int getAlturaManillar() {
        return alturaManillar;
    }

   

    public void imprimir() {
        System.out.println("""
                           =====
                           
                            ||
                           
                            ||    //O
                           
                            ||  //
                           
                            ||//O
                           """);
    }
}
