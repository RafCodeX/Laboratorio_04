package ejercicio_01_lab_04;

import java.util.*;

public class SubPotenRst {
    // Función principal que inicia la búsqueda
    public static boolean PuedeFormarSuma(int[] arr, int sumaObjetivo) {
        int sumaObligatoria = 0;
        boolean[] incluir = new boolean[arr.length]; // marca qué elementos deben incluirse sí o sí

        // Paso 1: marcar potencias de 2 como obligatorias e ir sumando
        for (int i = 0; i < arr.length - 1; i++) {
            if (esPotenciaDe2(arr[i])) {
                incluir[i] = true;
                sumaObligatoria += arr[i];
            }
        }

        System.out.println("Suma obligatoria: " + sumaObligatoria);
        System.out.println("Incluir (potencias de 2): " + Arrays.toString(incluir));

        // Paso 2: si la suma obligatoria ya supera el target, no hay solución
        if (sumaObligatoria > sumaObjetivo) return false;

        // Paso 3: llamada recursiva para buscar combinación válida
        return buscarSuma(arr, incluir, 0, sumaObligatoria, sumaObjetivo);
    }

    // Función recursiva para explorar subconjuntos válidos
    private static boolean buscarSuma(int[] arr, boolean[] incluir, int index, int sumaActual, int objetivo) {
        if (sumaActual == objetivo) return true;
        if (sumaActual > objetivo || index >= arr.length - 1) return false;

        if (incluir[index]) {
            return buscarSuma(arr, incluir, index + 1, sumaActual, objetivo);
        }

        // Restricción corregida
        boolean puedeElegirse = true;
        if (arr[index] % 5 == 0 && index + 1 < arr.length && arr[index + 1] % 2 != 0) {
            puedeElegirse = false;
        }

        // Depuración (puedes comentar esto si ya todo funciona)
        System.out.println("Index: " + index + ", Valor: " + arr[index] + ", SumaActual: " + sumaActual + ", PuedeElegirse: " + puedeElegirse);

        boolean opcion1 = buscarSuma(arr, incluir, index + 1, sumaActual, objetivo); // no incluir
        boolean opcion2 = false;
        if (puedeElegirse) {
            opcion2 = buscarSuma(arr, incluir, index + 1, sumaActual + arr[index], objetivo); // incluir
        }

        return opcion1 || opcion2;
    }

    // Verifica si un número es potencia de 2
    private static boolean esPotenciaDe2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Método main con ejemplos
    public static void main(String[] args) {
        int[][] ejemplos = {
            {5, 4, 8, 10, 3, 5, 27},      
            {5, 4, 8, 10, 3, 6, 27},      
            {6, 2, 16, 5, 7, 10, 3, 33},   
            {6, 2, 16, 5, 3, 10, 7, 33},   
            {4, 2, 5, 1, 6, 13}            
        };

        for (int[] ejemplo : ejemplos) {
            int n = ejemplo[0];
            if (ejemplo.length < n + 2) {
                System.out.println("Ejemplo inválido: no tiene suficientes datos.");
                continue;
            }

            int[] arr = new int[n + 1];
            System.arraycopy(ejemplo, 1, arr, 0, n + 1);

            System.out.println("\nAnalizando arreglo: " + Arrays.toString(arr));
            boolean resultado = PuedeFormarSuma(arr, arr[n]);
            System.out.println("Resultado: " + resultado);
        }
    }
}


