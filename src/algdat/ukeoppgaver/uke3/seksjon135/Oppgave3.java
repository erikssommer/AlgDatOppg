package algdat.ukeoppgaver.uke3.seksjon135;

import algdat.Tabell;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = {1,3,3,5,6,7,8,12,13,13,13,45,56,78,78,78,78};

        System.out.println(Tabell.linearsokReturSisteVerdi(a, 7));
        System.out.println(Tabell.linearsokReturSisteVerdi(a, 3));
        System.out.println(Tabell.linearsokReturSisteVerdi(a, 78));
    }
}
