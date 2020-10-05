package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.hjelpeklasser.TabellStakk;

import java.util.Comparator;

public class Oppgave7 {
    public static void main(String[] args) {
        TabellStakk<Integer> tabellStakk = new TabellStakk<>();
        tabellStakk.leggInn(9);
        tabellStakk.leggInn(3);
        tabellStakk.leggInn(12);
        tabellStakk.leggInn(2);
        tabellStakk.leggInn(32);
        tabellStakk.leggInn(7);

        System.out.println(tabellStakk);
        TabellStakk.sorter(tabellStakk, Comparator.naturalOrder());
        System.out.println(tabellStakk);
    }
}
