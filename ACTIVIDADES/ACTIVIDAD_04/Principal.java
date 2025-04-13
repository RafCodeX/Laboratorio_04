package actividad_04_lab_04;

public class Principal {
    public static void main(String[] args) {
        int[] arreglo = {9, 6, 7, 9, 3, 5, 2, 9, 1, 9};
        int moda = Moda.moda3(arreglo, 0, arreglo.length - 1);
        System.out.println("La moda del arreglo es ---> " + moda);
    }
}