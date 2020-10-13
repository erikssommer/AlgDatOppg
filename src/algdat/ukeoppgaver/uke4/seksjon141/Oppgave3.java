package algdat.ukeoppgaver.uke4.seksjon141;

import algdat.hjelpeklasser.Tabell;

public class Oppgave3 {
    public static void main(String[] args) {
        Integer[] a = {5,2,3,9,1,9,10,6};
        int m = Tabell.maks(a);

        System.out.println(a[m]);
    }
}
