package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _secuenciaDeRecordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        _secuenciaDeRecordatorios = new Recordatorio[]{};

    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        _secuenciaDeRecordatorios = new Recordatorio[]{};

        for(int i = 0; i < vector._secuenciaDeRecordatorios.length; i++){       
            
            this.agregarAtras(vector._secuenciaDeRecordatorios[i]);

        }

    }

    public int longitud() {
        return _secuenciaDeRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        int nuevaLongitud = this.longitud() + 1;

        Recordatorio[] secuenciaVieja = _secuenciaDeRecordatorios;
        _secuenciaDeRecordatorios = new Recordatorio[nuevaLongitud];

        for(int j = 0; j < secuenciaVieja.length; j++ ){
            _secuenciaDeRecordatorios[j] = secuenciaVieja[j];
        }

        _secuenciaDeRecordatorios[nuevaLongitud - 1] = i;
    }

    public Recordatorio obtener(int i) {
        return _secuenciaDeRecordatorios[i];
    }

    public void quitarAtras() {
        int nuevaLongitud = this.longitud() - 1;

        Recordatorio[] secuenciaVieja = _secuenciaDeRecordatorios;
        _secuenciaDeRecordatorios = new Recordatorio[nuevaLongitud];

        for (int i = 0; i < _secuenciaDeRecordatorios.length; i++){
            _secuenciaDeRecordatorios[i] = secuenciaVieja[i];
        }
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        _secuenciaDeRecordatorios[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios res = new  ArregloRedimensionableDeRecordatorios();

        for (int i = 0; i < this.longitud(); i++){
            res.agregarAtras(_secuenciaDeRecordatorios[i]);
        }

        return res;
    }

}
