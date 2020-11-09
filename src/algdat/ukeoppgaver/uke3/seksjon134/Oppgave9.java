package algdat.ukeoppgaver.uke3.seksjon134;

import algdat.datastrukturer.Tabell;

import java.util.Arrays;

public class Oppgave9 {
    public static void main(String[] args) {
        int[] a = {15, 8, 21, 16, 5, 19, 7, 23, 10, 14, 3, 11, 6, 17, 4};
        Tabell.utvalgssortering(a, 4, 8); //Lagde denne metoden
        System.out.println(Arrays.toString(a));
    }
}
