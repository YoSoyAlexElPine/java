package paquete;

public abstract class PoligonosRegulares {

    public int lado, numLados, orientacion = 0;
    public String color = "rojo";
    public boolean relleno = false;

    public PoligonosRegulares() {
    }

    public int obtenerPerimetro() {
        System.out.println("Calculando perimetro");
        int perimetro = lado * numLados;
        return perimetro;
    }

    public void rotar(int grados) {
        System.out.println("Rotando poligono");
        orientacion = orientacion + grados;
    }

    public void agrandar() {
        System.out.println("Agrandando poligono");
        lado++;
    }

    public void rellenar() {
        System.out.println("Rellenando poligono");
        relleno = true;
    }

    public void reducir() {

        if (lado > 0) {
                    System.out.println("Reducionedo poligono");
            lado--;
        } else {
            System.out.println("Dimensiones demasiado pequeñas");
        }

    }

}
