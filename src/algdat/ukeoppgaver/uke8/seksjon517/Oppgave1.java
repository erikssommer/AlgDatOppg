package algdat.ukeoppgaver.uke8.seksjon517;

import algdat.hjelpeklasser.BinTre;

import java.util.StringJoiner;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
        String[] verdi = "EIBGAHKLODNMCJF".split("");
        BinTre<String> tre = new BinTre<>(posisjon, verdi);
        StringJoiner s = new StringJoiner(", " ,"[", "]");
        tre.preorden(s::add);
        System.out.println(s);
    }
}
