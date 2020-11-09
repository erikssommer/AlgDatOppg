package algdat.ukeoppgaver.uke7.seksjon422;

import algdat.datastrukturer.TabellKo;

public class Oppgave8 {
    public static void main(String[] args) {
        TabellKo<Character> k = new TabellKo<>();

        k.leggInn('A');
        k.leggInn('B');
        k.leggInn('C');

        System.out.println(k.indeksTil('A'));
        System.out.println(k.indeksTil('B'));
        System.out.println(k.indeksTil('C'));
        System.out.println(k.indeksTil('S'));
    }
}
