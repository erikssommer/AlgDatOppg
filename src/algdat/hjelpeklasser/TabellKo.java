package algdat.hjelpeklasser;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringJoiner;

public class TabellKo<T> implements Ko<T> {

    private T[] a;
    private int fra;
    private int til;

    @SuppressWarnings("unchecked")
    public TabellKo(int lengde) {
        if (lengde < 1) {
            throw new IllegalArgumentException("Må ha positiv lengde");
        }

        a = (T[]) new Object[lengde];
        fra = til = 0;
    }

    public TabellKo() {
        this(8);
    }

    @Override
    public boolean leggInn(T verdi) {
        a[til] = verdi;
        til++;
        if (til == a.length) {
            til = 0;
        }
        if (fra == til) {
            a = utvidTabell(2 * a.length);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private T[] utvidTabell(int lengde) {
        T[] b = (T[]) new Object[lengde];
        System.arraycopy(a, fra, b, 0, a.length - fra);
        System.arraycopy(a, 0, b, a.length - fra, fra);
        fra = 0;
        til = a.length;
        return b;
    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        if (fra == til) {
            throw new NoSuchElementException("Køen er tom");
        }
        T temp = a[fra];
        a[fra] = null;
        fra++;
        if (fra == a.length) {
            fra = 0;
        }
        return temp;
    }

    @Override
    public int antall() {
        return fra <= til ? til - fra : a.length + til - fra;
    }

    @Override
    public boolean tom() {
        return til == fra;
    }

    @Override
    public void nullstill() {
        while (fra != til) {
            a[fra++] = null;
            if (fra == a.length) {
                fra = 0;
            }
        }
    }

    public int indeksTil(T verdi) {
        for (int i = fra; i < til; i++) {
            if (a[i] == verdi) {
                return i;
            }
        }
        return -1;
    }

    public static <T> void snu(Stakk<T> A) {

    }

    public static <T> void snu(Ko<T> A) {

    }

    @Override
    public String toString() {
        StringJoiner s = new StringJoiner(", ", "[", "]");

        for (int i = fra, k = til; i != k; i = (i + 1) % a.length) {
            s.add(a[i] == null ? "null" : a[i].toString());
        }

        return s.toString();
    }
}
