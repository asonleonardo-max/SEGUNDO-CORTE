package Ejercicio_4;

public class Galeria {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public Galeria() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nueva = new Foto(titulo, fecha);

        if (cabeza == null) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }

        actual = nueva; // última foto agregada
    }

    public void siguiente() {
        if (estaVacia()) {
            System.out.println("Galería vacía.");
            return;
        }
        actual = actual.siguiente;
        mostrarActual();
    }

    public void anterior() {
        if (estaVacia()) {
            System.out.println("Galería vacía.");
            return;
        }
        actual = actual.anterior;
        mostrarActual();
    }

    public void toggleFavorita() {
        if (estaVacia()) {
            System.out.println("Galería vacía.");
            return;
        }
        actual.esFavorita = !actual.esFavorita;
        System.out.println("Estado de favorita cambiado.");
        mostrarActual();
    }

    public void eliminarActual() {
        if (estaVacia()) {
            System.out.println("No hay fotos.");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
            return;
        }

        Foto eliminar = actual;
        actual = actual.siguiente;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) cabeza = eliminar.siguiente;
        if (eliminar == cola) cola = eliminar.anterior;

        System.out.println("Foto eliminada.");
    }

    public void mostrarActual() {
        if (estaVacia()) return;

        System.out.println("\n>> FOTO ACTUAL:");
        System.out.println("   " + actual.titulo +
                " (" + actual.fecha + ")" +
                (actual.esFavorita ? " ★" : ""));
    }

    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("Galería vacía.");
            return;
        }

        System.out.println("\n=== GALERÍA ===");

        Foto temp = cabeza;
        int i = 1;

        do {
            String actualMarca = (temp == actual) ? "[▶]" : "[ ]";
            String favMarca = temp.esFavorita ? "[★]" : "[ ]";

            System.out.println(actualMarca + " " + favMarca + " " + i + ". "
                    + temp.titulo + " (" + temp.fecha + ")");

            temp = temp.siguiente;
            i++;
        } while (temp != cabeza);
    }
}
