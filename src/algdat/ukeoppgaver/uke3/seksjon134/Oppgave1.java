package algdat.ukeoppgaver.uke3.seksjon134;

import java.util.Arrays;

import static algdat.hjelpeklasser.Tabell.min;
import static algdat.hjelpeklasser.Tabell.bytt;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {15, 8, 21, 16, 5, 19, 7, 23, 10, 14, 3, 11, 6, 17, 4};

        for (int i = 0; i < 3; i++){
            bytt(a, i, min(a,i,a.length));
        }
        System.out.println(Arrays.toString(a));

        //i) 5
        for (int i = 0; i < 5; i++){
            bytt(a, i, min(a,i,a.length));
        }
        System.out.println(Arrays.toString(a));

        //ii) 7
        for (int i = 0; i < 7; i++){
            bytt(a, i, min(a,i,a.length));
        }
        System.out.println(Arrays.toString(a));
    }
}

