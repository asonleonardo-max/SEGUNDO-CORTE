package Ejercicio_3;

public class Navegador {

    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        cabeza = null;
        cola = null;
    }

    // Aqui abre una nueva pestaña
    public void abrirPestana(Pestana nueva) {

        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    public void cerrarPestanaActual(String url) {

        if (cabeza == null) {
            System.out.println("No hay pestañas abiertas.");
            return;
        }

        Pestana actual = cabeza;

        // Aqui se busca la pestaña
        while (actual != null && !actual.url.equals(url)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Pestaña no encontrada.");
            return;
        }

        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
        }

        else if (actual == cabeza) {
            cabeza = actual.siguiente;
            cabeza.anterior = null;
        }

        else if (actual == cola) {
            cola = actual.anterior;
            cola.siguiente = null;
        }

        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        System.out.println("Pestaña cerrada: " + actual.tituloPagina);
    }

    public void mostrar() {
        Pestana aux = cabeza;

        while (aux != null) {
            System.out.println(aux.tituloPagina + " | " + aux.url + " | " + aux.horaApertura);
            aux = aux.siguiente;
        }
    }
}