import java.util.Scanner;

public class Interfaz {

    private ListaDeLaCompra listaDeLaCompra;

    // Constructor
    public Interfaz(String archivo) {
        listaDeLaCompra = new ListaDeLaCompra(archivo);
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.println("Para salir introduzca 0");
            System.out.println("Para ver un elemento introduzca la posición del elemento");
            opcionElegida = scanner.nextInt();
            if (opcionElegida != 0) {
                mostrarElemento(opcionElegida);
            }
        } while (opcionElegida != 0);

    }

    private void mostrarElemento(int indice) {
        System.out.println("El elemento número " + indice + " de la lista es " + listaDeLaCompra.obtenerElemento(indice));
    }
}
