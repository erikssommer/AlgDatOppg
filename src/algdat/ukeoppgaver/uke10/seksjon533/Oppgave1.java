package algdat.ukeoppgaver.uke10.seksjon533;

import algdat.datastrukturer.HeapPrioritetsKo;
import algdat.datastrukturer.PrioritetsKo;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {3,5,7,10,5,8,18,12,17,11,10,14};
        PrioritetsKo<Integer> ko = HeapPrioritetsKo.naturligOrden();

        for (int k : a) ko.leggInn(k);

        ko.leggInn(6); System.out.println(ko);
        ko.leggInn(10); System.out.println(ko);
        ko.leggInn(12); System.out.println(ko);
    }
}
