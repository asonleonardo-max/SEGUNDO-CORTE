package Ejercicio_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EditorCapas editor = new EditorCapas();
        int opcion;

        do {
            System.out.println("\n=================================");
            System.out.println("   Editor de Capas");
            System.out.println("=================================");
            System.out.println("1. Agregar capa");
            System.out.println("2. Subir capa");
            System.out.println("3. Bajar capa");
            System.out.println("4. Toggle visibilidad");
            System.out.println("5. Eliminar capa activa");
            System.out.println("6. Mostrar capas");
            System.out.println("7. Cargar simulación");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo (fondo/objeto/texto): ");
                    String tipo = sc.nextLine();

                    editor.agregarCapa(nombre, true, tipo);
                    break;

                case 2:
                    editor.subirCapa();
                    break;

                case 3:
                    editor.bajarCapa();
                    break;

                case 4:
                    editor.toggleVisibilidad();
                    break;

                case 5:
                    editor.eliminarActiva();
                    break;

                case 6:
                    editor.mostrarCapas();
                    break;

                case 7:
                    editor = new EditorCapas();

                    editor.agregarCapa("Fondo", true, "fondo");
                    editor.agregarCapa("Personaje", true, "objeto");
                    editor.agregarCapa("Texto", true, "texto");
                    editor.agregarCapa("Sombras", true, "objeto");

                    // activar la del medio (nos movemos manualmente)
                    editor.bajarCapa();

                    // sube una vez
                    editor.subirCapa();

                    // ocultar
                    editor.toggleVisibilidad();

                    // eliminar
                    editor.eliminarActiva();

                    // mostrar final
                    editor.mostrarCapas();
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
