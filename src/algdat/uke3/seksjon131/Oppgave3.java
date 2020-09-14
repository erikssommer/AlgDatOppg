package algdat.uke3.seksjon131;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 9, 7, 10, 8, 6, 5, 2};

        for (int i = 0; i < 10; i++){
            Tabell.nestePermutasjon(a);
        }

        System.out.println(Arrays.toString(a));
    }
}
