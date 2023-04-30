/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopatinaps.clasesAPS;

public class Transporte implements Imprimible {
    public int cont=0;
    int valoracion, precio;
    String referencia, descripcion;
    boolean electrico;

    public Transporte() {
        cont++;
        electrico = true;
        referencia=generarReferencia();
    }

    public void imprimir() {

    }

    public Transporte(int valoracion, int precio, String referencia, String descripcion, boolean electrico) {
        this.valoracion = valoracion;
        this.precio = precio;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.electrico = electrico;
        cont++;
    }

    public Transporte(int valoracion, int precio, String referencia, String descripcion) {
        this.valoracion = valoracion;
        this.precio = precio;
        this.referencia = referencia;
        this.descripcion = descripcion;
        electrico = true;
        cont++;
    }

    public Transporte(String referencia, String descripcion) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        cont++;
        electrico = true;
    }

    /**
     * Datos de objetos tipo transporte
     */
    public void datos() {
        System.out.println("=== Datos Transporte ===");
        System.out.print("Valoracion = ");
        for (int i = 0; i < valoracion; i++) {
            System.out.print("* ");
        }
        System.out.println("");
        System.out.println("Precio = "+precio);
        System.out.println("Referencia = " + referencia);
        System.out.println("Descripcion = " + descripcion);
        System.out.println("Electrico = "+electrico);
        System.out.println("");

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

    public boolean validarReferencia(String ref) {
        if (ref.length()!=8) {
            System.out.println("Se necesita una distancia de 8 caracteres");
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (ref.charAt(i)==0||ref.charAt(i)==2||ref.charAt(i)==3||ref.charAt(i)==4||ref.charAt(i)==5||ref.charAt(i)==6||ref.charAt(i)==7||ref.charAt(i)==8||ref.charAt(i)==9||ref.charAt(i)==1) {
                
            } else {
                return false;
            }
            if (ref.charAt(4)!='-') {
                return false;
            }
            
        }
        return true;
    }

    /**
     * Mediante uso de string builder y Math.random createmos una referencia valida y aleatoria
     */
    public String generarReferencia() {
        StringBuilder sb = new StringBuilder();
        int a=(int) (Math.random() * 9999);
        String s1 = "QWERTYUIOPASDFGHJKLZXCVBNM",resultado;
        sb.append(a);
        sb.append("-");
        for (int i = 0; i < 3; i++) {
            sb.append(s1.charAt((int) (Math.random() * s1.length())));
        }
        resultado=sb.toString();
        return resultado;
    }

}
