package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;

    private class Nodo {
        private T valor;
        private Nodo izq;
        private Nodo der;
        private Nodo padre;

        public Nodo(T elem){
            valor = elem;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        this.raiz = null;
    }

    public int cardinal() {
        return contar(this.raiz);
    }

    private int contar(Nodo n){
        if (n == null) {
            return 0;
        }else{
           return 1 + contar(n.izq) + contar(n.der);
        }

    }

    public T minimo(){
        Nodo actual = this.raiz;

        while (actual.izq != null){
            actual = actual.izq;
        }

        return actual.valor;
    }

    public T maximo(){
        Nodo actual = this.raiz;

        while (actual.der != null){
            actual = actual.der;
        }

        return actual.valor;        
    }

    public void insertar(T elem){ 
        Nodo Ainsert = new Nodo(elem);

        if (this.raiz == null){            
            this.raiz = Ainsert;      

        }else{
            Nodo ultNodo = ultimoNodoBuscado(this.raiz, elem);

            if (ultNodo.valor != elem ) {
            
                if (elem.compareTo(ultNodo.valor) > 0){
                    ultNodo.der = Ainsert;
                }else{
                    ultNodo.izq = Ainsert;
                }
    
                Ainsert.padre = ultNodo;
            }
        }
            
    }

    private Nodo ultimoNodoBuscado(Nodo n,T elem){
        if(n.valor == elem){
            return n;
        }else if (elem.compareTo(n.valor) > 0){
            if(n.der == null){
                return n;
            }else{
                return ultimoNodoBuscado(n.der, elem);
            }
        }else{
            if(n.izq == null){
                return n;
            }else{
                return ultimoNodoBuscado(n.izq, elem);
            }
            
        }


    }

    public boolean pertenece(T elem){
        Nodo comparacion = ultimoNodoBuscado(raiz, elem);

        return (comparacion.valor == elem);
    }

    public void eliminar(T elem){
        Nodo busqueda = ultimoNodoBuscado(raiz,elem);

        if (busqueda.valor == elem){
            if(cuantosHijos(busqueda) == 0){

                if(elem.compareTo(busqueda.padre.valor) > 0){
                    busqueda.padre.der = null;
                }else{
                    busqueda.padre.izq = null;
                }

            }else if (cuantosHijos(busqueda) == 1){

                if (busqueda.izq != null){
                    Nodo nuevoHijo = busqueda.izq;
                    
                    if (nuevoHijo.valor.compareTo(busqueda.padre.valor) > 0){
                        busqueda.padre.der = nuevoHijo;
                        nuevoHijo.padre = busqueda.padre;
                    }else{
                        busqueda.padre.izq = nuevoHijo;
                        nuevoHijo.padre = busqueda.padre;
                    }
                }else if (busqueda.der != null){
                   Nodo nuevoHijo = busqueda.der;

                   if (nuevoHijo.valor.compareTo(busqueda.padre.valor) > 0){
                    busqueda.padre.der = nuevoHijo;
                    nuevoHijo.padre = busqueda.padre;
                    
                    }else{
                    busqueda.padre.izq = nuevoHijo;
                    nuevoHijo.padre = busqueda.padre;
                    }
                }
            }else if (cuantosHijos(busqueda) == 2){
                Nodo reemplazo = predecesorInmediato(busqueda.izq);
                
                busqueda.valor = reemplazo.valor;
                
                if(reemplazo.valor.compareTo(reemplazo.padre.valor) > 0){
                    reemplazo.padre.der = null;
                }else{
                    reemplazo.padre.izq = null;
                }
            }
        }
    }

    private int cuantosHijos(Nodo n){
        if (n.izq == null && n.der == null){
            return 0;

        }else if ((n.izq != null && n.der == null) || (n.izq == null && n.der != null)){
            return 1;

        }else{
            return 2;            
        }
        
    
    }

    private Nodo predecesorInmediato(Nodo n){
        if (n.der == null){
            return n;
        }else{
            return predecesorInmediato(n.der);
        }
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
