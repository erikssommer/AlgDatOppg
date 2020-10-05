package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.hjelpeklasser.TabellStakk;

public class Oppgave2 {
    public static void main(String[] args) {
        TabellStakk<String> tabellStakk = new TabellStakk<>();
        tabellStakk.leggInn("Jens");
        tabellStakk.leggInn("Jenny");
        System.out.println(tabellStakk.toString());
    }
}
