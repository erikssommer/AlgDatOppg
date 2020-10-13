package algdat.ukeoppgaver.uke3.seksjon138;

import algdat.hjelpeklasser.Tabell;

public class Oppgave6 {
    public static void main(String[] args) {
        int[] gap = {1,4,10,23,57,132,301,701,1577,3548,7984,17965,40423,90952,204642};
        int[] a = Tabell.randPerm(200_000); // en tilfeldig tabell
        System.out.println(Tabell.erSortert(a)); // sjekker tabellen
        long tid = System.currentTimeMillis(); // starter klokken
        Tabell.innsettingssortering(a); // sorterer

        for (int i = gap.length - 1; i >= 0; i--){
            Tabell.shell(a,gap[i]);
        }

        System.out.println(System.currentTimeMillis() - tid); // tiden
        System.out.println(Tabell.erSortert(a)); // sjekker sorteringen
    }
}
