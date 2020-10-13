package algdat.ukeoppgaver.uke3.seksjon135;

import algdat.hjelpeklasser.Tabell;

public class Oppgave5 {
    public static void main(String[] args) {
        int[] a = new int[100];

        for (int i = 0; i < 100; i++){
            a[i] = i;
        }

        int[] b = {3,3,6,7,8,34,56,78,78,89,99};

        System.out.println(Tabell.linearsok(a, 10, 45));
        System.out.println(Tabell.linearsok(b, 5, 78));

        System.out.println(Tabell.kvadratrotsok(b, 4));
    }
}
