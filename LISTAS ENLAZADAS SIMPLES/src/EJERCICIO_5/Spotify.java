package EJERCICIO_5;

import java.util.Scanner;

/*Spotify Lite (Lista de Reproducción)
Crea un reproductor de música simplificado que gestione una lista de canciones.

La Clase Cancion (Nodo): Debe contener titulo (String), artista (String), duracionSegundos (int) y genero (String).
El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS.*/

public class Spotify {
  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Playlist lista = new Playlist();

        int opcion;

        do {
            System.out.println("\n===== SPOTIFY LITE =====");
            System.out.println("1. Agregar canción al final");
            System.out.println("2. Agregar canción a continuación");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Duración total");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                    case 1:
                        System.out.println("=== Agregar canción al final ===");

                        System.out.print("Título: ");
                        String titulo1 = sc.nextLine();

                        System.out.print("Artista: ");
                        String artista1 = sc.nextLine();

                        System.out.print("Duración (segundos): ");
                        int duracion1 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Género: ");
                        String genero1 = sc.nextLine();

                        Cancion c1 = new Cancion(titulo1, artista1, duracion1, genero1);
                        lista.agregarAlFinal(c1);

                        System.out.println("Canción agregada al final.");
                        break;

                    case 2:
                        System.out.println("=== Agregar canción a continuación ===");

                        System.out.print("Título: ");
                        String titulo2 = sc.nextLine();

                        System.out.print("Artista: ");
                        String artista2 = sc.nextLine();

                        System.out.print("Duración (segundos): ");
                        int duracion2 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Género: ");
                        String genero2 = sc.nextLine();

                        Cancion c2 = new Cancion(titulo2, artista2, duracion2, genero2);
                        lista.agregarSiguiente(c2);

                        System.out.println("Canción agregada a continuación.");
                        break;

                    case 3:
                        lista.mostrarLista();
                        break;

                    case 4:
                        lista.duracionTotal();
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

        } while (opcion != 5);

        sc.close();
    }
}
