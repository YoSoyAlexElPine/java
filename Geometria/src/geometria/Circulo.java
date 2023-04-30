/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometria;

/**
 *
 * @author b03-12t
 */
public class Circulo {
    private int radio,x,y;
    public static final double PI=Math.PI;
    public Circulo (int radio){
        this.radio=radio;
    }
    public Circulo(int radio,int x,int y){
        this.radio=radio;
        this.y=y;
        this.x=x;
    }
    public double area(){
        double area;
        area=radio*radio*PI;
        return area;
    }
    public double longitud(){
        double longitud;
        longitud=2*PI*radio;
        return longitud;
    }
    public double diametro(){
        double diametro;
        diametro=2*radio;
        return diametro;
    }
    public void cordenadas(){
        System.out.println("Cordenada x = "+x);
        System.out.println("Cordenda y = "+y);
    }
    public String toString() {
        return "Circulo{" + "radio=" + radio + ", x=" + x + ", y=" + y + '}';
    }
    
        public void datos() {
            System.out.println( "{Area=" + area() + ", longitud=" + longitud() + ", Diametro=" + diametro() + '}');
    }
    
}
