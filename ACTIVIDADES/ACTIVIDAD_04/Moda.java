package actividad_04_lab_04;

public class Moda {
    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();
        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            int mediana = a[(p.prim + p.ult) / 2];
            int[] izq = new int[1];
            int[] der = new int[1];
            Utilidades.pivote2(a, mediana, p.prim, p.ult, izq, der);
            Limits p1 = new Limits(a, p.prim, izq[0] - 1);
            Limits p2 = new Limits(a, izq[0], der[0] - 1);
            Limits p3 = new Limits(a, der[0], p.ult);
            if (p1.length() > 0) heterogeneo.insertar(p1);
            if (p3.length() > 0) heterogeneo.insertar(p3);
            if (p2.length() > 0) homogeneo.insertar(p2);
        }
        if (homogeneo.esVacio()) {
            return a[prim];
        }
        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.a[p.prim];
    }
}
