package algdat.ukeoppgaver.uke6.seksjon325;

import algdat.hjelpeklasser.Liste;
import algdat.hjelpeklasser.TabellListe;

import java.util.Iterator;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] s = {"Per","Kari","Ole"};
        Liste<String> liste = new TabellListe<>();

        for (String navn : s) {
            liste.leggInn(navn);
        }

        Iterator<String> i = liste.iterator();
        Iterator<String> j = liste.iterator();

        System.out.println(i.next());
        i.remove();
        System.out.println(j.next());

        System.out.println(liste);

        Iterator<String> k = liste.iterator();
        System.out.println(k.next());

        liste.fjern("Per");
        System.out.println(k.next());
    }
}
