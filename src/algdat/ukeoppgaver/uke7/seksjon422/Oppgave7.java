package algdat.ukeoppgaver.uke7.seksjon422;

import algdat.hjelpeklasser.Ko;
import algdat.hjelpeklasser.TabellKo;

public class Oppgave7 {
    public static void main(String[] args) {
        Ko<Character> k = new TabellKo<>();
        System.out.println(k);

        k.leggInn('A');
        k.leggInn('B');
        k.leggInn('C');

        System.out.println(k);
    }
}
