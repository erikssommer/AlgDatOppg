package algdat.ukeoppgaver.uke7.seksjon422;

import algdat.hjelpeklasser.Stakk;
import algdat.hjelpeklasser.TabellKo;
import algdat.hjelpeklasser.TabellStakk;

public class Oppgave9 {
    public static void main(String[] args) {
        Stakk<Character> k = new TabellStakk<>();

        k.leggInn('A');
        k.leggInn('B');
        k.leggInn('C');

        TabellKo.snu(k);
    }
}
