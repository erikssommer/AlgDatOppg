package algdat.ukeoppgaver.uke9.seksjon523;

import algdat.datastrukturer.SBinTre;

import java.util.Comparator;
import java.util.stream.Stream;

public class Oppgave2 {
    public static void main(String[] args) {
        Integer[] a = {8,2,10,1,6,9,14,4,7,12,15,3,5,11,13};

        SBinTre<Integer> tre1 = SBinTre.sbintre(Stream.of(a));
        SBinTre<Integer> tre2 = SBinTre.sbintre(Stream.of(a), Comparator.reverseOrder());

        System.out.println(tre1 + "\n" + tre2);
    }
}
