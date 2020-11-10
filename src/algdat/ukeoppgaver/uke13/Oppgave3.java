package algdat.ukeoppgaver.uke13;

import algdat.datastrukturer.Graf;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] nodenavn = "ABCDEFG".split("");
        Graf graf = new Graf();

        for (String navn : nodenavn) graf.leggInnNode(navn);
        for (String navn : graf) System.out.print(navn + " ");

        graf.leggInnKanter("A", "B","C","D");
        graf.leggInnKanter("B", "A","D","E");
        graf.leggInnKanter("C", "A","D","F");
        graf.leggInnKanter("D", "A","B","C","E","F","G");
        graf.leggInnKanter("E", "B","D","G");
        graf.leggInnKanter("F", "C","D","G");
        graf.leggInnKanter("G", "D","E","F");

        for (String navn : graf) System.out.print(navn + " ");
    }
}
