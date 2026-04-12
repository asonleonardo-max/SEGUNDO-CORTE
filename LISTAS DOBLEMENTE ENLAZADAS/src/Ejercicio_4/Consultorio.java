package Ejercicio_4;

public class Consultorio {

    Paciente cabeza;
    Paciente cola;

    public Consultorio() {
        cabeza = null;
        cola = null;
    }

    //Agregamos al paciente
    public void agregarPaciente(Paciente nuevo) {

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            return;
        }

        if (nuevo.nivelUrgencia == 5) {

            nuevo.siguiente = cabeza.siguiente;
            nuevo.anterior = cabeza;

            if (cabeza.siguiente != null) {
                cabeza.siguiente.anterior = nuevo;
            }

            cabeza.siguiente = nuevo;

            if (cola == cabeza) {
                cola = nuevo;
            }

        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    //Aca se busca el paciente de mayor edad (de cola a cabeza)
    public void mayorEdad() {

        if (cola == null) {
            System.out.println("No hay pacientes.");
            return;
        }

        Paciente aux = cola;
        Paciente mayor = cola;

        while (aux != null) {
            if (aux.edad > mayor.edad) {
                mayor = aux;
            }
            aux = aux.anterior;
        }

        System.out.println("\n Paciente de mayor edad:");
        System.out.println("Nombre: " + mayor.nombre);
        System.out.println("Edad: " + mayor.edad);
        System.out.println("Urgencia: " + mayor.nivelUrgencia);
    }

    public void mostrar() {
        Paciente aux = cabeza;

        while (aux != null) {
            System.out.println(aux.nombre + " | Edad: " + aux.edad + " | Urgencia: " + aux.nivelUrgencia);
            aux = aux.siguiente;
        }
    }
}