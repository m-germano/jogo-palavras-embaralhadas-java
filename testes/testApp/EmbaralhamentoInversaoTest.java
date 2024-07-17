package testApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


import entities.EmbaralhadorInversao;

public class EmbaralhamentoInversaoTest{

	@Test
    void testEmbaralhar() {
        EmbaralhadorInversao embaralhador = new EmbaralhadorInversao();
        
        assertEquals("avaj", embaralhador.embaralhar("java"));
        assertEquals("gnimmargorp", embaralhador.embaralhar("programming"));
        assertEquals("retupmoc", embaralhador.embaralhar("computer"));
        assertEquals("", embaralhador.embaralhar(""));
        assertEquals("a", embaralhador.embaralhar("a"));
    }

}
