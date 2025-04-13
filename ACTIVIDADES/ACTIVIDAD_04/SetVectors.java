package actividad_04_lab_04;

import java.util.*;
public class SetVectors {
    private List<Limits> set = new ArrayList<>();
    public void insertar(Limits p) {
        set.add(p);
    }
    public Limits mayor() {
        Limits max = null;
        for (Limits l : set) {
            if (max == null || l.length() > max.length()) {
                max = l;
            }
        }
        set.remove(max);
        return max;
    }
    public int longMayor() {
        int max = 0;
        for (Limits l : set) {
            max = Math.max(max, l.length());
        }
        return max;
    }
    public boolean esVacio() {
        return set.isEmpty();
    }
    public void destruir() {
        set.clear();
    }
}