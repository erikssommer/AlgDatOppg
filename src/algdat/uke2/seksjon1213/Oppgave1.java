package algdat.uke2.seksjon1213;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {3,4,5,7,4,3,5,4,2,6,8,1,9,6};
        System.out.println(Arrays.toString(Tabell.nestMaksTR(a)));
    }
}
