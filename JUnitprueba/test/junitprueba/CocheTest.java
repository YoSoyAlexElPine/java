/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package junitprueba;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author b03-12t
 */
public class CocheTest {
    
    public CocheTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of precioFinal method, of class Coche.
     */
    @Test
    public void testPrecioFinal() throws Exception {
        System.out.println("precioFinal");
        float descuento = 10.0F;
        Coche.impuesto=20f;
        Coche instance = new Coche("Audi A3",10000);
        ;
        float expResult = 10800;
        float result = instance.precioFinal(descuento);
        assertEquals(expResult, result, 0.000001);
        
    }
    
}
