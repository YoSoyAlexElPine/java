/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopatinaps.clasesAPS;

/**
 *
 * @author b03-12t
 */
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

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public int getPeso() {
        return peso;
    }

    public int getAlturaManillar() {
        return alturaManillar;
    }

    public int getValoracion() {
        return valoracion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCont() {
        return cont;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isElectrico() {
        return electrico;
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
