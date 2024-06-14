package aed;

public class Materia {
    private Tripla<ListaEnlazada<String>,int[],Carrera> datosXmateria;
    

    public Materia(){
        ListaEnlazada<String> estudiantes = new ListaEnlazada<String>();
        int[] docentes = new int[3];
        Carrera refACarrera = null;

        datosXmateria = new Tripla<ListaEnlazada<String>,int[],Carrera>(estudiantes, docentes, refACarrera);
    }
}
