package algdat.ukeoppgaver.uke4.seksjon146;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave5 {
    public static void main(String[] args) {
        String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s, String::compareTo);
        System.out.println(Arrays.toString(s));
    }
}
