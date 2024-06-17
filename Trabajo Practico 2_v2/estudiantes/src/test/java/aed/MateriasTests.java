package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MateriasTests {

    @Test
    void quePasaConMaterias(){

        Materia m = new Materia();
        System.out.println(m.getDocente()[0]);
        assertArrayEquals(new int[] {0, 0, 0, 0},m.getDocente());
        m.agregarDocente(0);
        m.agregarDocente(1);
        m.agregarDocente(2);
        m.agregarDocente(3);
        assertArrayEquals(new int[] {1, 1, 1, 1},m.getDocente());
        for(int i = 0; i<100;i++){
            Integer ii = i;
            m.agregarAlumno(ii.toString());
        }
        assertEquals(true, m.excedeCupoMateria());
    }
    
}
