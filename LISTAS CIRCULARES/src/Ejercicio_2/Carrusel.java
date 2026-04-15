package Ejercicio_2;

public class Carrusel {
    Anuncio cabeza;
    Anuncio cola;

    public Carrusel() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarAnuncio(Anuncio anuncio) {
        if (cabeza == null) {
            cabeza = anuncio;
            cola = anuncio;
            anuncio.siguiente = cabeza;
        } else {
            cola.siguiente = anuncio;
            anuncio.siguiente = cabeza;
            cola = anuncio;
        }
    }

    public void mostrarAnuncios() {
        if (cabeza == null) {
            System.out.println("No hay anuncios.");
            return;
        }

        Anuncio actual = cabeza;

        do {
            System.out.println("Titulo: " + actual.titulo +
                    ", Duración: " + actual.duracionSegundos +
                    ", Categoria: " + actual.categoria +
                    ", Veces: " + actual.vecesRepetido);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios.");
            return;
        }

        int tiempoTotal = 0;
        Anuncio actual = cabeza;

        for (int i = 0; i < ciclos; i++) {

            System.out.println("\n--- Ciclo " + (i + 1) + " ---");

            do {
                System.out.println("Mostrando: " + actual.titulo);

                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;

                actual = actual.siguiente;

            } while (actual != cabeza);
        }

        Anuncio masRepetido = cabeza;
        actual = cabeza.siguiente;

        do {
            if (actual.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = actual;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Anuncio más repetido: " + masRepetido.titulo +
                " (" + masRepetido.vecesRepetido + " veces)");
        System.out.println("Tiempo total en pantalla: " + tiempoTotal + " segundos");
    }
}