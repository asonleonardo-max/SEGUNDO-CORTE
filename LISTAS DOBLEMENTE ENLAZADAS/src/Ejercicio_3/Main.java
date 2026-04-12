/*Navegación de Pestañas de Navegador
Imagina un navegador donde puedes moverte entre pestañas abiertas.

La Clase Pestana (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y 
el foco debe pasar a la pestaña anterior.
Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine
de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).*/

package Ejercicio_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Navegador nav = new Navegador();
        int opcion;

        do {
            System.out.println("\n====== NAVEGADOR ======");
            System.out.println("1. Abrir pestaña");
            System.out.println("2. Cerrar pestaña por URL");
            System.out.println("3. Mostrar pestañas");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("URL: ");
                    String url = sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    nav.abrirPestana(new Pestana(titulo, url, hora));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Ingrese URL a cerrar: ");
                    String cerrar = sc.nextLine();

                    nav.cerrarPestanaActual(cerrar);
                    break;

                case 3:
                    nav.mostrar();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
