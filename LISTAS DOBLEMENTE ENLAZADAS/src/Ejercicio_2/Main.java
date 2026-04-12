package Ejercicio_2;


/*2. Carrusel de Imágenes (Galería Interactiva)
Simula el comportamiento de una galería de fotos en una aplicación móvil.

La Clase Fotografia (Nodo): Debe contener nombreArchivo (String), tamanoMB (double) y resolucion (String).
El Problema: El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, 
no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
Reto: Crea un método reproducirGaleria() que recorra toda la lista hacia adelante y luego toda la lista hacia 
atrás para mostrar todas las fotos.*/


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        Fotografia actual = null;

        int opcion;

        do {
            System.out.println("\n====== GALERÍA DE IMÁGENES ======");
            System.out.println("1. Agregar foto");
            System.out.println("2. Siguiente foto");
            System.out.println("3. Foto anterior");
            System.out.println("4. Reproducir galería");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tamaño (MB): ");
                    double tam = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Resolución: ");
                    String res = sc.nextLine();

                    Fotografia nueva = new Fotografia(nombre, tam, res);
                    galeria.agregarFoto(nueva);

                    if (actual == null) {
                        actual = nueva;
                    }

                    break;

                case 2:
                    if (actual != null) {
                        actual = galeria.siguiente(actual);
                        galeria.mostrarFoto(actual);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 3:
                    if (actual != null) {
                        actual = galeria.anterior(actual);
                        galeria.mostrarFoto(actual);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 4:
                    galeria.reproducirGaleria();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}