package herencia;

public interface Operable {
    public String getIdVehículo();
    public void acelerar ();
    public void frenar();
    default public void imprimirUbicaciongeografica (){
        System.out.println("Implementacion por defecto en interface");
    }
    public static void resumirMetodosInterface(){
        System.out.println("getIdVehículo,acelerar,frenar"
        +", imprimirUbicacionGeografica, resumirMetodosInterface");
    }
}
