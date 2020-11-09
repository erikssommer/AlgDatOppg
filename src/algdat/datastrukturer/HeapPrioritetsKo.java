package algdat.datastrukturer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class HeapPrioritetsKo<T> implements PrioritetsKo<T> {
    private T[] heap;
    private int antall;
    private Comparator<? super T> comp;

    @SuppressWarnings("unchecked")
    public HeapPrioritetsKo(int kapasitet, Comparator<? super T> comp) {
        if (kapasitet < 0) throw new IllegalArgumentException("Negativ kapasitet er ikke mulig");

        heap = (T[]) new Object[kapasitet + 1];
        antall = 0;
        this.comp = comp;
    }

    public HeapPrioritetsKo(Comparator<? super T> comp) {
        this(8, comp);
    }

    public static <T extends Comparable<? super T>> HeapPrioritetsKo<T> naturligOrden(int kapasitet) {
        return new HeapPrioritetsKo<>(kapasitet, Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> HeapPrioritetsKo<T> naturligOrden() {
        return naturligOrden(8);
    }

    @Override
    public void leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Verdi er null!");

        if (++antall == heap.length) heap = Arrays.copyOf(heap, 2 * antall);

        int k = antall;
        heap[0] = verdi;

        while (comp.compare(verdi, heap[k / 2]) < 0) {
            heap[k] = heap[k / 2];
            k /= 2;
        }
        heap[0] = null;
        heap[k] = verdi;
    }

    @Override
    public T kikk() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return heap[1];
    }

    @Override
    public T taUt() {
        return null;
    }

    @Override
    public boolean taUt(T verdi) {
        return false;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {
        for (int i = 0; i <= antall; i++) heap[i] = null;
        antall = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (antall > 0) sb.append(heap[1]);

        for (int i = 2; i <= antall; i++) sb.append(',').append(' ').append(heap[i]);

        sb.append(']');

        return sb.toString();
    }
}
