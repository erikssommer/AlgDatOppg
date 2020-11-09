package algdat.ukeoppgaver.uke6.seksjon333;

import algdat.datastrukturer.EnkeltLenketListe;

public class Oppgave2 {
    public static void main(String[] args) {
        Integer[] liste = {3,2,3,5,4,6,8,4,3,7,8};
        EnkeltLenketListe<Integer> enkeltLenketListe = new EnkeltLenketListe<>(liste);

        System.out.println(enkeltLenketListe.indeksTil(2));
        System.out.println(enkeltLenketListe.inneholder(3));
    }
}
