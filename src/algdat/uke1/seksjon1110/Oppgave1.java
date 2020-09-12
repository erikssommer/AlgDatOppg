package algdat.uke1.seksjon1110;

import static algdat.uke1.seksjon1110.Program.*;

public class Oppgave1 {
    public static void main(String[] args) {
        int n = 100_000;
        System.out.println(antallMaks(randperm(n)));
    }
}
