package algdat.ukeoppgaver.uke9.seksjon527;

import algdat.hjelpeklasser.Tabell;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] liste = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste);
        System.out.println(Arrays.toString(liste));

        Integer[] liste2 = {76,3,2,7,32,4,2,7,8,3};
        Tabell.sort(liste2);
        System.out.println(Arrays.toString(liste2));
    }
}

