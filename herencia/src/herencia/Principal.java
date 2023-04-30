package herencia;

public class Principal {

    public static void main(String[] args) {
        Tren t = new Tren("013", 0);
        System.out.println(t.getIdVehículo());
        System.out.println("Velocidad: " + t.getVelocidad());
        for (int i = 0; i < 20; i++) {
            t.acelerar();
        }
        System.out.println("Velocidad: " + t.getVelocidad());
        t.imprimirUbicaciongeografica();
        t.resumirMetodosTren();
    }

}
