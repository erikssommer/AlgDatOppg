package algdat.ukeoppgaver.uke13;

import algdat.hjelpeklasser.RSBinTre;
import algdat.hjelpeklasser.Tabell;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(10);
        RSBinTre<Integer> tre = RSBinTre.rsbintre();

        for (int k : a) tre.leggInn(k);
        System.out.println(tre); // bruker toString-metoden

        for (int k : tre) System.out.print(k + " "); // bruker iteratoren
        tre.nullstill();

        for (int k = 1; k <= 1_000_000; k++) tre.leggInn(k);
        System.out.println("\n" + tre.hoyde()); // treets høyde
    }
}
