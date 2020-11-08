package algdat.hjelpeklasser;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EnkeltLenketListe<T> implements Liste<T>, Ko<T> {

    private static final class Node<T> {
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste) {
            this.verdi = verdi;
            this.neste = neste;
        }

        private Node(T verdi) {
            this.verdi = verdi;
            neste = null;
        }
    }

    private class EnkeltLenketListeIterator implements Iterator<T> {
        private Node<T> p = hode;
        private boolean fjernOK = false;
        private int iteratorendringer = endringer;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Ingen verdier!");
            }

            fjernOK = true;
            T denneVerdi = p.verdi;
            p = p.neste;

            return denneVerdi;
        }

        @Override
        public void remove() {
            if (!fjernOK) {
                throw new IllegalStateException("Ulovlig tilstand");
            }
            fjernOK = false;
            Node<T> q = hode;

            if (hode.neste == p) {
                hode = hode.neste;

                if (p == null) {
                    hale = null;
                }
            } else {
                Node<T> r = hode;

                while (r.neste.neste != p) {
                    r = r.neste;
                }

                q = r.neste;
                r.neste = p;

                if (p == null) {
                    hale = r;
                }

                q.verdi = null;
                q.neste = null;
                endringer++;
                iteratorendringer++;
                antall--;
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super T> handling) {
            Objects.requireNonNull(handling, "handling er null!");

            while (p != null) {
                handling.accept(p.verdi);
                p = p.neste;
            }
        }
    }

    private Node<T> hode;
    private Node<T> hale;
    private int antall;
    private int endringer;

    private Node<T> finnNode(int indeks) {
        Node<T> p = hode;
        for (int i = 0; i < indeks; i++) {
            p = p.neste;
        }
        return p;
    }

    public EnkeltLenketListe(T[] a) {
        this();

        hode = hale = new Node<>(null); //Midlertidig

        for (T verdi : a) {
            if (verdi != null) {
                hale = hale.neste = new Node<>(verdi);
                antall++;
            }
        }

        hode = (antall == 0) ? (hale = null) : hode.neste; //Fjerner den midlertidige noden
    }

    public EnkeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier");

        if (antall == 0) {
            hode = hale = new Node<>(verdi, null);
        } else {
            hale = hale.neste = new Node<>(verdi, null);
        }
        antall++;
        endringer++;
        return true;
    }

    @Override
    public T kikk() {
        if (tom()) throw new NoSuchElementException("Køen er tom");
        return hent(0);
    }

    @Override
    public T taUt() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return fjern(0);
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier");
        indeksKontroll(indeks, true); //true: index = antall er lovlig

        if (indeks == 0) {
            hode = new Node<>(verdi, hode);
            if (antall == 0) {
                hale = hode;
            }
        } else if (indeks == antall) {
            hale = hale.neste = new Node<>(verdi, null);
        } else {
            Node<T> p = hode;
            for (int i = 1; i < indeks; i++) {
                p = p.neste;
            }
            p.neste = new Node<>(verdi, p.neste);
        }
        endringer++;
        antall++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) {
            return -1;
        }

        Node<T> p = hode;
        for (int i = 0; i < antall; i++) {
            if (p.verdi.equals(verdi)) {
                return i;
            }
            p = p.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier");
        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks);
        T gammelVerdi = p.verdi;
        p.verdi = verdi;

        endringer++;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }

        Node<T> q = hode;
        Node<T> p = null;

        while (q != null) {
            if (q.verdi.equals(verdi)) {
                break;
            }
            p = q;
            q = q.neste;
        }

        if (q == null) {
            return false;
        } else if (q == hode) {
            hode = hode.neste;
        } else {
            p.neste = q.neste;
        }

        if (q == hale) {
            hale = p;
        }

        q.verdi = null;
        q.neste = null;

        antall--;
        endringer++;
        return true;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        T temp;
        if (indeks == 0) {
            temp = hode.verdi;
            hode = hode.neste;

            if (antall == 1) {
                hale = null;
            }
        } else {
            Node<T> p = finnNode(indeks - 1);
            Node<T> q = p.neste;
            temp = q.verdi;

            if (q == hale) {
                hale = p;
            }

            p.neste = q.neste;
        }

        antall--;
        endringer++;
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
        Node<T> p = hode, q;

        while (p != null) {
            q = p.neste;
            p.neste = null;
            p.verdi = null;
            p = q;
        }

        hode = hale = null;
        antall = 0;
        endringer++;
    }

    @Override
    public void forEach(Consumer<? super T> handling) {
        Objects.requireNonNull(handling, "Handling er null!");

        Node<T> p = hode;
        while (p != null) {
            handling.accept(p.verdi);
            p = p.neste;
        }
    }

    @Override
    public boolean fjernHvis(Predicate<? super T> predikat) {
        Objects.requireNonNull(predikat, "null-predikat!");

        Node<T> p = hode, q = null;
        int antallFjernet = 0;

        while (p != null) {
            if (predikat.test(p.verdi)) {
                antallFjernet++;

                if (p == hode) {
                    if (p == hale) hale = null;
                    hode = hode.neste;
                } else if (p == hale) {
                    q.neste = null;
                } else {
                    q.neste = p.neste;
                }
            }
            q = p;
            p = p.neste;
        }

        if (antallFjernet > 0) {
            endringer++;
        }

        antall -= antallFjernet;

        return antallFjernet > 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new EnkeltLenketListeIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append('[');

        if (!tom()) {
            Node<T> p = hode;
            s.append(p.verdi);

            p = p.neste;

            while (p != null) {
                s.append(',').append(' ').append(p.verdi);
                p = p.neste;
            }
        }

        s.append(']');

        return s.toString();
    }

    //Trenger forbedringer. Funker ikke helt som den skal
    public static <T> void sorter(Ko<T> ko, Stakk<T> stakk, Comparator<? super T> c) {
        kopier(ko, stakk);

        while (!stakk.tom()) {
            T temp = stakk.kikk();
            stakk.taUt();

            while (!ko.tom() && c.compare(ko.kikk(), temp) < 0) {
                stakk.leggInn(ko.kikk());
                ko.taUt();
            }
            ko.leggInn(temp);
        }
    }

    public static <T> void kopier(Ko<T> A, Stakk<T> B) {
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
}
