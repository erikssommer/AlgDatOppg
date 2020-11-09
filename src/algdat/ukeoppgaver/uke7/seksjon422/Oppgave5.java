package algdat.ukeoppgaver.uke7.seksjon422;

import algdat.datastrukturer.Ko;
import algdat.datastrukturer.Stakk;
import algdat.datastrukturer.TabellKo;
import algdat.datastrukturer.TabellStakk;

public class Oppgave5 {
    public static void main(String[] args) {
        Stakk<Character> s = new TabellStakk<>();
        Ko<Character> k = new TabellKo<>();

        s.leggInn('A');
        s.leggInn('B');
        s.leggInn('C');

        while (!s.tom()) k.leggInn(s.taUt());
        while (!k.tom()) s.leggInn(k.taUt());

        System.out.println(s);
    }
}
