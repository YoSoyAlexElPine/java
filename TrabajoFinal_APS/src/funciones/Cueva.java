package funciones;

class Cueva extends Escenario {
    
    Hostilidad hostilidad=Hostilidad.HOSTIL;
    
    public Cueva(){
        this.botin=(int)(Math.random()+1000)*5;
        this.poder=botin/(int)(Math.random()+1*5);
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
