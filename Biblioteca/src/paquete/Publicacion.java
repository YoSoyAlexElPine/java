/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

public abstract class Publicacion implements Comparable<Publicacion>, Prestable {
    public int contador=0;
    public static Publicacion[] array = new Publicacion[999999999];
    public boolean presatable, prestado;
    public int anio, codigo,cuentaPrestados=0;
    public String titulo;
    public Publicacion(int anio, int codigo, String titulo) {
        this.anio = anio;
        this.codigo = codigo;
        this.titulo = titulo;
        array[contador]=this;contador++; 
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

    public void setPresatable(boolean presatable) {
        this.presatable = presatable;
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

    @Override
    public String toString() {
        return "Publicacion{" + "presatable=" + presatable + ", prestado=" + prestado + ", anio=" + anio + ", codigo=" + codigo + ", titulo=" + titulo + '}';
    }

    public int compareTo(Publicacion pub) {
        int valor;
        if (this == pub) {
            valor = 0;
        }
        if (pub == null) {
            valor = -2;
        }
        if (this.getAnio() == pub.getAnio()) {
            valor = 0;
        } else {
            if (this.getAnio() < pub.getAnio()) {
                valor = 1;
            } else {
                valor = -1;
            }
        }
        return valor;
    }

    public void prestar() {
        if (presatable == false) {
            System.out.println("No se puede prestar");
        } else {
            if (prestado == true) {
                System.out.println("Ya esta prestado por otra persona");
            } else {
                System.out.println("Libro prestado con exito");
                prestado = true;
                cuentaPrestados++;
            }
        }
    }

    public void devolver() {
        if (prestado == true) {
            System.out.println("Devuelto con exito");
            cuentaPrestados--;
            prestado = false;
        } else {
            System.out.println("No puedes devolver algo que no tienes prestado");
        }

    }

    public boolean estaPrestado() {
        return prestado == true;
    }

}
