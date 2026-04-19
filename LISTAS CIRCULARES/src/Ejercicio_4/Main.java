/*Gestión de Mesas en Restaurante (Lista de Espera Circular)
Un restaurante popular tiene un sistema de lista de espera. Cuando una mesa se libera, el siguiente grupo 
en espera ocupa el turno y pasa al final del ciclo por si quiere pedir la carta nuevamente (para clientes VIP).

La Clase Grupo (Nodo): Debe contener nombreReserva (String), numeroDPersonas (int), esVip (boolean) y minutosEsperando (int).
El Problema: Los grupos normales se atienden y salen de la lista. Los grupos VIP, al ser atendidos, vuelven al final de la lista circular
para una segunda ronda de atención. El sistema debe atender un grupo por turno.
Reto: Implementa el método atenderSiguiente() que tome el grupo de la cabeza, muestre su información, y 
si esVip == true, lo reinserté al final; si no, lo elimine. Muestra el estado de la lista después de cada atención. 
Llama al método 6 veces para simular la dinámica del restaurante.*/

package Ejercicio_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        Restaurante restaurante = new Restaurante();

        do {
            System.out.println("\n=================================");
            System.out.println("   Restaurante — Lista de Espera");
            System.out.println("=================================");
            System.out.println("1. Agregar grupo");
            System.out.println("2. Mostrar grupos");
            System.out.println("3. Atender siguiente");
            System.out.println("4. Simular 6 turnos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre de la reserva: ");
                    String nombre = sc.next();

                    System.out.print("Número de personas: ");
                    int personas = sc.nextInt();

                    System.out.print("¿Es VIP? (true/false): ");
                    boolean vip = sc.nextBoolean();

                    System.out.print("Minutos esperando: ");
                    int minutos = sc.nextInt();

                    Grupo nuevo = new Grupo(nombre, personas, vip, minutos);
                    restaurante.agregarGrupo(nuevo);
                    break;

                case 2:
                    System.out.println("Lista de grupos:");
                    restaurante.mostrarGrupos();
                    break;

                case 3:
                    restaurante.atenderSiguiente();
                    break;

                case 4:
                    for (int i = 1; i <= 6; i++) {
                        System.out.println("\nTurno " + i);
                        restaurante.atenderSiguiente();
                    }
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