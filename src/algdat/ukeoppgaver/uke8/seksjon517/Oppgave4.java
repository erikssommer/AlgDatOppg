package algdat.ukeoppgaver.uke8.seksjon517;

import algdat.hjelpeklasser.BinTre;

public class Oppgave4 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,6,7,12,13,26,27};
        String[] verdi = "ABCDEFGHI".split("");
        BinTre<String> tre = new BinTre<>(posisjon,verdi);
        tre.preorden((v,p) -> System.out.print("(" + v + "," + p + ") "));
    }
}
