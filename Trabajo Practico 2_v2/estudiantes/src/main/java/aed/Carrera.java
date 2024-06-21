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

        datoMateria.agregarAlumno(estudiante);
    }


    public int cantidadInscriptosCarrera(String materia){

        Materia datoMateria = materias.obtener(materia);

        int res = datoMateria.cantidadAlumnos();

        return  res;
    }


    public void agregarDocenteCarrera(String materia, int docente){

        Materia datoMateria = materias.obtener(materia);

        datoMateria.agregarDocente(docente);
    }


    public int[] plantelDocenteCarrera(String materia){

        Materia datoMateria = materias.obtener(materia);

        int[] docentes = datoMateria.getDocente();

        return docentes;
    }

    public ListaEnlazada<String> getAlumnos(String materia){
        ListaEnlazada<String> alumnos = materias.obtener(materia).getAlumnos();
        return alumnos;
    }

    public ListaEnlazada<Tupla<String,Carrera>> getAlias(String materia){

        Materia datoMateria = materias.obtener(materia);
        ListaEnlazada<Tupla<String,Carrera>> listaAlias = datoMateria.getRefe();
        return listaAlias; 
    }

    public void borrarMateria(String materia){
        materias.borrar(materia);
    }


    public boolean excedeCupoCarrera(String materia){

        Materia datoMateria = materias.obtener(materia);

        boolean res = datoMateria.excedeCupoMateria();

        return res;
    }


    public String[] todasLasMaterias(){

        String[] res = materias.todasLasPalabras();
        return res;
    }


    public void cerrarMateria(String materia, Estudiantes estudiantes){
        Materia datoMateria = materias.obtener(materia);

        datoMateria.cerrarMateria(estudiantes);

    }



}
