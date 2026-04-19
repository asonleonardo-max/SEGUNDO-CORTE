package Ejercicio_5;

public class Torneo {
    Equipo cabeza;
    Equipo cola;

    public Torneo() {
        cabeza = null;
        cola = null;
    }

    public void agregarEquipo(Equipo equipo) {
        if (cabeza == null) {
            cabeza = equipo;
            cola = equipo;
            equipo.siguiente = cabeza;
        } else {
            cola.siguiente = equipo;
            equipo.siguiente = cabeza;
            cola = equipo;
        }
    }

    public void mostrarEquipos() {
        if (cabeza == null) {
            System.out.println("No hay equipos.");
            return;
        }

        Equipo actual = cabeza;
        do {
            System.out.println(actual.nombre + " - " + actual.ciudad +
                    " | Puntos: " + actual.puntos);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void generarFixture() {
        if (cabeza == null) {
            System.out.println("No hay equipos.");
            return;
        }

        int n = contarEquipos();

        if (n != 6) {
            System.out.println("Debe haber 6 equipos.");
            return;
        }

        int jornadas = n - 1;

        for (int j = 0; j < jornadas; j++) {
            System.out.println("\n--- Jornada " + (j + 1) + " ---");

            Equipo inicio = cabeza;
            Equipo fin = cola;

            for (int i = 0; i < n / 2; i++) {
                System.out.println(inicio.nombre + " vs " + fin.nombre);

                inicio.puntos += 1;
                fin.puntos += 1;

                inicio = inicio.siguiente;
                fin = obtenerAnterior(fin);
            }

            rotar();
        }
    }

    private void rotar() {
        if (cabeza == null || cabeza.siguiente == cabeza) return;

        Equipo segundo = cabeza.siguiente;

        cabeza.siguiente = segundo.siguiente;

        cola.siguiente = segundo;
        segundo.siguiente = cabeza;
        cola = segundo;
    }

    private Equipo obtenerAnterior(Equipo nodo) {
        Equipo actual = cabeza;

        while (actual.siguiente != nodo) {
            actual = actual.siguiente;
        }

        return actual;
    }

    private int contarEquipos() {
        int count = 0;
        Equipo actual = cabeza;

        do {
            count++;
            actual = actual.siguiente;
        } while (actual != cabeza);

        return count;
    }

    public void tablaPosiciones() {
        int n = contarEquipos();
        Equipo[] equipos = new Equipo[n];

        Equipo actual = cabeza;
        for (int i = 0; i < n; i++) {
            equipos[i] = actual;
            actual = actual.siguiente;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (equipos[j].puntos < equipos[j + 1].puntos) {
                    Equipo temp = equipos[j];
                    equipos[j] = equipos[j + 1];
                    equipos[j + 1] = temp;
                }
            }
        }

        System.out.println("\n--- Tabla de Posiciones ---");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + equipos[i].nombre +
                    " | Puntos: " + equipos[i].puntos);
        }
    }
}