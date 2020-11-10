package algdat.ukeoppgaver.uke13;

import algdat.datastrukturer.Graf;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] nodenavn = "ABCDEFG".split("");
        Graf graf = new Graf();
        for (String navn : nodenavn) graf.leggInnNode(navn);
        for (String navn : graf) System.out.print(navn + " ");
    }
}
