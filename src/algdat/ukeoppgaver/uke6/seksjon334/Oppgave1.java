package algdat.ukeoppgaver.uke6.seksjon334;

import algdat.datastrukturer.EnkeltLenketListe;

import java.util.Iterator;

public class Oppgave1 {
    public static void main(String[] args) {
        String[] s = {"Per","Kari","Ole"};
        EnkeltLenketListe<String> enkeltLenketListe = new EnkeltLenketListe<>(s);

        Iterator<String> i = enkeltLenketListe.iterator();

        System.out.println(i.next());
        i.remove();

        System.out.println(enkeltLenketListe);

        Iterator<String> k = enkeltLenketListe.iterator();
        System.out.println(k.next());

        enkeltLenketListe.fjern("Per");
        System.out.println(k.next());
    }
}
