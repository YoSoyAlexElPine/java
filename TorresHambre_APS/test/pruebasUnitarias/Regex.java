package pruebasUnitarias;

import funciones.FuncionesGenerales;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class Regex {

    @Test
    public void testValidarEmail_ValidEmail() {
        String validEmail = "test@example.com";
        boolean result = FuncionesGenerales.validarEmail(validEmail);
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidarEmail_InvalidEmail() {
        String invalidEmail = "invalid-email";
        boolean result = FuncionesGenerales.validarEmail(invalidEmail);
        Assertions.assertFalse(result);
    }

    @Test
    public void testValidarContrasenaFuerte() {
        // Prueba con una contraseña fuerte
        String contrasenaFuerte = "MeGustaJava123+";
        assertTrue(contrasenaFuerte.matches(FuncionesGenerales.FUERTE));
    }

    @Test
    public void testValidarContrasenaDebil() {
        // Prueba con una contraseña débil
        String contrasenaDebil = "123456";
        assertFalse(contrasenaDebil.matches(FuncionesGenerales.FUERTE));
    }

    @Test
    public void testValidarContrasenaSinCaracterEspecial() {
        // Prueba con una contraseña que no tiene caracter especial
        String contrasenaSinCaracterEspecial = "Contrasena123";
        assertFalse(contrasenaSinCaracterEspecial.matches(FuncionesGenerales.FUERTE));
    }

    @Test
    public void testValidarContrasenaSinNumero() {
        // Prueba con una contraseña que no tiene número
        String contrasenaSinNumero = "Contrasena+";
        assertFalse(contrasenaSinNumero.matches(FuncionesGenerales.FUERTE));
    }

    @Test
    public void testValidarContrasenaCorta() {
        // Prueba con una contraseña que es demasiado corta
        String contrasenaCorta = "a1+";
        assertFalse(contrasenaCorta.matches(FuncionesGenerales.FUERTE));
    }

}
