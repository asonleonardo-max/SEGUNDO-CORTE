package Ejercicio_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Consultorio lista = new Consultorio();

        int opcion;

        do {
            System.out.println("\n====== CONSULTORIO ======");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Paciente de mayor edad");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    System.out.print("Urgencia (1-5): ");
                    int urgencia = sc.nextInt();

                    lista.agregarPaciente(new Paciente(nombre, edad, urgencia));
                    break;

                case 2:
                    lista.mostrar();
                    break;

                case 3:
                    lista.mayorEdad();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
