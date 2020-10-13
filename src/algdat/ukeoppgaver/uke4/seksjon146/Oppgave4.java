package algdat.ukeoppgaver.uke4.seksjon146;

import algdat.hjelpeklasser.Tabell;

public class Oppgave4 {
    public static void main(String[] args) {
        Integer[] a = {2,3,5,3,1,9,5};

        System.out.println(Tabell.maks(a, Integer::compareTo));
    }
}
