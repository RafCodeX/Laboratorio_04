package actividad_04_lab_04;

public class Utilidades {
    public static void pivote2(int[] arr, int mediana, int prim, int ult, int[] izq, int[] der) {
        int i = prim, j = prim;
        while (i <= ult) {
            if (arr[i] < mediana) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        izq[0] = j;
        i = ult;
        j = ult;
        while (i >= izq[0]) {
            if (arr[i] > mediana) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i--;
        }
        der[0] = j + 1;
    }
}