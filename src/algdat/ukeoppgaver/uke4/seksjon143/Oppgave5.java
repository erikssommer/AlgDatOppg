package algdat.ukeoppgaver.uke4.seksjon143;

import algdat.datastrukturer.Tabell;

public class Oppgave5 {
    public static void main(String[] args) {
        Object[] a = {"Erik", "Ola", 78, true, 100.9};
        Tabell.skrivln(a);
        Tabell.skriv(a, 2, 4);
        System.out.println();
        Tabell.bytt(a, 2,3);
        Tabell.skriv(a);
    }
}
