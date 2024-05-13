package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        private T valor;
        private Nodo ant;
        private Nodo sig;
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {

        int res = 1;

        if (this.primero == null){
            res = 0;
        }else{
            Nodo actual = this.primero;

            while (actual.sig != null){
            actual = actual.sig;
            res += 1; 
            } 
        }
        return res;

    }

    public void agregarAdelante(T elem) {

        Nodo nuevoPrimero = new Nodo();
        nuevoPrimero.valor = elem;
        nuevoPrimero.ant = null;
        
        if (this.longitud() == 0){

            nuevoPrimero.sig = null;
            this.ultimo = nuevoPrimero;
            this.primero = nuevoPrimero;
        }else{

            this.primero.ant = nuevoPrimero;
            nuevoPrimero.sig = this.primero;
            this.primero = nuevoPrimero;
        }

    }

    public void agregarAtras(T elem) {
        Nodo nuevoUltimo = new Nodo();
        nuevoUltimo.valor = elem;
        nuevoUltimo.sig = null;

        if (this.longitud() == 0){
            
            nuevoUltimo.ant = null;
            this.primero = nuevoUltimo;
            this.ultimo = nuevoUltimo;

        }else{
            this.ultimo.sig = nuevoUltimo;
            nuevoUltimo.ant = this.ultimo;
            this.ultimo = nuevoUltimo;}
        }

    public T obtener(int i) {
        Nodo actual = this.primero;

        for(int j=0; j!=i; j++){
            actual = actual.sig;
        }

        return actual.valor;
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
