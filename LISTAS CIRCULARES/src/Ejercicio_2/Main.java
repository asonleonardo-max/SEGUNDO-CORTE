/*Carrusel de Anuncios (Pantalla Digital)
Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente 
al primero.
La Clase Anuncio (Nodo): Debe contener titulo (String), duracionSegundos (int), vecesRepetido (int) y categoria
(String - ej: "Oferta", "Marca", "Evento").
El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando 
vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el tiempo 
total acumulado en pantalla.*/

package Ejercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Carrusel carrusel = new Carrusel();

        do {
            System.out.println("\n=================================");
            System.out.println("   CARRUSEL DE ANUNCIOS");
            System.out.println("=================================");
            System.out.println("1. Agregar anuncio");
            System.out.println("2. Mostrar anuncios");
            System.out.println("3. Reproducir");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Titulo: ");
                    String titulo = sc.next();

                    System.out.println("Duración (segundos): ");
                    int duracion = sc.nextInt();

                    System.out.println("Categoria: ");
                    String categoria = sc.next();

                    Anuncio a = new Anuncio(titulo, duracion, categoria);
                    carrusel.agregarAnuncio(a);
                    break;

                case 2:
                    carrusel.mostrarAnuncios();
                    break;

                case 3:
                    System.out.println("Número de ciclos: ");
                    int ciclos = sc.nextInt();
                    carrusel.reproducir(ciclos);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
