package Ejercicio_4;

public class Restaurante {
    Grupo cabeza;
    Grupo cola;

    public Restaurante() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarGrupo(Grupo grupo) {
        if (cabeza == null) {
            cabeza = grupo;
            cola = grupo;
            grupo.siguiente = cabeza;
        } else {
            cola.siguiente = grupo;
            grupo.siguiente = cabeza;
            cola = grupo;
        }
    }

    public void mostrarGrupos() {
        if (cabeza == null) {
            System.out.println("No hay grupos.");
            return;
        }

        Grupo actual = cabeza;
        do {
            System.out.println("Reserva: " + actual.nombreReserva +
                    ", Personas: " + actual.numeroPersonas +
                    ", VIP: " + actual.esVip +
                    ", Espera: " + actual.minutosEsperando);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void atenderSiguiente() {
        if (cabeza == null) {
            System.out.println("No hay grupos para atender.");
            return;
        }

        Grupo actual = cabeza;

        System.out.println("\nAtendiendo: " + actual.nombreReserva +
                " | Personas: " + actual.numeroPersonas +
                " | VIP: " + actual.esVip);

        if (actual.esVip) {
            cabeza = cabeza.siguiente;
            cola = actual;
        } else {
            eliminarGrupo(actual);
        }

        System.out.println("Lista actual:");
        mostrarGrupos();
    }

    private void eliminarGrupo(Grupo grupo) {
        if (cabeza == grupo && cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (cabeza == grupo) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Grupo actual = cabeza;

            while (actual.siguiente != grupo) {
                actual = actual.siguiente;
            }

            actual.siguiente = grupo.siguiente;

            if (cola == grupo) {
                cola = actual;
            }
        }
    }
}