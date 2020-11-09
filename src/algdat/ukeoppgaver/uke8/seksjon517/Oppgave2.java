package algdat.ukeoppgaver.uke8.seksjon517;

import algdat.datastrukturer.BinTre;
import algdat.datastrukturer.Oppgave;

public class Oppgave2 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,9,10,11,12,14};
        Integer[] verdi = {7,3,10,1,5,9,12,2,4,6,8,11};
        BinTre<Integer> tre = new BinTre<>(posisjon, verdi);
        tre.inorden(Oppgave.konsollutskrift());
    }
}
