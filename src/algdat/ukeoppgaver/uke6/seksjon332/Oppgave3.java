package algdat.ukeoppgaver.uke6.seksjon332;

import algdat.datastrukturer.EnkeltLenketListe;

public class Oppgave3 {
    public static void main(String[] args) {
        Integer[] liste = {3,2,3,4,5,4,3,4,5,7,7};
        EnkeltLenketListe<Integer> enkeltLenketListe = new EnkeltLenketListe<>(liste);
        System.out.println(enkeltLenketListe.toString());
    }
}
