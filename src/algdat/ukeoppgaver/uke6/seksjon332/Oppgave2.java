package algdat.ukeoppgaver.uke6.seksjon332;

import algdat.hjelpeklasser.EnkeltLenketListe;

public class Oppgave2 {
    public static void main(String[] args) {

        EnkeltLenketListe<String> enkeltLenketListe = new EnkeltLenketListe<>();
        System.out.println(enkeltLenketListe.tom());
        enkeltLenketListe.leggInn("Ola");
        enkeltLenketListe.leggInn(1, "Pia");
        System.out.println(enkeltLenketListe.tom());
        System.out.println(enkeltLenketListe.toString());
        System.out.println(enkeltLenketListe.antall());
        enkeltLenketListe.nullstill();
        System.out.println(enkeltLenketListe.antall());
    }
}
