package algdat.ukeoppgaver.uke9.seksjon521;

import algdat.hjelpeklasser.SBinTre;

import java.util.Comparator;

public class Oppgave1 {
    public static void main(String[] args) {
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        System.out.println(tre.antall() + " " + tre.tom());
    }
}
