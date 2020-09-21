package algdat.uke4.seksjon144;

import algdat.Tabell;
import algdat.eksempelklasser.Heltall;

import java.util.Arrays;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,10,4,6}; // en int-tabell
        Heltall[] h = new Heltall[a.length]; // en Heltall-tabell

        for (int i = 0; i < h.length; i++){
            h[i] = new Heltall(a[i]);
        }

        Tabell.innsettingssortering(h); // generisk sortering
        System.out.println(Arrays.toString(h)); // utskrift
    }
}
