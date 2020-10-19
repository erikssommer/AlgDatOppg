package algdat.hjelpeklasser;

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

}
