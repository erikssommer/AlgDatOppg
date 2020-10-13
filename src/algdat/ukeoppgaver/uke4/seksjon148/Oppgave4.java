package algdat.ukeoppgaver.uke4.seksjon148;

import algdat.hjelpeklasser.Tabell;
import algdat.eksempelklasser.Komparator;

import java.util.Arrays;

public class Oppgave4 {
    public static void main(String[] args) {
        String[] s = {"21","18","8","13","20","6","16","25","3","10"};

        Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(String::toString));
        System.out.println(Arrays.toString(s));
    }
}
