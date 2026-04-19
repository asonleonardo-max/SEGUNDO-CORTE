package Ejercicio_5;

public class Equipo {
    String nombre;
    String ciudad;
    int puntos;
    int golesFavor;

    Equipo siguiente;

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.puntos = 0;
        this.golesFavor = 0;
    }
}