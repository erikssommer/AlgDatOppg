package algdat.ukeoppgaver.uke7.seksjon424;

import algdat.hjelpeklasser.Tabell;
import algdat.hjelpeklasser.EnkeltLenketListe;
import algdat.hjelpeklasser.Ko;
import algdat.hjelpeklasser.Stakk;
import algdat.hjelpeklasser.TabellStakk;

import java.util.Comparator;

public class Oppgave4 {
    public static void main(String[] args) {
        Integer[] a = Tabell.randPermInteger(10);

        Ko<Integer> ko = new EnkeltLenketListe<>();
        for (Integer i : a) ko.leggInn(i);
        System.out.println(ko);

        Stakk<Integer> stakk = new TabellStakk<>();

        EnkeltLenketListe.sorter(ko, stakk, Comparator.naturalOrder());
    }
}
