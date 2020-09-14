package algdat.uke3.seksjon134;

import static algdat.Tabell.*;

public class Oppgave5 {
    public static void main(String[] args) {
        int n = 100_000;
        long tid = 0;
        int[] a = randPerm(n);

        tid = System.currentTimeMillis();
        utvalgssortering(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Metoden utvalgssortering(): " + tid + " millisek");

        tid = System.currentTimeMillis();
        selectionSort(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Metoden selectionSort(): " + tid + " millisek");

        //Vi ser at metoden selectionSort() uten kall på metoder er "mye" raskere
    }
}
