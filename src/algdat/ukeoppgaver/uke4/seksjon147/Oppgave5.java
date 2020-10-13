package algdat.ukeoppgaver.uke4.seksjon147;

import algdat.hjelpeklasser.Tabell;
import algdat.eksempelklasser.Komparator;

import java.util.Arrays;

public class Oppgave5 {
    public static void main(String[] args) {
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, Komparator.orden(String::length));
        System.out.println(Arrays.toString(s));
    }
}
