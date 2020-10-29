package algdat.ukeoppgaver.uke9.seksjon522;

import algdat.hjelpeklasser.SBinTre;

import java.util.Comparator;

public class Oppgave2 {
    public static void main(String[] args) {
        SBinTre<Integer> tre1 = SBinTre.sbintre();
        SBinTre<Integer> tre2 = SBinTre.sbintre(Comparator.naturalOrder());

        System.out.println(tre1.antall() + " " + tre2.antall());

        SBinTre<String> tre3 = new SBinTre<>((s,t) -> s.length() - t.length());
    }
}
