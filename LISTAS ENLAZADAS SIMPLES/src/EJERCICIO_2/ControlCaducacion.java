package EJERCICIO_2;

/*Inventario de Alimentos (Control de Caducidad)
Un supermercado necesita gestionar su estante de lácteos. Los productos que vencen más pronto deben colocarse al principio para ser vendidos primero.

La Clase Producto (Nodo): Debe contener nombre (String), cantidad (int) y diasParaVencer (int).
El Problema: Si llega un producto que vence en menos de 3 días, debe insertarse al inicio de la lista (prioridad de venta). Si vence en más tiempo, se pone al final.
Reto: Crea un método que imprima solo los productos que tienen menos de 5 días para vencer.*/


import java.util.Scanner;

public class ControlCaducacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inv = new Inventario();

        int opcion;

        do {
            System.out.println("\n===== MENÚ INVENTARIO =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Productos por vencer (<5 días)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Días para vencer: ");
                    int dias = sc.nextInt();

                    Producto p = new Producto(nombre, cantidad, dias);
                    inv.agregarProducto(p);

                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    System.out.println("\nInventario:");
                    inv.mostrarInventario();
                    break;

                case 3:
                    inv.productosPorVencer();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);

        sc.close();
    }
}