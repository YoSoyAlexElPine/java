/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication18;

/**
 *
 * @author b03-12t
 */
public class Escenario {
    int contador;
    float tamanio;
    String zona;
    boolean bloqueo;
    Hostilidad hostilidad;
public void generarEventoAleatorio(){
    
}
    @Override
    public String toString() {
        return "Escenario{" + "contador=" + contador + ", tamanio=" + tamanio + ", zona=" + zona + ", bloqueo=" + bloqueo + ", hostilidad=" + hostilidad + '}';
    }
    
    public void escenarios(){
        
    }

    public int getContador() {
        return contador;
    }

    public float getTamanio() {
        return tamanio;
    }

    public String getZona() {
        return zona;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public Hostilidad getHostilidad() {
        return hostilidad;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public void setHostilidad(Hostilidad hostilidad) {
        this.hostilidad = hostilidad;
    }
    
}
