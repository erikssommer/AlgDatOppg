package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.datastrukturer.TabellStakk;

public class Oppgave6 {
    public static void main(String[] args) {
        TabellStakk<String> a = new TabellStakk<>();
        TabellStakk<String> b = new TabellStakk<>();
        a.leggInn("Jens");
        a.leggInn("Jenny");
        a.leggInn("Per");
        a.leggInn("Nikko");

        System.out.println(a.toString());
        TabellStakk.kopier2(a, b);
        System.out.println(b.toString());
    }
}
