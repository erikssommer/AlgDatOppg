package algdat.ukeoppgaver.uke9.seksjon527;

import algdat.datastrukturer.SBinTre;

import java.util.stream.Stream;

public class Oppgave1 {
    public static void main(String[] args) {
        Integer[] a = {5,10,3,8,13,7,16,2,6,11};
        SBinTre<Integer> tre = SBinTre.sbintre(Stream.of(a));

        System.out.println(tre.gulv(10)); // Utskrift: 10
        System.out.println(tre.gulv(9)); // Utskrift: 8
        System.out.println(tre.gulv(1)); // Utskrift: null
    }
}
