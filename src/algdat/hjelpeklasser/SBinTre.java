package algdat.hjelpeklasser;

import java.util.Comparator;
import java.util.Iterator;

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
}
