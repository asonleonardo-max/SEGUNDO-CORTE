package Ejercicio_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria();
        int opcion;

        do {
            System.out.println("\n=================================");
            System.out.println("   Galería de Fotos");
            System.out.println("=================================");
            System.out.println("1. Agregar foto");
            System.out.println("2. Siguiente");
            System.out.println("3. Anterior");
            System.out.println("4. Toggle favorita");
            System.out.println("5. Eliminar foto actual");
            System.out.println("6. Mostrar galería");
            System.out.println("7. Cargar simulación");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();

                    galeria.agregarFoto(titulo, fecha);
                    break;

                case 2:
                    galeria.siguiente();
                    break;

                case 3:
                    galeria.anterior();
                    break;

                case 4:
                    galeria.toggleFavorita();
                    break;

                case 5:
                    galeria.eliminarActual();
                    break;

                case 6:
                    galeria.mostrarGaleria();
                    break;

                case 7:
                    galeria = new Galeria();

                    galeria.agregarFoto("Foto1", "2024-01-10");
                    galeria.agregarFoto("Foto2", "2024-02-15");
                    galeria.agregarFoto("Foto3", "2024-03-20");
                    galeria.agregarFoto("Foto4", "2024-04-05");
                    galeria.agregarFoto("Foto5", "2024-05-01");

                    // avanza 2 veces
                    galeria.siguiente();
                    galeria.siguiente();

                    // marcar favorita
                    galeria.toggleFavorita();

                    // retroceder 1
                    galeria.anterior();

                    // eliminar
                    galeria.eliminarActual();

                    // mostrar final
                    galeria.mostrarGaleria();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
