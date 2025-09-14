import java.util.Arrays;
import java.util.Random;

public class Semana05_Busquedas {

    public static int busquedaLineal(int[] arr, int valor) {
        int comparaciones = 0;
        for (int i = 0; i < arr.length; i++) {
            comparaciones++;
            if (arr[i] == valor) {
                System.out.println("Búsqueda Lineal: valor encontrado en la posición " + i);
                System.out.println("Comparaciones realizadas: " + comparaciones);
                return i;
            }
        }
        System.out.println("Búsqueda Lineal: valor NO encontrado");
        System.out.println("Comparaciones realizadas: " + comparaciones);
        return -1;
    }

    public static int busquedaBinaria(int[] arr, int valor) {
        int comparaciones = 0;
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            comparaciones++;
            if (arr[medio] == valor) {
                System.out.println("Búsqueda Binaria: valor encontrado en la posición " + medio);
                System.out.println("Comparaciones realizadas: " + comparaciones);
                return medio;
            } else if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        System.out.println("Búsqueda Binaria: valor NO encontrado");
        System.out.println("Comparaciones realizadas: " + comparaciones);
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arreglo = new int[20];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(100);
        }

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arreglo));

        int[] arregloOrdenado = arreglo.clone();
        Arrays.sort(arregloOrdenado);
        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(arregloOrdenado));

        int numeroSi = arregloOrdenado[5];
        int numeroNo = 150;

        System.out.println("\n== Probando número que SÍ está: " + numeroSi + " ==");
        busquedaLineal(arreglo, numeroSi);
        busquedaBinaria(arregloOrdenado, numeroSi);

        System.out.println("\n== Probando número que NO está: " + numeroNo + " ==");
        busquedaLineal(arreglo, numeroNo);
        busquedaBinaria(arregloOrdenado, numeroNo);
    }
}
