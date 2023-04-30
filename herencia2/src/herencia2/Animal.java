/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia2;

public abstract class Animal {
   String nombre;
   int velocidad;
   int velSueño;
   int velHambre;
   int edad;
   int avance;
   int hambre=101;
   int sueño=101;

    public Animal() {
    }
   
       public void comer() {
        hambre=100;
    }

    public void dormir() {
        sueño=100;
    }
    
    public void avanzar() {
        avance=avance+velocidad;
        hambre=hambre-velHambre;
        sueño=sueño-velSueño;
        System.out.println("Avance: "+avance+" Hambre: "+hambre+" Sueño: "+sueño);
    }
}
