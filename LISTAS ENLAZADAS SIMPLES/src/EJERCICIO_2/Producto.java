package EJERCICIO_2;

public class Producto {

    String nombre;
    int cantidad;
    int diasParaVencer;
    Producto siguiente;

    // Constructor completo
    public Producto(String nombre, int cantidad, int diasParaVencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }
}