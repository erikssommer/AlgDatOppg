package algdat.ukeoppgaver.uke2.seksjon122;

import algdat.datastrukturer.Tabell;

public class Oppgave2 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);

        for (int k : a){
            System.out.print(k + " ");
        }

        int m = Tabell.maks(a);
        System.out.println("\nStørste verdi ligger på plass " + m);
    }
}
