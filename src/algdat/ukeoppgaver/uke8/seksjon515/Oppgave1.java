package algdat.ukeoppgaver.uke8.seksjon515;

import algdat.hjelpeklasser.BinTre;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,17,18,19,21,23,26,27,29};
        Character[] verdi = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'};

        BinTre<Character> tre = new BinTre<>(posisjon, verdi);

    }
}
