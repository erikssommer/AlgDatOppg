package algdat.ukeoppgaver.uke2.seksjon124;

import algdat.Tabell;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaksSB(a);

        int m = b[0];
        int nm = b[1];

        Tabell.skrivln(a);
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }
}
