package Ejercicio_1;

public class Participante {
    String nombre;
    int numeroBoleta;
    String ciudad;

    Participante siguiente; // Para formar la lista circular

    public Participante(String nombre, int numeroBoleta, String ciudad) {
        this.nombre = nombre;
        this.numeroBoleta = numeroBoleta;
        this.ciudad = ciudad;
    }
}
