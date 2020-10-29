package algdat.hjelpeklasser;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class SBinTre<T> implements Beholder<T>{

    private static final class Node<T>{
        private T verdi;
        private Node<T> venstre, hoyre;

        private Node(T verdi, Node<T> venstre, Node<T> hoyre){
            this.verdi = verdi;
            this.venstre = venstre;
            this.hoyre = hoyre;
        }

        private Node(T verdi){
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

        while (p != null){
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
        return antall == 0;
    }

    @Override
    public void nullstill() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private void inorden(SBinTre.Node<T> p, Oppgave<? super T> oppgave){
        if (p.venstre != null) inorden(p.venstre, oppgave);
        oppgave.utforOppgave(p.verdi);
        if (p.hoyre != null) inorden(p.hoyre, oppgave);
    }

    public void inorden(Oppgave<? super T> oppgave){
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

    public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c){
        SBinTre<T> tre = new SBinTre<>(c);
        s.forEach(tre::leggInn);
        return tre;
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s){
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

    public int hoyde(){
        return hoyde(rot);  // kaller den private metoden
    }
}
