package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz",cobertura.fizzBuzz(15));
        assertEquals("Fizz",cobertura.fizzBuzz(3));
        assertEquals("Buzz",cobertura.fizzBuzz(5));
        assertEquals("2",cobertura.fizzBuzz(2));
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1,cobertura.numeroCombinatorio(1,0));
        assertEquals(1,cobertura.numeroCombinatorio(3,3));
        assertEquals(0,cobertura.numeroCombinatorio(1,3));
        assertEquals(3,cobertura.numeroCombinatorio(3,2));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(0,cobertura.repeticionesConsecutivas(new int[]{1}));
        assertEquals(1,cobertura.repeticionesConsecutivas(new int[]{1,2,3}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,1,1,2,3}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,2,3,3,3,2,5}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,2,3,4,5,5,5}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,2,2,3,5,5,5}));
        assertEquals(4,cobertura.repeticionesConsecutivas(new int[]{1,2,2,2,2,3,4,4}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,2,2,5,5,5}));
        assertEquals(4,cobertura.repeticionesConsecutivas(new int[]{1,2,2,2,2,5,5,5}));
    }
}
