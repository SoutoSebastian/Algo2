package aed;

public class Materia {
    private Tripla<ListaEnlazada<String>,int[],ListaEnlazada<Tupla<String,Carrera>>> datosXmateria;

    public Materia(){
        ListaEnlazada<String> estudiantes = new ListaEnlazada<String>();
        int[] docentes = new int[4];
        for(int i = 0; i<4; i++){
            docentes[i] = 0;
        }
        ListaEnlazada<Tupla<String,Carrera>> refACarrera = new ListaEnlazada<>();

        datosXmateria = new Tripla<ListaEnlazada<String>,int[],ListaEnlazada<Tupla<String,Carrera>>>(estudiantes, docentes, refACarrera);
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
        int[] nuevosDocentes = datosXmateria.getSegundo();
        if(docente == 0){
           nuevosDocentes[3] ++;
        }
        else if(docente == 1){
            nuevosDocentes[2] ++;
         }
         else if(docente == 2){
            nuevosDocentes[1] ++;
         }
         else{
            nuevosDocentes[0] ++;
         }

        
        
    }

    public ListaEnlazada<String> getAlumnos(){
        ListaEnlazada<String> alumnos = datosXmateria.getPrimero();
        return alumnos;
    }

    public int[] getDocente(){
        int[] docentes = datosXmateria.getSegundo();
        return docentes;
    }

    public void insertarRefe(String nombreMateria,Carrera referencia){ //lo estoy definiendo verdaderamente? testear.
        ListaEnlazada<Tupla<String,Carrera>> refe = datosXmateria.getTercero();
        Tupla<String,Carrera> tuplaDeCarreras = new Tupla<String,Carrera>(nombreMateria, referencia);

        refe.agregarAtras(tuplaDeCarreras);                             
        
    }

    public ListaEnlazada<Tupla<String,Carrera>> getRefe(){
        
        return datosXmateria.getTercero();
    }


    public boolean excedeCupoMateria(){
        boolean res = false;

        if(this.excedeCupoAY1() || this.excedeCupoAY2() || this.excedeCupoJTP() || this.excedeCupoProf()){
            res = true;
        }

        return res;
    }


    private boolean excedeCupoProf(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if(docentes[0] != 0){
            double cantAlumnosd = cantAlumnos;
            double cantDocentes = docentes[0];
            if((cantAlumnosd/cantDocentes) > 250){
                res = true;
            }
        }else{
            if(cantAlumnos>0){
                res = true;
            }
        }

        return res;

    }


    private boolean excedeCupoJTP(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if(docentes[1] != 0){
            double cantAlumnosd = cantAlumnos;
            double cantDocentes = docentes[1];
            if((cantAlumnosd/cantDocentes) > 100){
                res = true;
            }
        }else{
            if(cantAlumnos>0){
                res = true;
            }
        }

        return res;

    }


    private boolean excedeCupoAY1(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if(docentes[2] != 0){
            double cantAlumnosd = cantAlumnos;
            double cantDocentes = docentes[2];
            if((cantAlumnosd/cantDocentes) > 20){
                res = true;
            }
        }else{
            if(cantAlumnos>0){
                res = true;
            }
        }

        return res;

    }


    private boolean excedeCupoAY2(){

        int cantAlumnos = this.cantidadAlumnos();
        int[] docentes = this.getDocente();
        boolean res = false;

        if(docentes[3] != 0){
            double cantAlumnosd = cantAlumnos;
            double cantDocentes = docentes[3];
            if((cantAlumnosd/cantDocentes) > 30){
                res = true;
            }
        }else{
            if(cantAlumnos>0){
                res = true;
            }
        }

        return res;

    }

    public void cerrarMateria(Estudiantes estudiantes){

        ListaEnlazada<String> alumnos = this.getAlumnos();

        Iterador<String> it =  alumnos.iterador();

        while(it.haySiguiente()){
            String alumno = it.siguiente();
            estudiantes.desinscribirEnMateria(alumno);
        }


        ListaEnlazada<Tupla<String,Carrera>> ListaAlias = this.getRefe();
        
        Iterador<Tupla<String,Carrera>> it2 =  ListaAlias.iterador();
        
        while(it2.haySiguiente()){
            Tupla<String,Carrera> aliasIndividual = it2.siguiente();
            String alias = aliasIndividual.getPrimero();
            Carrera refCarrera = aliasIndividual.getSegundo();

            refCarrera.borrarMateria(alias);
        }


    }

}
