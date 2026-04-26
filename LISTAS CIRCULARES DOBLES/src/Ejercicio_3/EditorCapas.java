package Ejercicio_3;

public class EditorCapas {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public EditorCapas() {
        cabeza = null;
        cola = null;
        capaActiva = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarCapa(String nombre, boolean visible, String tipo) {
        Capa nueva = new Capa(nombre, visible, tipo);

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

        capaActiva = nueva; 
    }

    public void subirCapa() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }
        capaActiva = capaActiva.siguiente;
        mostrarActiva();
    }

    public void bajarCapa() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }
        capaActiva = capaActiva.anterior;
        mostrarActiva();
    }

    public void toggleVisibilidad() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }
        capaActiva.visible = !capaActiva.visible;
        System.out.println("Visibilidad cambiada.");
        mostrarActiva();
    }

    public void eliminarActiva() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            capaActiva = null;
            return;
        }

        Capa eliminar = capaActiva;
        capaActiva = capaActiva.siguiente;

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        if (eliminar == cabeza) cabeza = eliminar.siguiente;
        if (eliminar == cola) cola = eliminar.anterior;

        System.out.println("Capa eliminada.");
    }

    public void mostrarActiva() {
        if (estaVacio()) return;

        System.out.println("\n>> CAPA ACTIVA:");
        System.out.println("   " + capaActiva.nombre +
                " [" + capaActiva.tipo + "]" +
                " | " + (capaActiva.visible ? "VISIBLE" : "OCULTA"));
    }

    public void mostrarCapas() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        System.out.println("\n=== CAPAS ===");
        Capa actual = cabeza;
        int i = 1;

        do {
            String marca = (actual == capaActiva) ? "[✓]" : "[ ]";

            System.out.println(marca + " " + i + ". " + actual.nombre +
                    " [" + actual.tipo + "]" +
                    " | " + (actual.visible ? "VISIBLE" : "OCULTA"));

            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}
