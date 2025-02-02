package aed;

public class Agenda {

    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios _recordatorios;

    public Agenda(Fecha fechaActual) {
        this._fecha = fechaActual;
        this._recordatorios =  new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this._recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {

        String recordatoriosString = "";

        for(int i = 0; i < this._recordatorios.longitud() ; i++){
            
            if (this._recordatorios.obtener(i).fecha().equals(this._fecha)){

                recordatoriosString = recordatoriosString + this._recordatorios.obtener(i).toString() + "\n";
            
            }
        }

        String res = this._fecha.toString()+"\n"+"====="+"\n"+recordatoriosString;

        return res;

    }

    public void incrementarDia() {

        this._fecha.incrementarDia(); 

    }

    public Fecha fechaActual() {
        return this._fecha;
    }

}
