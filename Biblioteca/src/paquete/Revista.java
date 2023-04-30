/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author b03-12t
 */
public class Revista extends Publicacion implements Prestable {

    int numero = 0;
    final boolean presatable = false;
    final boolean prestado = false;

    public Revista(int anio, int codigo, String titulo) {
        super(anio, codigo, titulo);
        numero++;
    }

    public Revista(int anio, int codigo, String titulo, int numero) {
        super(anio, codigo, titulo);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isPresatable() {
        return presatable;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public int getAnio() {
        return anio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
        public boolean equals(Object objeto) {
        boolean aux;
        aux = this == objeto;
        if (objeto == null || getClass() != objeto.getClass()) {
            aux = false;
        }
        Publicacion x = (Publicacion) objeto;
        aux = codigo == x.codigo;
        return aux;
    }
}
