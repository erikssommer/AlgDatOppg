package algdat.ukeoppgaver.uke13.seksjon1113;

import algdat.datastrukturer.MatriseGraf;

import java.util.Arrays;

public class Oppgave6 {
    public static void main(String[] args) {
        MatriseGraf graf = new MatriseGraf(0); // starter med tomme tabeller
        String[] navn = "ABEGFCD".split(""); // usortert rekkefølge
        for (String n : navn) graf.leggInnNode(n); // legger inn
        System.out.println(Arrays.toString(graf.nodenavn())); // [A, B, C, D, E, F, G]
    }
}
