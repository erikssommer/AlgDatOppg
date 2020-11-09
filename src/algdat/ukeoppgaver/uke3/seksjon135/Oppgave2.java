package algdat.ukeoppgaver.uke3.seksjon135;

import algdat.datastrukturer.Tabell;

public class Oppgave2 {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};
        int[] b = {};

        System.out.println(Tabell.linearsok(b, 3)); //Gir riktig returverdi

        System.out.println(Tabell.linearsok(a, 2));
        System.out.println(Tabell.linearsok(a, 15));
        System.out.println(Tabell.linearsok(a, 16));
        System.out.println(Tabell.linearsok(a, 40));
        System.out.println(Tabell.linearsok(a, 41));
    }
}
