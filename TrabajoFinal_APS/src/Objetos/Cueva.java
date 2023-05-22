package Objetos;

public class Cueva extends Escenario {
    
    Hostilidad hostilidad=Hostilidad.HOSTIL;
    
    public static String descripcion="Las cuevas albergan gandes reservas de oro de antiguas civilizaciones e imperios."
    		+ "Pero ahora custodiadads por monstruos de gran poder."
    		+ "A una cueva no te recopiendo acercarte si no es por busqueda de un gran botin.";
    
    public Cueva(){
        this.botin=(int)(Math.random()+1000)*50;
        this.poder=botin/(int)(Math.random()+1*5);
    }
	public String getNombre() {
		return nombre;
	}


    @Override
    public void generarEventoAleatorio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	@Override
	public void menuOpciones() {
		// TODO Auto-generated method stub
		
	}
}
