package aed;

public class Fecha {

    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        _dia = dia;
        _mes = mes;
    }

    public Fecha(Fecha fecha) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
        return _mes;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(dia().toString());
        sbuffer.append("/");
        sbuffer.append(mes().toString());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {

        boolean res = true;
        
        boolean oen = (otra == null);

        boolean mismaClase = (otra.getClass() != this.getClass());

        if (mismaClase){
        return false;}

        Fecha otraFecha = (Fecha) otra;

        boolean mismoMes = (mes() != otraFecha.mes());

        boolean mismoDia = (dia() != otraFecha.dia());

        if ( mismoMes || mismoDia || oen){

            res = false;
        }

        return res; 
    }

    
    public void incrementarDia() {
        if (diasEnMes(mes()) == dia()){
            if (mes() == 12){
            _dia = 1;
            _mes = 1;
            }else{
                _dia = 1;
                _mes = mes() + 1;
            }
        }else{
            _dia = dia() + 1;
        }

    }
    

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
