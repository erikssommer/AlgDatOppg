package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.datastrukturer.TabellStakk;

public class Oppgave5 {
    public static void main(String[] args) {
        TabellStakk<String> a = new TabellStakk<>();
        TabellStakk<String> b = new TabellStakk<>();
        a.leggInn("Jens");
        a.leggInn("Jenny");
        a.leggInn("Per");
        a.leggInn("Nikko");

        System.out.println(a);
        TabellStakk.snu2(a);
        System.out.println(a);
    }
}
