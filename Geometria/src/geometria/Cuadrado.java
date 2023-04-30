package geometria;


public class Cuadrado {
    int lado;
    public Cuadrado(int lado){
        this.lado=lado;
    }
    public int area(){
        int area;
        area=lado*lado;
        return area;
    }
    public double perimetro(){
        double perimetro;
        perimetro=lado*4;
        return perimetro;
    }
    public double diagonal(){
        double diagonal;
        diagonal=Math.sqrt(lado*lado*2);
        return diagonal;
    }

    public void datos() {
        System.out.println( "cuadrado{" + "Area = " + area() + " Perimetro  = " + perimetro()+ " Diagonal = " + diagonal()+ '}');
    }
}
