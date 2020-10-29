package algdat.ukeoppgaver.uke9.seksjon525;

import algdat.hjelpeklasser.SBinTre;

public class Oppgave1 {
    public static void main(String[] args) {
        SBinTre<String> tre = SBinTre.balansert("ABCDDEFFGH".split(""));
        System.out.println(tre.antall() + " " + tre.hoyde() + " " + tre);
    }
}
