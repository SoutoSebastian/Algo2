package aed;

public class Horario {

    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {

        Integer hora = (Integer) hora();
        Integer minutos = (Integer) minutos();

        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(hora.toString());
        sbuffer.append(":");
        sbuffer.append(minutos.toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = true;

        boolean oen = (otro == null);

        boolean distintaClase = (otro.getClass() != this.getClass());

        if (distintaClase){
        return false;}

        Horario otroHorario = (Horario) otro;

        boolean distintaHora = (hora() != otroHorario.hora());

        boolean distintoMinuto = (minutos() != otroHorario.minutos());

        if ( distintaHora || distintoMinuto || oen){

            res = false;
        }

        return res; 
    }

}
