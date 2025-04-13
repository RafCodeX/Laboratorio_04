package ejercicio_03_lab_04;

public class ViajeBarato {

    // Calcula la matriz de costos mínimos desde cada embarcadero hacia los demás
    public static int[][] CalcuCostos(int[][] tarifas) {
        int cantidad = tarifas.length;
        int[][] costos = new int[cantidad][cantidad];

        // Inicializamos la diagonal con 0 (ir del punto i al mismo punto tiene costo 0)
        for (int i = 0; i < cantidad; i++) {
            costos[i][i] = 0;
        }

        // Recorremos por distancias crecientes entre i y j
        for (int diferencia = 1; diferencia < cantidad; diferencia++) {
            for (int i = 0; i + diferencia < cantidad; i++) {
                int j = i + diferencia;

                // Suponemos inicialmente que el mejor costo es el directo
                costos[i][j] = tarifas[i][j];

                // Buscamos si existe un camino más barato haciendo escala en algún punto intermedio
                for (int intermedio = i + 1; intermedio < j; intermedio++) {
                    int costoConEscala = tarifas[i][intermedio] + costos[intermedio][j];
                    if (costoConEscala < costos[i][j]) {
                        costos[i][j] = costoConEscala;
                    }
                }
            }
        }

        return costos;
    }

    // Muestra una matriz en formato tabulado, con guiones para los valores no válidos
    public static void mostrarMatriz(int[][] matriz) {
        int n = matriz.length;
        System.out.println("Matriz de costos minimos entre embarcaderos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    System.out.print("-\t"); // no se puede viajar río arriba
                } else {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // Método principal de prueba
    public static void main(String[] args) {
        // Matriz triangular superior de tarifas
        int[][] tarifas = {
            {0, 3, 9, 100},
            {0, 0, 2, 6},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };

        // Cálculo de los costos mínimos
        int[][] costosMinimos = CalcuCostos(tarifas);

        // Mostrar los resultados
        mostrarMatriz(costosMinimos);

        // Ejemplo específico
        System.out.println("Costo mas economico desde el embarcadero 0 al 3: " + costosMinimos[0][3]);
    }
}
