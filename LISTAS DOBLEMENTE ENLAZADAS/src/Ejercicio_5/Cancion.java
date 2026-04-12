package Ejercicio_5;

public class Cancion {

    String titulo;
    String artista;
    int duracionSegundos;
    String genero;

    Cancion siguiente;
    Cancion anterior; 

    public Cancion(String titulo, String artista, int duracionSegundos, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
        this.genero = genero;
        this.siguiente = null;
        this.anterior = null;
    }
}