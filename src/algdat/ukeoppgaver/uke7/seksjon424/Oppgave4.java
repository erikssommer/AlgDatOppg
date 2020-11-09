package algdat.ukeoppgaver.uke7.seksjon424;

import algdat.datastrukturer.Tabell;
import algdat.datastrukturer.EnkeltLenketListe;
import algdat.datastrukturer.Ko;
import algdat.datastrukturer.Stakk;
import algdat.datastrukturer.TabellStakk;

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
