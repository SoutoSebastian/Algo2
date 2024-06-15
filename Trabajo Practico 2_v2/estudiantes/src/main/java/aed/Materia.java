package aed;

public class Materia {
    private Tripla<ListaEnlazada<String>,int[],Trie<Carrera>> datosXmateria;

    public Materia(){
        ListaEnlazada<String> estudiantes = new ListaEnlazada<String>();
        int[] docentes = new int[4];
        Trie<Carrera> refACarrera = new Trie<Carrera>();

        datosXmateria = new Tripla<ListaEnlazada<String>,int[],Trie<Carrera>>(estudiantes, docentes, refACarrera);
    }
    public void agregarAlumno(String alumno){
        ListaEnlazada<String> alumnos = datosXmateria.getPrimero();

        alumnos.agregarAtras(alumno);
    }
    public int cantidadAlumnos(){
        ListaEnlazada<String> alumnos = datosXmateria.getPrimero();

        return alumnos.longitud();
    }
    public void agregarDocente(int docente){
        int[] docentes = datosXmateria.getSegundo();
        if(docente == 0){
           docentes[0] ++;
        }
        if(docente == 1){
            docentes[1] ++;
         }
         if(docente == 2){
            docentes[2] ++;
         }
         if(docente ==3){
            docentes[3] ++;
         }
        return;
    }

    public int[] getDocente(){
        int[] docentes = datosXmateria.getSegundo();
        return docentes;
    }

    public void insertarRefe(String nombreMateria,Carrera referencia){ //lo estoy definiendo verdaderamente? testear.
        Trie<Carrera> refe=datosXmateria.getTercero();
        refe.insertar(nombreMateria, referencia);                             
        
    }

    public Trie<Carrera> getRefe(){
        
        return datosXmateria.getTercero();
    }


    public boolean excedeCupoMateria(){
        boolean res = false;

        if(excedeCupoAY1() || excedeCupoAY2() || excedeCupoJTP() || excedeCupoProf()){
            res = true;
        }

        return res;
    }


    private boolean excedeCupoProf(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if((cantAlumnos/docentes[3]) >= 250){
            res = true;
        }

        return res;

    }


    private boolean excedeCupoJTP(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if((cantAlumnos/docentes[2]) >= 100){
            res = true;
        }

        return res;

    }


    private boolean excedeCupoAY1(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if((cantAlumnos/docentes[1]) >= 20){
            res = true;
        }

        return res;

    }


    private boolean excedeCupoAY2(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if((cantAlumnos/docentes[0]) >= 30){
            res = true;
        }

        return res;

    }

}