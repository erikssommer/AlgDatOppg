package algdat.ukeoppgaver.uke3.seksjon131;

import algdat.datastrukturer.Tabell;

import java.util.Arrays;

public class Oppgave1 {
    //Lagt metodene fra Programkode 1.3.1 a) og Programkode 1.3.1 b) i samleklassen Tabell.
    public static void main(String[] args) {
        int[] a = {3,1,4,9,7,10,8,6,5,2};
        Tabell.nestePermutasjon(a);
        System.out.println(Arrays.toString(a));
    }
}
