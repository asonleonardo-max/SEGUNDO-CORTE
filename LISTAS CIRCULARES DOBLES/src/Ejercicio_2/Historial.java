package Ejercicio_2;

public class Historial {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Historial() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (cabeza == null) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }

        cursor = nuevo; 
    }

    public void arriba() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }
        cursor = cursor.anterior;
        mostrarCursor();
    }

    public void abajo() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }
        cursor = cursor.siguiente;
        mostrarCursor();
    }

    public void mostrarCursor() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("\n>> COMANDO ACTUAL:");
        System.out.println("   " + cursor.texto
                + " | " + (cursor.exitoso ? "OK" : "ERROR")
                + " | " + cursor.directorio);
    }

    public void eliminarActual() {
        if (estaVacio()) {
            System.out.println("Nada que eliminar.");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
            return;
        }

        
        Comando eliminar = cursor;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) cabeza = eliminar.siguiente;
        if (eliminar == cola) cola = eliminar.anterior;

        cursor = eliminar.siguiente;

        System.out.println("Comando eliminado.");
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("\n=== HISTORIAL COMPLETO ===");

        Comando actual = cabeza;
        int i = 1;

        do {
            if (actual == cursor) {
                System.out.println("" + i + ". " + actual.texto
                        + " | " + (actual.exitoso ? "OK" : "ERROR")
                        + " | " + actual.directorio);
            } else {
                System.out.println("   " + i + ". " + actual.texto
                        + " | " + (actual.exitoso ? "OK" : "ERROR")
                        + " | " + actual.directorio);
            }
            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}
