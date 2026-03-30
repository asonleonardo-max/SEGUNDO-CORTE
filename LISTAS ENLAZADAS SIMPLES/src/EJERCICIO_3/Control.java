package EJERCICIO_3;

public class Control {
    Vuelo cabeza;

    public Control() {
        cabeza = null;
    }

    // Agregar vuelo
    public void agregarVuelo(Vuelo nuevo) {

        // Si tiene poco combustible → prioridad (inicio)
        if (nuevo.combustibleRestante < 10) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            // Si no → al final
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Vuelo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }

    // Mostrar cola de vuelos
    public void mostrarCola() {
        Vuelo actual = cabeza;

        while (actual != null) {
            System.out.print("[" + actual.numeroVuelo + " | " 
                    + actual.aerolinea + " | Comb: " 
                    + actual.combustibleRestante + " | Pasajeros: "
                    + actual.pasajeros + "] -> ");

            actual = actual.siguiente;
        }

        System.out.println("NULL");
    }

    // 🔥 Reto: mover vuelo al inicio (emergencia)
    public void reportarEmergencia(String numeroVuelo) {

        if (cabeza == null) {
            System.out.println("No hay vuelos.");
            return;
        }

        // Si ya está en cabeza
        if (cabeza.numeroVuelo.equals(numeroVuelo)) {
            System.out.println("El vuelo ya está en prioridad.");
            return;
        }

        Vuelo anterior = cabeza;
        Vuelo actual = cabeza.siguiente;

        while (actual != null) {

            if (actual.numeroVuelo.equals(numeroVuelo)) {

                // quitar de su posición
                anterior.siguiente = actual.siguiente;

                // mover al inicio
                actual.siguiente = cabeza;
                cabeza = actual;

                System.out.println("Vuelo " + numeroVuelo + " movido a emergencia.");
                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        System.out.println("Vuelo no encontrado.");
    }
}
