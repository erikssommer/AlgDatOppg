package algdat.ukeoppgaver.uke6.seksjon333;

import algdat.datastrukturer.EnkeltLenketListe;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] liste = {"Neo", "Pia", "Kasper", "Amalie"};
        EnkeltLenketListe<String> enkeltLenketListe = new EnkeltLenketListe<>(liste);
        System.out.println(enkeltLenketListe.fjern("Pia"));
        System.out.println(enkeltLenketListe.fjern("Eric"));
        System.out.println(enkeltLenketListe.toString());
    }
}
