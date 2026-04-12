package Ejercicio_2;

public class Galeria {

    Fotografia cabeza;
    Fotografia cola;

    public Galeria() {
        cabeza = null;
        cola = null;
    }

    // Aqui agregar la foto
    public void agregarFoto(Fotografia foto) {
        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    // Aqui avanza a la siguiente foto
    public Fotografia siguiente(Fotografia actual) {
        if (actual.siguiente == null) {
            System.out.println("Ya estás en la última foto.");
            return actual;
        }
        return actual.siguiente;
    }

    // Aqui retroceder a la foto anterios
    public Fotografia anterior(Fotografia actual) {
        if (actual.anterior == null) {
            System.out.println("Ya estás en la primera foto.");
            return actual;
        }
        return actual.anterior;
    }

    public void reproducirGaleria() {

        if (cabeza == null) {
            System.out.println("Galería vacía.");
            return;
        }

        System.out.println("\n--- Recorrido hacia ADELANTE ---");
        Fotografia aux = cabeza;

        while (aux != null) {
            mostrarFoto(aux);
            aux = aux.siguiente;
        }

        System.out.println("\n--- Recorrido hacia ATRÁS ---");
        aux = cola;

        while (aux != null) {
            mostrarFoto(aux);
            aux = aux.anterior;
        }
    }

    public void mostrarFoto(Fotografia f) {
        System.out.println("Archivo: " + f.nombreArchivo +
                           " | Tamaño: " + f.tamanoMB + "MB" +
                           " | Resolución: " + f.resolucion);
    }
}