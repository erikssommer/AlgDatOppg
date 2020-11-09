package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.datastrukturer.TabellStakk;

public class Oppgave3 {
    public static void main(String[] args) {
        TabellStakk<String> a = new TabellStakk<>();
        TabellStakk<String> b = new TabellStakk<>();
        a.leggInn("Jens");
        a.leggInn("Jenny");

        System.out.println(a);
        TabellStakk.snu(a);
        System.out.println(a);
    }
}
