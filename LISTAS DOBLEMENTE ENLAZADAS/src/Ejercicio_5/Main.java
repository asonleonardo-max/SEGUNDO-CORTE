/*5. Reproductor de Música Premium
Mejora el ejercicio de Spotify de la semana pasada usando listas dobles.

La Clase Cancion (Nodo): Debe contener titulo (String), artista (String) y duracion (int).
El Problema: El reproductor ahora permite la función "Canción Anterior" de manera eficiente sin 
tener que recorrer toda la lista desde el principio.
Reto: Implementa un método saltarAtras() que retroceda una posición y saltarAdelante() que avance una. 
Si se intenta saltar atrás desde la primera canción, debe mostrar un mensaje de error.*/

package Ejercicio_5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Reproductor rep = new Reproductor();

        int opcion;

        do {
            System.out.println("\n====== REPRODUCTOR ======");
            System.out.println("1. Agregar canción");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Canción siguiente");
            System.out.println("4. Canción anterior");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.println("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.println("Artista: ");
                    String artista = sc.nextLine();

                    System.out.println("Duración (segundos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Género: ");
                    String genero = sc.nextLine();

                    rep.agregarAlFinal(new Cancion(titulo, artista, duracion, genero));
                    break;
                    
    

                case 2:
                    rep.mostrarLista();
                    break;

                case 3:
                    rep.saltarAdelante();
                    break;

                case 4:
                    rep.saltarAtras();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}