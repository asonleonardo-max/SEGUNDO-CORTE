package EJERCICIO_3;

public class Vuelo {

    String numeroVuelo;
    String aerolinea;
    int combustibleRestante;
    int pasajeros;
    Vuelo siguiente;

    // Constructor completo
    public Vuelo(String numeroVuelo, String aerolinea, int combustibleRestante, int pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.combustibleRestante = combustibleRestante;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }
}
