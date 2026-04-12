package Ejercicio_5;

public class Reproductor {

    Cancion cabeza;
    Cancion cola;    
    Cancion actual;

    public Reproductor() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    // Agregar al final 
    public void agregarAlFinal(Cancion nueva) {

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    // Agregar la canción después de la actual
    public void agregarSiguiente(Cancion nueva) {

        if (actual == null) {
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = actual.siguiente;
            nueva.anterior = actual;

            if (actual.siguiente != null) {
                actual.siguiente.anterior = nueva;
            }

            actual.siguiente = nueva;

            if (actual == cola) {
                cola = nueva;
            }
        }
    }

    // Cambia la canción
    public void saltarAdelante() {

        if (actual == null) {
            System.out.println("No hay canciones.");
            return;
        }

        if (actual.siguiente == null) {
            System.out.println("Ya estás en la última.");
            return;
        }

        actual = actual.siguiente;
        mostrarActual();
    }

    // Retrocede a la canción anterior
    public void saltarAtras() {

        if (actual == null) {
            System.out.println("No hay canciones.");
            return;
        }

        if (actual.anterior == null) {
            System.out.println("Estás en la primera canción.");
            return;
        }

        actual = actual.anterior;
        mostrarActual();
    }

    // Mostrar actual
    public void mostrarActual() {
        System.out.println("Canción " + actual.titulo + " - " + actual.artista);
    }

    public void mostrarLista() {
        Cancion aux = cabeza;

        while (aux != null) {
            System.out.print("[" + aux.titulo + " | "
                    + aux.artista + " | "
                    + aux.duracionSegundos + " seg | "
                    + aux.genero + "] -> ");

            aux = aux.siguiente;
        }

        System.out.println("NULL");
    }
}