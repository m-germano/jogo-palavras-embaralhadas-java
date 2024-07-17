package testApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.EmbaralhadorAleatorio;

public class EmbaralhadorAleatorioTest {
    @Test
    void testEmbaralhar() {
        EmbaralhadorAleatorio embaralhador = new EmbaralhadorAleatorio();

        String palavra = "java";
        String embaralhada = embaralhador.embaralhar(palavra);
        assertTrue(contemMesmasLetras(palavra, embaralhada));
        
        palavra = "programming";
        embaralhada = embaralhador.embaralhar(palavra);
        assertTrue(contemMesmasLetras(palavra, embaralhada));

        palavra = "computer";
        embaralhada = embaralhador.embaralhar(palavra);
        assertTrue(contemMesmasLetras(palavra, embaralhada));
        
        palavra = "";
        embaralhada = embaralhador.embaralhar(palavra);
        assertEquals("", embaralhada);
        
        palavra = "a";
        embaralhada = embaralhador.embaralhar(palavra);
        assertEquals("a", embaralhada);
    }

    private boolean contemMesmasLetras(String original, String embaralhada) {
        char[] originalArray = original.toCharArray();
        char[] embaralhadaArray = embaralhada.toCharArray();

        java.util.Arrays.sort(originalArray);
        java.util.Arrays.sort(embaralhadaArray);

        return java.util.Arrays.equals(originalArray, embaralhadaArray);
    }
}