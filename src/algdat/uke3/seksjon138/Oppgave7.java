package algdat.uke3.seksjon138;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave7 {
    public static void main(String[] args) {
        int[] a = {13,11,10,20,15,5,3,2,14,10,12,6,7,4,16};
        Tabell.innsettingssortering(a, 3, 8);
        System.out.println(Arrays.toString(a));
    }
}
