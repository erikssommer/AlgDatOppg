package algdat.ukeoppgaver.uke3.seksjon131;

import algdat.datastrukturer.Tabell;

import java.util.Arrays;

public class Oppgave2 {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 1, 4, 5};
        int[] b = {2, 3, 6, 1, 5, 4};
        int[] c = {2, 3, 1, 6, 5, 4};
        int[] d = {2, 3, 6, 5, 4, 1};
        int[] e = {2, 6, 5, 4, 3, 1};

        Tabell.nestePermutasjon(a);
        Tabell.nestePermutasjon(b);
        Tabell.nestePermutasjon(c);
        Tabell.nestePermutasjon(d);
        Tabell.nestePermutasjon(e);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
    }
}
