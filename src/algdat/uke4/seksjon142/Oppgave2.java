package algdat.uke4.seksjon142;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));
    }
}
