package Ejercicio_3;

public class PlanificadorCPU {
    Proceso cabeza;
    Proceso cola;

    public PlanificadorCPU() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarProceso(Proceso proceso) {
        if (cabeza == null) {
            cabeza = proceso;
            cola = proceso;
            proceso.siguiente = cabeza;
        } else {
            cola.siguiente = proceso;
            proceso.siguiente = cabeza;
            cola = proceso;
        }
    }

    public void mostrarProcesos() {
        if (cabeza == null) {
            System.out.println("No hay procesos.");
            return;
        }

        Proceso actual = cabeza;
        do {
            System.out.println("Nombre: " + actual.nombre +
                    ", PID: " + actual.pid +
                    ", Tiempo: " + actual.tiempoRestante +
                    ", Prioridad: " + actual.prioridad);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos.");
            return;
        }

        Proceso actual = cabeza;
        Proceso anterior = cola;

        System.out.println("\n=== EJECUCIÓN ROUND ROBIN ===");

        while (cabeza != null) {

            System.out.println("\nEjecutando: " + actual.nombre);

            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante > 0) {
                System.out.println("Tiempo restante: " + actual.tiempoRestante);
                anterior = actual;
                actual = actual.siguiente;
            } else {
                System.out.println("Proceso terminado: " + actual.nombre);

                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                    break;
                }

                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                    actual = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;

                    if (actual == cola) {
                        cola = anterior;
                    }

                    actual = actual.siguiente;
                }
            }
        }

        System.out.println("\nTodos los procesos terminaron.");
    }
}