package algdat.ukeoppgaver.uke3.seksjon136;

import algdat.Tabell;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};

        System.out.println(Tabell.binaersokV1(a, 4));
        System.out.println(Tabell.binaersokV1(a, 7));
        System.out.println(Tabell.binaersokV1(a, 10));
        System.out.println(Tabell.binaersokV1(a, 15));
    }
}
