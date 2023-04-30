/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author b03-12t
 */
public class Tren implements Operable {
    private final String id;
    private int velocidad;
    Tren (String id,int velocidad){
        this.id=id;
        this.velocidad=velocidad;
    }
    public void acelerar(){
        velocidad++;
    }
    public void frenar(){
        velocidad--;
    }
    public void resumirMetodosTren(){
        System.out.println(getVelocidad());
        Operable.resumirMetodosInterface();
    }

    public String getIdVehículo() {
        return ("Tren con ID: "+id);
    }

    public int getVelocidad() {
        return velocidad;
    }
    public void imprimirUbicaciongeografica(){
        System.out.println("HOla mundo");
    }
 
    
}
