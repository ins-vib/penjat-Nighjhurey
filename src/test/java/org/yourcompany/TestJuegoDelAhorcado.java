package org.yourcompany;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.yourcompany.yourproject.JuegoDelAhorcado;

public class TestJuegoDelAhorcado {

    @Test
    public void testObtenerPalabra() {
        String palabra = JuegoDelAhorcado.Obtenerpalabras();
        String[] posibles = { "hola", "cadira", "tisores", "riu", "fotografia", "escala", "llibre", "ordinador",
                "ratoli", "armari", "pati", "programa", "columna" };

        // La palabra obtenida debe estar dentro del array
        assertTrue(java.util.Arrays.asList(posibles).contains(palabra));
    }
    @Test
    public void testInicializar() {
        String palabra = "hola";
        char[] estado = JuegoDelAhorcado.inicializar(palabra);

        // Debe tener la misma longitud que la palabra
        assertEquals(palabra.length(), estado.length);

        // Todos los caracteres deben ser '_'
        for (char c : estado) {
            assertEquals('_', c);
        }
    }
    @Test
    public void testActualizar() {
        String palabra = "hola";
        char[] estado = { '_', '_', '_', '_' };

        boolean encontrada = JuegoDelAhorcado.actualizarEstado(estado, palabra, 'o');

        assertTrue(encontrada);
        assertEquals('_', estado[0]);
        assertEquals('o', estado[1]);
        assertEquals('_', estado[2]);
        assertEquals('_', estado[3]);
    }

    @Test
    public void testPalabraComplet() {
        char[] estado = { 'h', '_', 'l', 'a' };
        assertFalse(JuegoDelAhorcado.palabraCompleta(estado));

        char[] estado2 = { 'h', 'o', 'l', 'a' };
        assertTrue(JuegoDelAhorcado.palabraCompleta(estado2));
    }

}
