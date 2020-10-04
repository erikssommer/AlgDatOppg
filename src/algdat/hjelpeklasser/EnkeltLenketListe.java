package algdat.hjelpeklasser;


import java.util.Iterator;
import java.util.Objects;

public class EnkeltLenketListe<T> implements Liste<T> {

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

    private Node<T> hode;
    private Node<T> hale;
    private int antall;

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
        return true;
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
        if (verdi == null){
            return -1;
        }

        Node<T> p = hode;
        for (int i = 0; i < antall; i++){
            if (p.verdi.equals(verdi)){
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

        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null){
            return false;
        }

        Node<T> q = hode;
        Node<T> p = null;

        while (q != null){
            if (q.verdi.equals(verdi)){
                break;
            }
            p = q;
            q = q.neste;
        }

        if (q == null){
            return false;
        }else if (q == hode){
            hode = hode.neste;
        }else {
            p.neste = q.neste;
        }

        if (q == hale){
            hale = p;
        }

        q.verdi = null;
        q.neste = null;

        antall--;
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
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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
}
