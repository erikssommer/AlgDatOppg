package algdat.hjelpeklasser;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TabellListe<T> implements Liste<T> {
    private T[] a;
    private int antall;
    private int endringer;

    private class TabellListeIterator implements Iterator<T> {
        private int denne = 0;
        private boolean fjernOK = false;
        private int iteratorendringer = endringer;

        @Override
        public boolean hasNext() {
            return denne < antall;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Listen er endret!");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            }

            T denneVerdi = a[denne];
            denne++;
            fjernOK = true;

            return denneVerdi;
        }

        @Override
        public void remove() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Listen er endret!");
            }

            if (!fjernOK) {
                throw new IllegalStateException("Ulovlig tilstand!");
            }

            fjernOK = false;
            antall--;
            denne--;

            System.arraycopy(a, denne + 1, a, denne, antall - denne);
            a[antall] = null;

            endringer++;
            iteratorendringer++;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            while (hasNext()) {
                action.accept(next());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public TabellListe(int storrelse) {
        this.a = (T[]) new Object[storrelse];
        this.antall = 0;
    }

    public TabellListe() {
        this(10);
    }

    public TabellListe(T[] b) {
        this(b.length);

        for (T verdi : b) {
            if (verdi != null) {
                a[antall++] = verdi;
            }
        }
    }

    public int antall() {
        return antall;
    }

    public boolean tom() {
        return antall == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void nullstill() {
        if (a.length > 10) {
            a = (T[]) new Object[10];
        } else {
            for (int i = 0; i < antall; i++) {
                a[i] = null;
            }
        }

        antall = 0;
        endringer++;
    }

    @Override
    public Iterator<T> iterator() {
        return new TabellListeIterator();
    }

    public T hent(int index) {
        indeksKontroll(index, false); // false: indeks = antall er ulovlig
        return a[index];
    }

    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (a[i].equals(verdi)) {
                return i; //Funnet
            }
        }
        return -1; //Ikke funnet
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig");
        indeksKontroll(indeks, false); // false: indeks = antall er ulovlig

        T gammelverdi = a[indeks];
        a[indeks] = verdi;
        endringer++;
        return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig");

        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(verdi)) {
                fjern(i);
                endringer++;
                return true;
            }
        }
        return false;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);
        T verdi = a[indeks];

        antall--;
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        a[antall] = null;
        endringer++;

        return verdi;
    }

    /*
    public boolean fjernHvis(Predicate<? super T> p){
        Objects.requireNonNull(p);

        boolean fjernet = false;
        for (int i = antall-1; i >= 0; i--){
            if (a[i].equals(p)){
                fjern(i);
                fjernet = true;
            }
        }
        return fjernet;
    }

     */

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);

        if (antall == a.length) {
            a = Arrays.copyOf(a, (3 * antall) / 2 + 1);
        }

        a[antall++] = verdi;
        endringer++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulivlig");

        indeksKontroll(indeks, true); // true: indeks = antall er lovlig

        if (antall == a.length) {
            a = Arrays.copyOf(a, (3 * antall) / 2 + 1);
        }

        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;
        antall++;
        endringer++;
    }

    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (antall == 0) {
            return sb.append("[]").toString();
        } else if (antall == 1) {
            return sb.append("[").append(a[0]).append("]").toString();
        }

        sb.append("[");

        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]).append(", ");
        }

        return sb.append(a[a.length - 1]).append("]").toString();
    }

}
