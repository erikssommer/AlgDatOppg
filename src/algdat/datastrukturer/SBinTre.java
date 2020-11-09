package algdat.datastrukturer;

import java.util.*;
import java.util.stream.Stream;

public class SBinTre<T> implements Beholder<T> {

    private static final class Node<T> {
        private T verdi;
        private Node<T> venstre, hoyre;

        private Node(T verdi, Node<T> venstre, Node<T> hoyre) {
            this.verdi = verdi;
            this.venstre = venstre;
            this.hoyre = hoyre;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    private Node<T> rot;
    private int antall;
    private final Comparator<? super T> comp;

    public SBinTre(Comparator<? super T> comp) {
        this.rot = null;
        this.antall = 0;
        this.comp = comp;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Kan ikke ha nullverdier");

        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null) {
            q = p;
            cmp = comp.compare(verdi, p.verdi);
            p = cmp < 0 ? p.venstre : p.hoyre;
        }

        p = new Node<>(verdi);

        if (q == null) rot = p;
        else if (cmp < 0) q.venstre = p;
        else q.hoyre = p;

        antall++;
        return true;
    }

    @Override
    public boolean inneholder(T verdi) {
        if (verdi == null) {
            return false;
        }

        Node<T> p = rot;
        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.hoyre;
            else return true;
        }
        return false;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) return false;
        Node<T> p = rot, q = null; // q skal være forelder til p
        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) {
                q = p;
                p = p.venstre;
            } else if (cmp > 0) {
                q = p;
                p = p.hoyre;
            } else break; // den søkte verdien ligger i p
        }

        if (p == null) return false;

        if (p.venstre == null || p.hoyre == null) {
            Node<T> b = p.venstre != null ? p.venstre : p.hoyre;
            if (p == rot) rot = b;
            else if (p == q.venstre) q.venstre = b;
            else q.hoyre = b;
        } else {
            Node<T> s = p, r = p.hoyre;
            while (r.venstre != null) {
                s = r;
                r = r.venstre;
            }

            p.verdi = r.verdi;
            if (s != p) s.venstre = r.hoyre;
            else s.hoyre = r.hoyre;
        }
        antall--;
        return true;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullstill() {
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null;
        antall = 0;      // treet er nå tomt
    }

    private void nullstill(Node<T> p) {
        if (p.venstre != null) {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.hoyre != null) {
            nullstill(p.hoyre);        // høyre subtre
            p.hoyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public T min() {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (p.venstre != null) p = p.venstre;
        return p.verdi;
    }

    public T gulv(T verdi) {
        Objects.requireNonNull(verdi, "Treet har ingen nullverdier!");
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        T gulv = null;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre; // gulvet ligger til venstre
            else if (cmp > 0) {
                gulv = p.verdi;
                p = p.hoyre;
            } else return p.verdi;
        }
        return gulv;
    }

    public T storre(T verdi) {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");
        if (verdi == null) throw new NullPointerException("Ulovlig nullverdi!");

        Node<T> p = rot;
        T storre = null;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) {
                storre = p.verdi; // en kandidat
                p = p.venstre;
            } else {
                p = p.hoyre;
            }
        }
        return storre;
    }

    private void inorden(SBinTre.Node<T> p, Oppgave<? super T> oppgave) {
        if (p.venstre != null) inorden(p.venstre, oppgave);
        oppgave.utforOppgave(p.verdi);
        if (p.hoyre != null) inorden(p.hoyre, oppgave);
    }

    public void inorden(Oppgave<? super T> oppgave) {
        if (!tom()) inorden(rot, oppgave);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> sj.add(x != null ? x.toString() : "null"));
        return sj.toString();
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre() {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> sbintre(Comparator<? super T> c) {
        return new SBinTre<>(c);
    }

    public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c) {
        SBinTre<T> tre = new SBinTre<>(c);
        s.forEach(tre::leggInn);
        return tre;
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s) {
        return sbintre(s, Comparator.naturalOrder());
    }

    private static <T> Node<T> balansert(T[] a, int v, int h) {
        if (v > h) return null;
        int m = (v + h) / 2;
        T verdi = a[m];
        while (v < m && verdi.equals(a[m - 1])) m--;
        Node<T> p = balansert(a, v, m - 1);
        Node<T> q = balansert(a, m + 1, h);

        return new Node<>(verdi, p, q);
    }

    public static <T> SBinTre<T> balansert(T[] a, Comparator<? super T> c) {
        SBinTre<T> tre = new SBinTre<>(c);
        tre.rot = balansert(a, 0, a.length - 1);
        tre.antall = a.length;

        return tre;
    }

    public static <T extends Comparable<? super T>> SBinTre<T> balansert(T[] a) {
        return balansert(a, Comparator.naturalOrder());
    }

    private static int hoyde(Node<?> p) {      // ? betyr vilkårlig type

        if (p == null) return -1;        // et tomt tre har høyde -1
        return 1 + Math.max(hoyde(p.venstre), hoyde(p.hoyre));
    }

    public int hoyde() {
        return hoyde(rot);  // kaller den private metoden
    }
}
