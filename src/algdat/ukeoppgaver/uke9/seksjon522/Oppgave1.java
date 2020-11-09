package algdat.ukeoppgaver.uke9.seksjon522;

import algdat.datastrukturer.SBinTre;

import java.util.Comparator;

public class Oppgave1 {
    public static void main(String[] args) {
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        System.out.println(tre.antall() + " " + tre.tom());
    }
}
