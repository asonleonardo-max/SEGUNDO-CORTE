/*Editor de Capas (Diseño Gráfico)
Los editores gráficos organizan el diseño en capas. El usuario navega a la capa superior (siguiente) o inferior (anterior) y 
puede ocultar o mostrar cada capa. La estructura es circular: después de la capa más alta vuelve a la más baja.

La Clase Capa (Nodo): Debe contener nombre (String), visible (boolean) y tipo (String — "fondo", "objeto", "texto").
El Problema: El editor mantiene un puntero capaActiva a la capa seleccionada. El usuario puede moverse entre capas, alternar la visibilidad
de la activa y eliminarla (el foco pasa a la siguiente).
Reto: Implementa los métodos subirCapa(), bajarCapa(), toggleVisibilidad(), eliminarActiva() y mostrarCapas(). mostrarCapas() imprime todas
las capas marcando la activa con [✓] e indicando si cada una es visible. Simula: crea 4 capas, activa la del medio, sube una vez, 
oculta la activa, elimínala y muestra el estado final.*/

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

                    editor.bajarCapa();

                    editor.subirCapa();

                    editor.toggleVisibilidad();

                    editor.eliminarActiva();

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
