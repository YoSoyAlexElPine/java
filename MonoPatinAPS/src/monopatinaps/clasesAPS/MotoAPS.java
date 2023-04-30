/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopatinaps.clasesAPS;

/**
 *
 * @author b03-12t
 */
public class MotoAPS extends Transporte {


    boolean deportiva;
    Cilindrada cc;

    public MotoAPS(boolean deportiva, Cilindrada cc, int valoracion, int precio, String referencia, String descripcion, boolean electrico) {
        super(valoracion, precio, referencia, descripcion, electrico);
        this.deportiva = deportiva;
        this.cc = cc;
         cont++;
    }

    public MotoAPS(boolean deportiva, Cilindrada cc, String referencia, String descripcion) {
        super(referencia, descripcion);
        this.deportiva = deportiva;
        this.cc = cc;
         cont++;
    }
  
    public MotoAPS(boolean deportiva, Cilindrada cc) {
        this.deportiva = deportiva;
        this.cc = cc;
         cont++;
    }



    public MotoAPS() {
            cont++;
    }



    public void setDeportiva(boolean deportiva) {
        this.deportiva = deportiva;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public Cilindrada getCc() {
        return cc;
    }

    public void setCc(Cilindrada cc) {
        this.cc = cc;
    }

    public boolean isDeportiva() {
        return deportiva;
    }

    public int getValoracion() {
        return valoracion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCont() {
        return cont;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isElectrico() {
        return electrico;
    }
    public void imprimir(){
        System.out.println("Cuando tenga tiempo dibujo una moto");
    }
    /**
     * Metodo el cual introducinos dos objetos tipo MotoAPS y nos devuele cual es mayor en funcion de la cilindrada
     * asignando a cada cilindrada un dato tipo int y comparandolo despues
     */
    
    public void mayorQue(MotoAPS a,MotoAPS b){
        int a1 = 0,a2=0;
        if (a.getCc()==Cilindrada.CC50) {
            a1=-1;
        }
        if (a.getCc()==Cilindrada.CC125) {
            a1=0;
        }
        if (a.getCc()==Cilindrada.CC250) {
            a1=1;
        }
        if (a.getCc()==Cilindrada.CC500) {
            a1=2;
        }
        if (a.getCc()==Cilindrada.CC1000) {
            a1=3;
        }
        if (b.getCc()==Cilindrada.CC125) {
            a2=0;
        }
        if (b.getCc()==Cilindrada.CC250) {
            a2=1;
        }
        if (b.getCc()==Cilindrada.CC500) {
            a2=2;
        }
        if (b.getCc()==Cilindrada.CC1000) {
            a2=3;
        }
        if (a.getCc()==Cilindrada.CC50) {
            a2=-1;
        }
        if (a1==a2) {
            System.out.println("Ambas motos son de igual tamaño");
        }
        if (a1>a2) {
            System.out.println("Moto de referencia "+a.getReferencia()+" es mayor que la moto de referencia "+b.getReferencia());
        } else {
            System.out.println("Moto de referencia "+b.getReferencia()+" es mayor que la moto de referencia "+a.getReferencia());
        }
        
    }

}
