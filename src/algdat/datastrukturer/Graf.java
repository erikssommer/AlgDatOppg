package algdat.datastrukturer;

import java.util.*;

public final class Graf implements Iterable<String> {

    private static final class Node{
        private final String navn;
        private final List<Node> kanter;
        private byte innkanter = 0;
        private boolean besokt = false;
        private Node forrige = null;

        private Node(String navn){
            this.navn = navn;
            kanter = new LinkedList<>();
        }

        public String toString(){
            return navn;
        }
    }

    private final Map<String, Node> noder;

    public Graf(){
        noder = new HashMap<>();
    }

    public boolean leggInnNode(String navn){
        if (navn == null || navn.length() == 0) throw new IllegalArgumentException("Noden må ha et navn!");
        if (noder.get(navn) != null) return false;
        return noder.put(navn, new Node(navn)) == null;
    }

    public boolean nodeFinnes(String navn){
        return noder.get(navn) != null;
    }

    public String getNavn(){
        return "Hei";
    }

    @Override
    public Iterator<String> iterator() {
        return noder.keySet().iterator();
    }

    public String[] nodenavn(){
        return noder.keySet().toArray(new String[0]);
    }



}
