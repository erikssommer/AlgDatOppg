package algdat.datastrukturer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class TabellStakk<T> implements Stakk<T> {
    private T[] a;
    private int antall;

    public TabellStakk() {
        this(8);
    }

    @SuppressWarnings("unchecked")
    public TabellStakk(int lengde) {
        if (lengde < 0) {
            throw new IllegalStateException("Negativ tabellengde er ikke tillatt");
        }

        a = (T[]) new Object[lengde];
        antall = 0;
    }

    @Override
    public void leggInn(T verdi) {
        if (antall == a.length) {
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2 * antall);
        }
        a[antall++] = verdi;
    }

    @Override
    public T kikk() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom");
        }
        return a[antall - 1];
    }

    @Override
    public T taUt() {
        if (antall == 0) {
            throw new NoSuchElementException("Stakken er tom");
        }
        antall--;
        T temp = a[antall];
        a[antall] = null;

        return temp;
    }

    @Override
    public int antall() {
        return this.antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullstill() {
        for (int i = 0; i < antall; i++) {
            a[i] = null;
        }
        antall = 0;
    }

    public static <T> void snu(Stakk<T> A) {
        TabellStakk<T> B = new TabellStakk<>(A.antall());
        TabellStakk<T> C = new TabellStakk<>(A.antall());

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) C.leggInn(B.taUt());
        while (!C.tom()) A.leggInn(C.taUt());

    }

    public static <T> void snu2(Stakk<T> A) {
        TabellStakk<T> B = new TabellStakk<>();
        kopier(A, B);
        T temp;

        while (B.antall() > 0) {
            temp = B.taUt();
            A.leggInn(temp);
        }
    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        if (!B.tom()) {
            throw new IllegalArgumentException("Stakk B må være tom!");
        }

        TabellStakk<T> C = new TabellStakk<>(A.antall());
        T temp;

        while (A.antall() > 0) {
            temp = A.taUt();
            C.leggInn(temp);
        }

        while (C.antall() > 0) {
            temp = C.taUt();
            B.leggInn(temp);
        }
    }

    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        if (!B.tom()) {
            throw new IllegalArgumentException("Stakk B må være tom!");
        }
        snu(A);
        T temp;
        while (A.antall() > 0) {
            temp = A.taUt();
            B.leggInn(temp);
        }
    }

    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) {
        TabellStakk<T> B = new TabellStakk<>();
        kopier(A, B);

        while (!B.tom()) {
            T temp = B.kikk();
            B.taUt();

            while (!A.tom() && c.compare(A.kikk(), temp) < 0) {
                B.leggInn(A.kikk());
                A.taUt();
            }
            A.leggInn(temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (antall == 0) {
            return sb.append("[]").toString();
        }

        sb.append('[').append(a[antall - 1]);

        for (int i = antall - 2; i >= 0; i--) {
            sb.append(", ").append(a[i]);
        }

        return sb.append(']').toString();
    }
}
