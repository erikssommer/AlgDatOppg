package algdat.hjelpeklasser;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RSBinTre<T> implements Beholder<T> {
    private static final boolean SVART = true;
    public static final boolean ROD = false;

    private static final class Node<T>{
        private T verdi;
        private Node<T> venstre;
        private Node<T> hoyre;
        private boolean farge;

        private Node(T verdi, Node<T> venstre, Node<T> hoyre, boolean farge){
            this.verdi = verdi;
            this.venstre = venstre;
            this.hoyre = hoyre;
            this.farge = farge;
        }
    }

    private final Node<T> NULL;
    private Node<T> rot;
    private int antall;
    private final Comparator<? super T> comp;

    public RSBinTre(Comparator<? super T> comp){
        rot = NULL = new Node<>(null, null, null, SVART);
        this.comp = comp;
    }

    //konstruksjonsmetoder
    public static <T extends Comparable<? super T>> RSBinTre<T> rsbintre(){
        return new RSBinTre<>(Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> RSBinTre<T> rsbintre(Comparator<? super T> comp){
        return new RSBinTre<>(comp);
    }

    @Override
    public boolean leggInn(T verdi) {
        if (rot == NULL){
            rot = new Node<>(verdi, NULL, NULL, SVART);
            antall++;
            return true;
        }
        Stakk<Node<T>> stakk = new TabellStakk<>();
        Node<T> p = rot;
        int cmp = 0;

        while (p != NULL){
            stakk.leggInn(p);
            cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.hoyre;
            else return false;
        }

        Node<T> x = new Node<>(verdi, NULL, NULL, ROD);
        antall++;

        Node<T> f = stakk.taUt();

        if (cmp < 0) f.venstre = x;
        else f.hoyre = x;

        if (f.farge == SVART) return true;

        Node<T> b = stakk.taUt();

        while (true){
            Node<T> t = (f == b.venstre) ? b.hoyre : b.venstre;

            if (t.farge == SVART) {
                b.farge = ROD;

                if (x == f.venstre) {
                    if (f == b.venstre) {
                        p = EHR(b);
                        f.farge = SVART;
                    } else {
                        p = DVR(b);
                        x.farge = SVART;
                    }
                } else {
                    if (f == b.venstre) {
                        p = DHR(b);
                        x.farge = SVART;
                    } else {
                        p = EVR(b);
                        f.farge = SVART;
                    }
                }
                if (b == rot) rot = p;
                else {
                    Node<T> q = stakk.taUt();
                    if (b == q.venstre) q.venstre = p;
                    else q.hoyre = p;
                }
                return true;
            }else {
                f.farge = t.farge = SVART;

                if (b == rot) return true;

                b.farge = ROD;

                Node<T> o = stakk.taUt();
                if (o.farge == SVART) return true;

                x = b;
                f = o;
                b = stakk.taUt();
            }
        }
    }

    private static <T> Node<T> EHR(Node<T> p)  // Enkel høyrerotasjon
    {
        Node<T> q = p.venstre;

        p.venstre = q.hoyre;
        q.hoyre = p;
        return q;
    }

    private static <T> Node<T> EVR(Node<T> p)  // Enkel venstrerotasjon
    {
        Node<T> q = p.hoyre;

        p.hoyre = q.venstre;
        q.venstre = p;
        return q;
    }

    private static <T> Node<T> DHR(Node<T> p)  // Dobbel høyrerotasjon
    {
        Node<T> q = p.venstre;
        Node<T> r = q.hoyre;

        q.hoyre = r.venstre;
        r.venstre = q;
        p.venstre = r.hoyre;
        r.hoyre = p;
        return r;
    }

    private static <T> Node<T> DVR(Node<T> p)  // Dobbel venstrerotasjon
    {
        Node<T> q = p.hoyre;
        Node<T> r = q.venstre;

        q.venstre = r.hoyre;
        r.hoyre = q;
        p.hoyre = r.venstre;
        r.venstre = p;
        return r;
    }

    @Override
    public boolean inneholder(T verdi) {
        for (Node<T> p = rot; p != NULL;){
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp > 0) p = p.hoyre;
            else if (cmp < 0) p = p.venstre;
            else return true;
        }
        return false;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {
        rot = NULL;
        antall = 0;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new InordenIterator();
    }

    private final class InordenIterator implements Iterator<T> {
        private final Stakk<Node<T>> s;
        private Node<T> p;

        private InordenIterator() {
            s = new TabellStakk<>();
            if (rot == NULL) p = NULL;     // tomt tre
            else p = forst(s,rot);
        }

        // den første i inorden i det treet som har p som rot
        private Node<T> forst(Stakk<Node<T>> s, Node<T> p) {
            while (p.venstre != NULL) {
                s.leggInn(p);
                p = p.venstre;
            }
            return p;
        }

        @Override
        public boolean hasNext() {
            return p != NULL;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T next(){  // neste er med hensyn på inorden
            if (p == NULL)
                throw new NoSuchElementException();

            T verdi = p.verdi;

            if (p.hoyre != NULL) p = forst(s,p.hoyre);
            else p = s.tom() ? NULL : s.taUt();
            return verdi;
        }
    }

    public int hoyde() {
        return hoyde(rot);
    }

    private int hoyde(Node<T> p) {
        if (p == NULL) return -1;
        return 1 + Math.max(hoyde(p.venstre), hoyde(p.hoyre));
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        if (!tom()) toString(rot,s);
        s.append(']');
        return s.toString();
    }

    private void toString(Node<T> p, StringBuilder s) {
        if (p.venstre != NULL) {
            toString(p.venstre, s);
            s.append(',').append(' ');
        }

        s.append(p.verdi);

        if (p.hoyre != NULL) {
            s.append(',').append(' ');
            toString(p.hoyre, s);
        }
    }
}
