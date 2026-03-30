package EJERCICIO_5;

public class Playlist {

    Cancion cabeza;
    Cancion actual; // canción en reproducción

    public Playlist() {
        cabeza = null;
        actual = null;
    }

    // Agregar al final
    public void agregarAlFinal(Cancion nueva) {
        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            Cancion aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nueva;
        }
    }

    // Agregar "a continuación" (después de la actual)
    public void agregarSiguiente(Cancion nueva) {
        if (actual == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = actual.siguiente;
            actual.siguiente = nueva;
        }
    }

    // Mostrar lista
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

    public void duracionTotal() {

        int totalSegundos = 0;
        Cancion aux = cabeza;

        while (aux != null) {
            totalSegundos += aux.duracionSegundos;
            aux = aux.siguiente;
        }

        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;

        System.out.println("\n⏱ Duración total: " 
                + minutos + ":" + String.format("%02d", segundos));
    }
}
