package algdat.uke2.seksjon124;

import algdat.Tabell;

public class Oppgave4 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);

        Tabell.skrivln(a);

        Tabell.sortering(a);

        //Ser den ikke klarer å sortere tallet som ligger på index 0
        Tabell.skrivln(a);
    }
}
