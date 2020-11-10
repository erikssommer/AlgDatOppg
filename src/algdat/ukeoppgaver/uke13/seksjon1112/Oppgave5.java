package algdat.ukeoppgaver.uke13.seksjon1112;

import algdat.datastrukturer.Graf;

import java.io.IOException;

public class Oppgave5 {
    public static void main(String[] args) throws IOException {
        String url = "https://www.cs.hioa.no/~ulfu/appolonius/kap11/1/graf1b.txt";
        Graf graf = new Graf(url);
        System.out.println(graf.erUrettet()); // Utskrift: false
        graf.leggInnKant("C", "A"); // en ny kant
        System.out.println(graf.erUrettet()); // Utskrift: true
    }
}
