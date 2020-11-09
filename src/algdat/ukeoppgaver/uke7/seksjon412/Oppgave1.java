package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.datastrukturer.TabellStakk;

public class Oppgave1 {
    public static void main(String[] args) {
        TabellStakk<String> tabellStakk = new TabellStakk<>();
        tabellStakk.leggInn("Jens");
        tabellStakk.leggInn("Jenny");
        System.out.println(tabellStakk.antall());
        tabellStakk.nullstill();
        System.out.println(tabellStakk.antall());
    }
}
