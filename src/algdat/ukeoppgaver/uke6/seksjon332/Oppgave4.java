package algdat.ukeoppgaver.uke6.seksjon332;

import algdat.datastrukturer.EnkeltLenketListe;

public class Oppgave4 {
    public static void main(String[] args) {
        Integer[] liste = {3,2,3,5,4,6,8,4,3,7,8};
        EnkeltLenketListe<Integer> enkeltLenketListe = new EnkeltLenketListe<>(liste);
        System.out.println(enkeltLenketListe.toString());
        System.out.println(enkeltLenketListe.tom());
        enkeltLenketListe.leggInn(7);
        enkeltLenketListe.leggInn(1, 8);
        System.out.println(enkeltLenketListe.tom());
        System.out.println(enkeltLenketListe.toString());
        System.out.println(enkeltLenketListe.antall());
        enkeltLenketListe.nullstill();
        System.out.println(enkeltLenketListe.antall());
    }
}
