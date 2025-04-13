package actividad_05_lab_04;

public class DpSolution {
    static int getValue(int[] values, int rodLength){
        int[] subSolutions = new int[rodLength + 1];
        subSolutions[0] = 0; // Valor base

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax;
        }

        return subSolutions[rodLength];
    }

    public static void main(String[] args){
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;
        System.out.println("El valor maximo:" + getValue(values, rodLength));
    }
}