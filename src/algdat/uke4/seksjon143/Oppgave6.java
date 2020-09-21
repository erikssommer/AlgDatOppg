package algdat.uke4.seksjon143;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave6 {
    public static void main(String[] args) {
        Integer[] a = Tabell.randPermInteger(20);
        System.out.println(Arrays.toString(a));

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
    }
}
