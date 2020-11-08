package algdat.hjelpeklasser;

import java.util.Iterator;

public interface Liste<T> extends Beholder<T> {
    public boolean leggInn(T verdi);

    public void leggInn(int indeks, T verdi);

    public boolean inneholder(T verdi);

    public T hent(int indeks);

    public int indeksTil(T verdi);

    public T oppdater(int indeks, T verdi);

    public boolean fjern(T verdi);

    public T fjern(int indeks);

    public int antall();

    public boolean tom();

    public void nullstill();

    public Iterator<T> iterator();

    public default String melding(int indeks) {
        return "Indeks: " + indeks + ", Antall: " + antall();
    }

    public default void indeksKontroll(int indeks, boolean leggInn) {
        if (indeks < 0 || (leggInn ? indeks > antall() : indeks >= antall())) {
            throw new IndexOutOfBoundsException(melding(indeks));
        }
    }
}
