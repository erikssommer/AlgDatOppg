package algdat.ukeoppgaver.uke9.seksjon523;

import algdat.hjelpeklasser.SBinTre;

public class Oppgave1 {
    public static void main(String[] args) {
        SBinTre<Character> tre = SBinTre.sbintre();
        char[] verdi = "IEACBDGFHOMKJLN".toCharArray();

        for (char t : verdi) tre.leggInn(t);
        System.out.println(tre.antall());
    }
}
