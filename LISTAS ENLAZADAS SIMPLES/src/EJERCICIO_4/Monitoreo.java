package EJERCICIO_4;

public class Monitoreo {

    Lectura cabeza;

    public Monitoreo() {
        cabeza = null;
    }

    // Agregar al inicio (más reciente primero)
    public void agregarLectura(Lectura nueva) {
        nueva.siguiente = cabeza;
        cabeza = nueva;
    }

    // Mostrar todas las lecturas
    public void mostrarLecturas() {
        Lectura actual = cabeza;

        while (actual != null) {
            System.out.print("[Sensor: " + actual.idSensor
                    + " | Temp: " + actual.temperatura
                    + " | Presión: " + actual.presion
                    + " | Hora: " + actual.hora + "] -> ");

            actual = actual.siguiente;
        }

        System.out.println("NULL");
    }

    // 🔥 Reto: encontrar la temperatura más alta
    public void mayorTemperatura() {

        if (cabeza == null) {
            System.out.println("No hay lecturas.");
            return;
        }

        Lectura actual = cabeza;
        Lectura mayor = cabeza;

        while (actual != null) {

            if (actual.temperatura > mayor.temperatura) {
                mayor = actual;
            }

            actual = actual.siguiente;
        }

        System.out.println("\n Lectura con mayor temperatura:");
        System.out.println("[Sensor: " + mayor.idSensor
                + " | Temp: " + mayor.temperatura
                + " | Presión: " + mayor.presion
                + " | Hora: " + mayor.hora + "]");
    }
}
