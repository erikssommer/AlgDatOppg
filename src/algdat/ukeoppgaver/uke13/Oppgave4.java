package algdat.ukeoppgaver.uke13;

import algdat.datastrukturer.Graf;

import java.io.IOException;

public class Oppgave4 {
    public static void main(String[] args) {
        String url = "https://www.cs.hioa.no/~ulfu/appolonius/kap11/1/graf1.txt";
        Graf graf;
        try {
            graf = new Graf(url);
        }catch (IOException e){
            System.out.println("Url'en er ikke gyldig");
            graf = new Graf();
        }

        for (String navn : graf) System.out.print(navn + " ");
    }
}
