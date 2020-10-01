package algdat.ukeoppgaver.uke2.seksjon1213;

import algdat.Tabell;

import java.util.Arrays;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = {3,4,5,7,4,3,5,4,2,6,8,1,9,6};
        int[] b = new int[2*a.length];
        //System.arraycopy(a,0,b,n,n);
        Tabell.kopier(a,0,b,a.length,a.length);
        System.out.println(Arrays.toString(b));
    }
}
