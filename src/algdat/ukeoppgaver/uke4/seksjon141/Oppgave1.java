package algdat.ukeoppgaver.uke4.seksjon141;

import algdat.Tabell;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);
        int l = Tabell.maks(d);
        int m = Tabell.maks(s);

        System.out.println(a[k] + " " + d[l] + " " + s[m]);
    }
}
