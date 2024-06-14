package aed;

public class Carrera {
    private Trie<Materia> materias;
    
    public Carrera(){

        materias = new Trie<Materia>();
    } 

    public void agregarMateria(String materia, Materia datosMateria){

        materias.insertar(materia,datosMateria);
    }


    public void agregarAlumnoCarrera(String materia, String estudiante){
        
        Materia datoMateria = materias.obtener(materia);

        //datoMateria.agregarAlumno(estudiante);
    }


    public int cantidadInscriptosCarrera(String materia){

        Materia datoMateria = materias.obtener(materia);

        //int res = datoMateria.cantidadDeAlumnosMateria();

        return  1;//res;
    }


    public void agregarDocenteCarrera(String materia, int docente){

        Materia datoMateria = materias.obtener(materia);

        //datoMateria.agregarDocenteMateria(docente);
    }


    public int[] plantelDocenteCarrera(String materia){

        Materia datoMateria = materias.obtener(materia);

        //datoMateria.plantelDocenteMateria();

        return null;
    }


}
