package aed;

public class Recordatorio {

    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = mensaje;
        _fecha = new Fecha(fecha.dia(), fecha.mes());
        _horario = horario;
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        return new Fecha(_fecha.dia(), _fecha.mes());
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
       String res = this.mensaje()+" @ "+ this.fecha().toString() + " " + this.horario().toString();
       return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean distintaClase = (otro.getClass() != this.getClass());

        if (distintaClase){
        return false;}

        Recordatorio otroRecordatorio = (Recordatorio) otro;

        boolean res = false;

        boolean mismoHorario = (this.horario().equals(otroRecordatorio.horario()));

        boolean mismaFecha = (this.fecha().equals(otroRecordatorio.fecha()));

        boolean mismoMensaje = (this.mensaje() == otroRecordatorio.mensaje());

        if(mismoHorario && mismaFecha && mismoMensaje){
            res = true;
        }

        return res;

    }

}
