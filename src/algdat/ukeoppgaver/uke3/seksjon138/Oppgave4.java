package algdat.ukeoppgaver.uke3.seksjon138;

import algdat.hjelpeklasser.Tabell;

public class Oppgave4 {
    public static void main(String[] args) {
        int[] a = {3,5,6,10,10,11,13,14,16,20,0,0,0,0,0}; // en tabell
        int antall = 10; // antall verdier
        int nyverdi = 10;
        int k = Tabell.binaersokV1(a, 0, antall, nyverdi); if (k<0)k=-(k+1);
        if (antall - k >= 0) System.arraycopy(a, k, a, k + 1, antall - k);
        a[k] = nyverdi;
        antall++;
        Tabell.skrivln(a, 0, antall);
    }
}
