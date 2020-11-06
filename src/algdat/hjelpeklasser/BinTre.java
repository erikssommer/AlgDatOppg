package algdat.hjelpeklasser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class BinTre<T> {
    private static final class Node<T>{
        private T verdi;
        private Node<T> venstre;
        private Node<T> hoyre;

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

    public BinTre(){
        rot = null;
        antall = 0;
    }

    public BinTre(int[] posisjon, T[] verdi){
        if (posisjon.length > verdi.length) throw new IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i], verdi[i]);
    }

    private Node<T> finnNode(int posisjon){
        if (posisjon < 1) return null;

        Node<T> p = rot;
        int filter = Integer.highestOneBit(posisjon >>= 1);

        for (; p != null && filter > 0; filter >>=1) p = (posisjon & filter) == 0 ? p.venstre : p.hoyre;

        return p;
    }

    public boolean finnes(int posisjon){
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon){
        Node<T> p = finnNode(posisjon);
        if (p == null) throw new IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi){
        Node<T> p = finnNode(posisjon);
        if (p == null) throw new IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        return gammelverdi;
    }

    public final void leggInn(int posisjon, T verdi){
        if (posisjon < 1) throw new IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot;
        Node<T> q = null;

        int filter = Integer.highestOneBit(posisjon) >> 1;

        while (p != null && filter > 0){
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.hoyre;
            filter >>= 1;
        }

        if (filter > 0) throw new IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);

        if (q == null) rot = p;
        else if ((posisjon & 1) == 0) q.venstre = p;
        else q.hoyre = p;

        antall++;
    }

    public int getAntall(){
        return antall;
    }

    public boolean tom(){
        return antall == 0;
    }

    public int nodetype(int posisjon){
        return 1;
    }

    public T fjern(int posisjon){
        if (posisjon < 1) throw new IllegalArgumentException("Posisjon k(" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;
        int n = Integer.highestOneBit(posisjon >> 1);

        while (p != null && n > 0) {
            q = p;
            p = (n & posisjon) == 0 ? p.venstre : p.hoyre;
            n >>= 1;
        }

        if (p == null) throw new IllegalArgumentException("Posisjon k(" + posisjon + ") er utenfor treet!");

        if (p.venstre != null || p.hoyre != null) throw new
                IllegalArgumentException("Posisjon k(" + posisjon + ") er ingen bladnode!");

        if (p == rot) rot = null;
        else if (p == q.venstre) q.venstre = null;
        else q.hoyre = null;

        antall--;
        return p.verdi;
    }

    //Bredde forst
    public void nivaOrden(){
        if (tom()) return;

        Ko<Node<T>> ko = new TabellKo<>();
        ko.leggInn(rot);

        while (!ko.tom()){
            Node<T> p = ko.taUt();
            System.out.print(p.verdi + " ");

            if (p.venstre != null) ko.leggInn(p.venstre);
            if (p.hoyre != null) ko.leggInn(p.hoyre);
        }
    }

    public void nivaOrden(Oppgave<? super T> oppgave){
        if (tom()) return;

        Ko<Node<T>> ko = new TabellKo<>();
        ko.leggInn(rot);

        while (!ko.tom()){
            Node<T> p = ko.taUt();
            oppgave.utforOppgave(p.verdi);

            if (p.venstre != null) ko.leggInn(p.venstre);
            if (p.hoyre != null) ko.leggInn(p.hoyre);
        }
    }

    public int[] nivaer(){
        if (tom()) return new int[0];

        int[] a = new int[8]; //Hjelpetabell
        Ko<Node<T>> ko = new TabellKo<>();
        int niva = 0;

        ko.leggInn(rot);

        while (!ko.tom()){
            if (niva == a.length) a = Arrays.copyOf(a,2*niva);
            int k = a[niva] = ko.antall();

            for (int i = 0; i < k; i++){
                Node<T> p = ko.taUt();
                if (p.venstre != null) ko.leggInn(p.venstre);
                if (p.hoyre != null) ko.leggInn(p.hoyre);
            }
            niva++;
        }
        return Arrays.copyOf(a,niva);
    }

    public boolean erMindre(Comparator<? super T> c){
        if (rot == null) return true;
        else return erMindre(rot, c);
    }

    public static <T> boolean erMindre(Node<T> p, Comparator<? super T> c){
        if (p.venstre != null){
            if (c.compare(p.venstre.verdi, p.verdi) < 0) return false;
            if (!erMindre(p.venstre, c)) return false;
        }
        if (p.hoyre != null){
            if (c.compare(p.hoyre.verdi, p.verdi) < 0) return false;
            return erMindre(p.hoyre, c);
        }
        return true;
    }

    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave){
        if (p != null){
            oppgave.utforOppgave(p.verdi);
            preorden(p.venstre, oppgave);
            preorden(p.hoyre, oppgave);
        }
    }

    public void preorden(Oppgave<? super T> oppgave){
        preorden(rot, oppgave);
    }

    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave){
        if (p.venstre != null) inorden(p.venstre, oppgave);
        oppgave.utforOppgave(p.verdi);
        if (p.hoyre != null) inorden(p.hoyre, oppgave);
    }

    public void inorden(Oppgave<? super T> oppgave){
        if (!tom()) inorden(rot, oppgave);
    }

    public T forstInorden(){
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (p.venstre != null) p = p.venstre;

        return p.verdi;
    }

    public T forstPostorden(){
        if (tom()) throw new NoSuchElementException("Treet er tomt");

        Node<T> p = rot;
        while (true){
            if (p.venstre != null) p = p.venstre;
            else if (p.hoyre != null) p = p.hoyre;
            else return p.verdi;
        }
    }

    private static <T> Node<T> trePreorden(T[] preorden, int rot, T[] inorden, int v, int h){
        if (v > h) return null;
        int k = v;
        T verdi = preorden[rot];

        while (!verdi.equals(inorden[k])) k++;

        Node<T> venstre = trePreorden(preorden,rot+1, inorden, v, k-1);
        Node<T> hoyre = trePreorden(preorden, rot+1+k-v, inorden, k+1,h);

        return new Node<>(verdi, venstre, hoyre);
    }

    public static <T> BinTre<T> trePreorden(T[] preorden, T[] inorden){
        BinTre<T> tre = new BinTre<>();
        tre.rot = trePreorden(preorden, 0, inorden, 0, inorden.length-1);

        tre.antall = preorden.length;
        return tre;
    }

    private static <T> void preorden(Node<T> p, int k, ObjIntConsumer<? super T> oppgave) {
        oppgave.accept(p.verdi, k);
        if (p.venstre != null) preorden(p.venstre, 2*k, oppgave);
        if (p.hoyre != null) preorden(p.hoyre, 2*k + 1, oppgave);
    }

    public void preorden(ObjIntConsumer<? super T> oppgave) {
        if (!tom()) preorden(rot, 1, oppgave);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> sj.add(x != null ? x.toString() : "null"));
        return sj.toString();
    }
}
