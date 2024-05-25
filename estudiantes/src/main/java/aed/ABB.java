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

            if (!(ultNodo.valor.equals(elem ))) {
            
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
        if(n.valor.equals(elem)){
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

        if (raiz != null){
        Nodo comparacion = ultimoNodoBuscado(raiz, elem);

        return (comparacion.valor.equals(elem));
        }
        else{
            return false;
        }
    }

    public void eliminar(T elem){
        Nodo busqueda = ultimoNodoBuscado(raiz,elem);

        if (busqueda.valor.equals(elem)){
            if(cuantosHijos(busqueda) == 0){

                if(busqueda.padre != null){
                    if(elem.compareTo(busqueda.padre.valor) > 0){
                        busqueda.padre.der = null;
                    }else{
                        busqueda.padre.izq = null;
                    }
                }else{
                    raiz = null;
                }

            }else if (cuantosHijos(busqueda) == 1){
                Nodo nuevoHijo;
                if (busqueda.izq != null){
                    nuevoHijo = busqueda.izq;
                    
                    if (busqueda.padre != null){
                        if (nuevoHijo.valor.compareTo(busqueda.padre.valor) > 0){
                            busqueda.padre.der = nuevoHijo;
                        }else{
                            busqueda.padre.izq = nuevoHijo;
                        }
                    }else{
                        raiz = nuevoHijo;
                    }
                }else {
                    nuevoHijo = busqueda.der;
                    
                   if (busqueda.padre != null){ 
                        if (nuevoHijo.valor.compareTo(busqueda.padre.valor) > 0){
                            busqueda.padre.der = nuevoHijo;
                        }else{
                            busqueda.padre.izq = nuevoHijo;
                        }
                    }else{
                        raiz = nuevoHijo;
                    }
                }
                nuevoHijo.padre = busqueda.padre;
            }else if (cuantosHijos(busqueda) == 2){
                Nodo reemplazo = predecesorInmediato(busqueda.izq);
                
                busqueda.valor = reemplazo.valor;

                if (busqueda.padre != null){
                    if(reemplazo.valor.compareTo(reemplazo.padre.valor) > 0){
                        reemplazo.padre.der = reemplazo.izq;
                        if(reemplazo.izq != null){
                            reemplazo.izq.padre = reemplazo.padre;
                        }
                    }else{
                        reemplazo.padre.izq = reemplazo.izq;
                        if(reemplazo.izq != null){
                        reemplazo.izq.padre = busqueda;
                        }
                    }
                }else{
                    if(reemplazo.valor.compareTo(reemplazo.padre.valor) > 0){
                        reemplazo.padre.der = reemplazo.izq;
                        if(reemplazo.izq != null){
                            reemplazo.izq.padre = reemplazo.padre;
                        }
                    }else{
                        reemplazo.padre.izq = reemplazo.izq;
                        if(reemplazo.izq != null){
                            reemplazo.izq.padre = busqueda;
                        }
                    }
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

    private String inOrder(Nodo n){
        String res="";

        if (n.izq != null && n.der != null){
            res =  inOrder(n.izq) + n.valor.toString()+"," + inOrder(n.der);

        }else if(n.izq != null && n.der == null){
            res = inOrder(n.izq) + n.valor.toString() + ",";
        
        }else if (n.der != null && n.izq == null){
            res = n.valor.toString() + "," + inOrder(n.der);
        
        }else{
            res = n.valor.toString() + ",";
        }


        return res;
    }

    public String toString(){
        String etapa1 = inOrder(this.raiz);
        String res = "{" + etapa1.substring(0, etapa1.length() -1) + "}";
        return res;

    }

    public Nodo sucesor(Nodo n){
        Nodo actual = n;
        if (n.der != null){           
            actual = n.der;

            while(actual.izq != null){
                actual = actual.izq;
            }
            return actual;
        }
        else if(n.padre != null){

            actual = actual.padre;

            while (n.valor.compareTo(actual.valor) > 0 && actual.padre != null){
                actual = actual.padre;
            }
            
            if(n.valor.compareTo(actual.valor) > 0){
                return n;
            }else{
                return actual;
            }

        }else{
            return n;
        }
    }

    public Nodo minimisimo(){
        Nodo actual = raiz;

        while (actual.izq != null){
            actual = actual.izq;
        }
        return actual;
    }

    public Nodo devuelveRaiz(){
        return this.raiz;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador(){
            _actual = raiz;

            while (_actual.izq != null){
                _actual = _actual.izq;
            }

        }

        public boolean haySiguiente() {            
            return sucesor(_actual) != _actual;
        }
    
        public T siguiente() {
            T res = _actual.valor;
            
            if(sucesor(_actual) != _actual){
            _actual = sucesor(_actual);
            }

            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
