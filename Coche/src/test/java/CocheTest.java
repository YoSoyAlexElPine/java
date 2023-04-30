/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.coche.Coche;
import com.mycompany.coche.Funciones.Temperatura;
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

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
    public void testPrecioFinal()throws Exception {
        float descuento=10f;
        Coche instance = new Coche("Audi",100000);
        int a=0,b=0;
        float expResult=0f;
        float result=instance.precioFinal(descuento);
        assertEquals(a,b);
    
    }
public class TemperaturaTest {
    @Test
    public void testFahrenheitToCelsius() throws Exception  {
        assertEquals(-20.556, Temperatura.fahrenheitToCelsius(-5), 0.001);
        assertEquals(-17.778, Temperatura.fahrenheitToCelsius(0), 0.001);
        assertEquals(-9.444, Temperatura.fahrenheitToCelsius(15), 0.001);
        assertEquals(0, Temperatura.fahrenheitToCelsius(32), 0.001);
    }
    
  


}
}