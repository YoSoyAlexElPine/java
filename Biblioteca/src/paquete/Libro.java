/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.time.Year;

public class Libro extends Publicacion {

    final boolean presatable = true;
    int numLibros;

    public Libro(int anio, int codigo, String titulo) {
        super(anio, codigo, titulo);
        prestado = false;
    }

    public Libro(int anio, int codigo, String titulo, boolean prestado) {
        super(anio, codigo, titulo);
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Libro{" + "presatable=" + presatable + ", numLibros=" + numLibros + '}';
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
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

    public boolean isPresatable() {
        return presatable;
    }

    public int getNumLibros() {
        return numLibros;
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

    public int getAntiguedad() {
        int anioActual = Year.now().getValue();
        return anioActual - anio;
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
