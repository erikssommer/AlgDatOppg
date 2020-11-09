package algdat.hjelpeklasser;

import java.util.Comparator;
import java.util.Iterator;

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
        return false;
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
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
