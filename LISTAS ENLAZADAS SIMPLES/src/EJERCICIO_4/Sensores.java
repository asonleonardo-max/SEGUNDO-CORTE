package EJERCICIO_4;

import java.util.Scanner;

/*Monitoreo Industrial (Sensores en Tiempo Real)
Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.

La Clase Lectura (Nodo): Debe contener idSensor (int), temperatura (double), presion (double) y hora (String).
El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
Reto: Implementa un método que busque y muestre la lectura con la temperatura más alta registrada en el historial.*/

public class Sensores {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Monitoreo sistema = new Monitoreo();

        int opcion;

        do {
            System.out.println("\n===== MONITOREO INDUSTRIAL =====");
            System.out.println("1. Agregar lectura");
            System.out.println("2. Mostrar lecturas");
            System.out.println("3. Temperatura más alta");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ID Sensor: ");
                    int id = sc.nextInt();

                    System.out.print("Temperatura: ");
                    double temp = sc.nextDouble();

                    System.out.print("Presión: ");
                    double pres = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    Lectura l = new Lectura(id, temp, pres, hora);
                    sistema.agregarLectura(l);

                    System.out.println("Lectura agregada.");
                    break;

                case 2:
                    sistema.mostrarLecturas();
                    break;

                case 3:
                    sistema.mayorTemperatura();
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
