/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.coche;

/**
 *
 * @author b03-12t
 */
public class Coche {

    public String modelo;
    public float precioBase;
    public static float impuestos;

    public Coche(String modelo, float precioBase) {
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public float precioPinal(float descuento) throws Exception {
        float precioConDescuento = this.precioBase;
        if (descuento < 0 || descuento > 100) {
            throw new RuntimeException("Descuento erroneo");
        }
        if (precioBase >= 5000) {
            precioConDescuento = this.precioBase - (this.precioBase * descuento / 100f);
        }
        return precioConDescuento + precioConDescuento * this.impuestos / 100f;
    }

    public static void main(String[] args) throws Exception {
        Coche p =new Coche("Audi",10000);
        Coche.impuestos=20f;
        System.out.println("Precio final: "+p.precioPinal(110f));
    }

    public float precioFinal(float descuento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
