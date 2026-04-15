/*Planificador de CPU (Algoritmo Round Robin)
Los sistemas operativos usan el algoritmo Round Robin para repartir el tiempo del procesador entre varios procesos 
de forma justa: cada proceso recibe un pequeño intervalo de tiempo llamado quantum. Si no termina, espera su siguiente turno.

La Clase Proceso (Nodo): Debe contener nombre (String), pid (int), tiempoRestante (int) y prioridad (int - del 1 al 3).
El Problema: El planificador debe recorrer la lista circular en bucle. En cada turno, descuenta el quantum del tiempoRestante 
del proceso actual. Cuando tiempoRestante <= 0, el proceso termina y se elimina de la lista.
Reto: Implementa el método ejecutar(int quantum) que simule el planificador. Imprime en cada turno cuál proceso se está 
ejecutando, cuánto tiempo le queda y si terminó. El ciclo debe terminar cuando la lista quede vacía. Al final, imprime el orden 
en que terminaron los procesos.*/

package Ejercicio_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        PlanificadorCPU cpu = new PlanificadorCPU();

        do {
            System.out.println("\n=================================");
            System.out.println("   PLANIFICADOR ROUND ROBIN");
            System.out.println("=================================");
            System.out.println("1. Agregar proceso");
            System.out.println("2. Mostrar procesos");
            System.out.println("3. Ejecutar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sc.next();

                    System.out.println("PID: ");
                    int pid = sc.nextInt();

                    System.out.println("Tiempo restante: ");
                    int tiempo = sc.nextInt();

                    System.out.println("Prioridad (1-3): ");
                    int prioridad = sc.nextInt();

                    Proceso p = new Proceso(nombre, pid, tiempo, prioridad);
                    cpu.agregarProceso(p);
                    break;

                case 2:
                    cpu.mostrarProcesos();
                    break;

                case 3:
                    System.out.println("Quantum: ");
                    int q = sc.nextInt();
                    cpu.ejecutar(q);
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