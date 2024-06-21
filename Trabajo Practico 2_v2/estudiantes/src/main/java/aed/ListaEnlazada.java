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
        Nodo actual = this.primero;

        if(this.longitud() == 1){

            this.primero = null;
            this.ultimo = null;

        }else if (i==0){

            this.primero = actual.sig;
            actual.sig.ant = null;

        }else if(i == this.longitud()-1){

            this.ultimo = this.ultimo.ant;
            this.ultimo.sig = null;

        }else{

            for(int j=0; j<(this.longitud()); j++){
                
                if (j==i){
                    actual.ant.sig = actual.sig;
                    actual.sig.ant = actual.ant;
                } 

                actual = actual.sig;
            }
        }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;

        for(int j=0; j<this.longitud();j++){
            if (j==indice){
                actual.valor = elem;
            }

            actual = actual.sig;
        }
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<T>();
        
        for (int i=0; i<this.longitud();i++){
            nuevaLista.agregarAtras(this.obtener(i));
        }

        return nuevaLista;

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primero = null;
        ultimo = null;

        for (int i=0; i<lista.longitud();i++){
            this.agregarAtras(lista.obtener(i));
        }
        
    }

    public String[] anidarListaEnlazada(){
        Iterador<T> iterador = this.iterador();
        String[] res = new String[this.longitud()] ;
        //T[] res = new T[this.longitud()];                     // no se puede crear un array generico en java
        int i =0;
        while(iterador.haySiguiente()){
            res[i]= iterador.siguiente().toString();
            i++;
        }
 
        return res;
    }
    
    @Override
    public String toString() {
        String res = "[";

        for (int i = 0; i<(this.longitud()-1);i++){
            res = res + this.obtener(i).toString()+", ";
        }

        res = res + this.obtener(this.longitud()-1).toString() + "]";

        return res;
    }


    private class ListaIterador implements Iterador<T> {
            Nodo actual;

            public ListaIterador() {
                actual = primero;
            }

            public boolean haySiguiente() {
                if (primero == null) {
                    return false;
                }else{
                    return (actual.ant != ultimo) ;
                }
            }
            
            public boolean hayAnterior() {
                if (primero == null) {
                    return false;
                }else{
                    return (actual.ant != null);
                }    
            }

            public T siguiente() {
                if (actual != ultimo){
                    T res = actual.valor;
                    actual = actual.sig;
                    return res;
                }else{
                    T res = actual.valor;
                    actual = new Nodo();
                    actual.valor = null;
                    actual.ant = ultimo;
                    actual.sig = null;
                    return res;
                }
            }
            

            public T anterior() {
                actual = actual.ant;
                return actual.valor;
            }
        }

        public Iterador<T> iterador() {
            Iterador<T> nuevIterador = new ListaIterador();
            return nuevIterador;
        }

    }
 
