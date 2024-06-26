package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;

class trieTests {

    @Test
    void agregarElementos() {
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("Sebastian",6);
        t.insertar("kiara",12);
        t.insertar("Gian",8);
        t.insertar("Julian",7);
        t.insertar("Augusto",3);
        assertEquals(true,t.buscar("Sebastian"));
        assertEquals(false,t.buscar("Juan"));
        assertEquals(false, t.buscar(""));
        assertEquals(false, t.buscar("k"));
        assertEquals(true,t.buscar("Gian"));
        assertEquals(true,t.buscar("Julian"));
        assertEquals(true,t.buscar("Augusto"));
        assertEquals(false,t.buscar("August"));
        assertEquals(false,t.buscar("Augustoo"));
        t.insertar("",0);
        assertEquals(true, t.buscar(""));

    }

    @Test
    void trieVacio() {
        Trie<Integer> t = new Trie<Integer>();
        assertEquals(false,t.buscar("hola"));
        assertEquals(false,t.buscar(""));
    }       


    @Test 
    void obteniendo(){
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("",1);
        t.insertar("hola",8);
        t.insertar("ho",10);
        t.insertar("comida",5);
        assertEquals(8, t.obtener("hola"));
        assertEquals(10, t.obtener("ho"));
        assertEquals(1, t.obtener(""));
        assertEquals(5, t.obtener("comida"));
        t.insertar("comida", 2);
        assertEquals(2,t.obtener("comida"));
    }
    
 
    @Test
    void borrado(){
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("hola",8);
        t.insertar("h",99);
        t.insertar("ho",10);
        t.insertar("comida",5);
        t.insertar("comida", 2);
        t.insertar("honda vital", 32);
        t.insertar("honda vital ya", 11);
        t.insertar("holasas", 14);
        assertEquals(2,t.obtener("comida"));
        t.borrar("hola");
        assertEquals(true, t.buscar("holasas"));
        assertEquals(true, t.buscar("honda vital"));
        assertEquals(true, t.buscar("ho"));
        assertEquals(false,t.buscar("hola"));
        t.borrar("honda vital ya");
        assertEquals(false, t.buscar("honda vital ya"));
        

    }
    

    @Test
    void borrar_uno_con_muchos_hijos(){                               //Este Test no lo pasaba, ya que la funcion mas de un hijo
                                                                    //  devolvia contador < 2, osea devolvia true si tenia 1 hijo o 0.
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("hola",6);
        t.insertar("holasa",5);
        t.insertar("holapa",6);
        t.insertar("holara",5);
        t.insertar("holagol",6);
        t.insertar("holayona",5);
        t.insertar("holaflor",6);
        t.insertar("holawa",5);
        t.borrar("hola");
        assertEquals(false, t.buscar("hola"));
        assertEquals(true, t.buscar("holapa"));
    }

    @Test 
    void borrar_uno_con_un_solo_hijo(){                             //Este test lo pasaba de suerte, por que cuando hay una palabra que tiene como prefijo
        Trie<Integer> t = new Trie<Integer>();                      //a la que queremos borrar hay que ver si tiene un solo hijo o mas el nodo actual. Y estabamos chequeando
        t.insertar("hola",6);                           //que tenga mas de un hijo, pero como la funcion masDeUnHijo estaba mal hecha pasaba el test.
        t.insertar("holasa",5);
        t.borrar("hola");
        assertEquals(false, t.buscar("hola"));
        assertEquals(true, t.buscar("holasa"));
    }

    @Test
    void borrar_uno_que_tenga_difurcacion_grande_antes_de_terminar(){               //Me parece que esto tambien funcionaba de casualidad, siempre el nodo actual "tenia mas de un hijo"
        Trie<Integer> t = new Trie<Integer>();                                      //entonces entraba por el if despues del for que chequeaba si tenia mas de un hijo y le sacaba el valor al ultimo nodo.
        t.insertar("rompecabezas",10);                                  //de esa forma quedaban todos los nodos inutiles dando vueltas.
        t.insertar("rocola",15);
        t.insertar("roffo",1);
        t.insertar("rotfo",1);
        t.borrar("rompecabezas");
        assertEquals(false, t.buscar("rompecabezas"));
        assertEquals(true, t.buscar("rocola"));
        assertEquals(true, t.buscar("roffo"));
        assertEquals(true, t.buscar("rotfo"));
    }

    /*@Test
    void probando_el_toString(){
        Trie<Integer> t = new Trie<Integer>();                                      
        t.insertar("rompecabezas",10);                                  
        t.insertar("rocola",15);
        t.insertar("roffo",1);
        t.insertar("rotfo",1);
        t.insertar("arbol",1);
        assertArrayEquals("[arbol, rocola, roffo, rompecabezas, rotfo]", t.todasLasPalabras());
    }*/
    

    @Test
    void testEstudiantes(){
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("{1/2}",0);
        t.insertar("{1/20}",0);
        t.insertar("{20/2}",0);
        t.insertar("{3/20}",0);
        t.insertar("{7/2}",0);
        t.insertar("{18/20}",0);
        t.insertar("{1/2}",t.obtener("{1/2}")+1);
        t.insertar("{1/20}",t.obtener("{1/20}")+1);
        t.insertar("{20/2}",t.obtener("{20/2}")+1);
        t.insertar("{3/20}",t.obtener("{3/20}")+1);
        assertEquals(t.obtener("{3/20}"),1);
        assertEquals(t.obtener("{20/2}"),1);
        assertEquals(t.obtener("{1/20}"),1);
        assertEquals(t.obtener("{1/2}"),1);
    }

    @Test
    void testBorrado(){
        Trie<Integer> t = new Trie<Integer>();
        t.insertar("Matemática 3",0);
        t.insertar("Matemática 1",10);
        t.borrar("Matemática 1");
        t.borrar("Matemática 3");
    }
}
