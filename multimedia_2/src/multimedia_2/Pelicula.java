/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multimedia_2;

/**
 *
 * @author b03-12t
 */
public class Pelicula extends Multimedia {
String actorP,actrizP;

    @Override
    public String toString() {
        return "Pelicula{" + "actorP=" + actorP + ", actrizP=" + actrizP + '}';
    }

    public Pelicula(String autor, String titulo, FORMATO formato, int duracion) {
        super(autor, titulo, formato, duracion);
    }

     public void setActorP(String actorP) {
        this.actorP = actorP;
    }

    public void setActrizP(String actrizP) {
        this.actrizP = actrizP;
    }

    public String getActorP() {
        return actorP;
    }

    public String getActrizP() {
        return actrizP;
    }

}
