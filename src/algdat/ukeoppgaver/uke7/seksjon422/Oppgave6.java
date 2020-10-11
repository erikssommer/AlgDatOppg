package algdat.ukeoppgaver.uke7.seksjon422;

import algdat.hjelpeklasser.Ko;
import algdat.hjelpeklasser.Stakk;
import algdat.hjelpeklasser.TabellKo;
import algdat.hjelpeklasser.TabellStakk;

public class Oppgave6 {
    public static void main(String[] args) {
        Ko<Character> k = new TabellKo<>();

        k.leggInn('A');
        k.leggInn('B');
        k.leggInn('C');


        System.out.println(k.antall());
        System.out.println(k.kikk());
        k.nullstill();
        System.out.println(k.tom());
    }
}
