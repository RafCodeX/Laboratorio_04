package ejercicio_02_lab_04;

import java.util.*;

public class KmPeque {

    // Función principal para encontrar el k-ésimo elemento más pequeño
    public static int encontrarKmenor(int[] arreglo, int k) {
        return DivideVenceras(arreglo, 0, arreglo.length - 1, k - 1); 
    }

    // Algoritmo QuickSelect (divide y vencerás)
    private static int DivideVenceras(int[] arreglo, int inicio, int fin, int k) {
        if (inicio == fin) return arreglo[inicio];

        int pivoteIndex = particionar(arreglo, inicio, fin);

        if (k == pivoteIndex) {
            return arreglo[k]; // encontramos el elemento deseado
        } else if (k < pivoteIndex) {
            return DivideVenceras(arreglo, inicio, pivoteIndex - 1, k); // buscar en la izquierda
        } else {
            return DivideVenceras(arreglo, pivoteIndex + 1, fin, k); // buscar en la derecha
        }
    }

    // Partición tipo QuickSort usando pivote aleatorio
    private static int particionar(int[] arreglo, int inicio, int fin) {
        int indicePivote = new Random().nextInt(fin - inicio + 1) + inicio;
        int pivote = arreglo[indicePivote];

        // mover el pivote al final
        intercambiar(arreglo, indicePivote, fin);

        int i = inicio;
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] < pivote) {
                intercambiar(arreglo, i, j);
                i++;
            }
        }

        // colocar el pivote en su posición final
        intercambiar(arreglo, i, fin);
        return i;
    }

    // Función para intercambiar dos valores en el arreglo
    private static void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    // Función main 
    public static void main(String[] args) {
        int[][] casos = {
            {4, 2, 7, 10, 4, 17}, 
            {4, 2, 7, 10, 4, 1, 6}, 
            {4, 2, 7, 1, 4, 6}, 
            {9, 2, 7, 1, 7} 
        };
        int[] ks = {3, 5, 1, 4};

        for (int i = 0; i < casos.length; i++) {
            int resultado = encontrarKmenor(casos[i], ks[i]);
            System.out.println("El " + ks[i] + " menor elemento es ----> " + resultado);
        }
    }
}