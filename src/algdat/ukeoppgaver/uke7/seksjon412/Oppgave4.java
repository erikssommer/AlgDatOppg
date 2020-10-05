package algdat.ukeoppgaver.uke7.seksjon412;

import algdat.hjelpeklasser.TabellStakk;

public class Oppgave4 {
    public static void main(String[] args) {
        TabellStakk<String> a = new TabellStakk<>();
        TabellStakk<String> b = new TabellStakk<>();
        a.leggInn("Jens");
        a.leggInn("Jenny");

        System.out.println(a.toString());
        TabellStakk.kopier(a, b);
        System.out.println(b.toString());
    }
}
