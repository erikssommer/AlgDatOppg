package algdat.ukeoppgaver.uke6.seksjon334;

import algdat.datastrukturer.EnkeltLenketListe;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] s = {"Per","Kari","Ole"};
        EnkeltLenketListe<String> enkeltLenketListe = new EnkeltLenketListe<>(s);

        enkeltLenketListe.fjernHvis(x -> x.equals("Kari"));
        enkeltLenketListe.forEach((System.out::println));
    }
}
