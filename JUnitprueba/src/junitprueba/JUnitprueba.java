package junitprueba;

public class JUnitprueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Coche p=new Coche("Audi A3",100000);
        Coche.impuesto=20f;
        System.out.println("Precio final: "+p.precioFinal(10f));
    }
    
}
