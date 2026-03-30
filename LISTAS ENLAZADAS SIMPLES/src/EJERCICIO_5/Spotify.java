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
                case 2:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Duración (segundos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Género: ");
                    String genero = sc.nextLine();

                    Cancion c = new Cancion(titulo, artista, duracion, genero);

                    if (opcion == 1) {
                        lista.agregarAlFinal(c);
                    } else {
                        lista.agregarSiguiente(c);
                    }

                    System.out.println("Canción agregada.");
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
