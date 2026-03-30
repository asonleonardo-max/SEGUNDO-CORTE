package EJERCICIO_2;

public class Inventario {

    Producto cabeza;

    public Inventario() {
        cabeza = null;
    }

    // Método para agregar productos
    public void agregarProducto(Producto nuevo) {

        // Si vence en menos de 3 días → al inicio
        if (nuevo.diasParaVencer < 3) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            // Si no → al final
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Producto actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }

    // Mostrar todos los productos
    public void mostrarInventario() {
        Producto actual = cabeza;

        while (actual != null) {
            System.out.print("[" + actual.nombre + " | Cant: " 
            + actual.cantidad + " | Vence en: " 
            + actual.diasParaVencer + " días] -> ");

            actual = actual.siguiente;
        }

        System.out.println("NULL");
    }

    public void productosPorVencer() {
        Producto actual = cabeza;

        System.out.println("\nProductos con menos de 5 días para vencer:");

        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("[" + actual.nombre + " | Cant: " 
                + actual.cantidad + " | Vence en: " 
                + actual.diasParaVencer + " días]");
            }
            actual = actual.siguiente;
        }
    }
}