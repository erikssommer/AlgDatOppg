package algdat.hjelpeklasser;


import java.util.Iterator;
import java.util.Objects;

public class EnkeltLenketListe<T> implements Liste<T> {

    private static final class Node<T>{
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste){
            this.verdi = verdi;
            this.neste = neste;
        }

        private Node(T verdi){
            this.verdi = verdi;
            neste = null;
        }
    }

    private Node<T> hode;
    private Node<T> hale;
    private int antall;

    public EnkeltLenketListe(T[] a){
        this();

        hode = hale = new Node<>(null); //Midlertidig

        for (T verdi : a){
            if (verdi != null){
                hale = hale.neste = new Node<>(verdi);
                antall++;
            }
        }

        hode = (antall == 0) ? (hale = null) : hode.neste; //Fjerner den midlertidige noden
    }

    public EnkeltLenketListe(){
        hode = null;
        hale = null;
        antall = 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier");

        if (antall == 0){
            hode = hale = new Node<>(verdi, null);
        }else {
            hale = hale.neste = new Node<>(verdi, null);
        }
        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier");
        indeksKontroll(indeks, true); //true: index = antall er lovlig

        if (indeks == 0){
            hode = new Node<>(verdi, hode);
            if (antall == 0){
                hale = hode;
            }
        }else if (indeks == antall){
            hale = hale.neste = new Node<>(verdi, null);
        }else {
            Node<T> p = hode;
            for (int i = 1; i < indeks; i++){
                p = p.neste;
            }
            p.neste = new Node<>(verdi, p.neste);
        }

        antall++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return false;
    }

    @Override
    public T hent(int indeks) {
        return null;
    }

    @Override
    public int indeksTil(T verdi) {
        return 0;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public T fjern(int indeks) {
        return null;
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
    public String toString(){
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
