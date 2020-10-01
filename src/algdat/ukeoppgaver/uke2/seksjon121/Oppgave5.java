package algdat.ukeoppgaver.uke2.seksjon121;

import java.util.Arrays;

//Hele poenget med oppgavene er å lære seg for-alle-løkke

public class Oppgave5 {
    public static void main(String[] args) {
        char[] c = {'A','B','C','D','E','F','G','H','I','J'};
        char[] d = Arrays.copyOfRange(c,4,8); // en kopi av c[4:8>
        for (char k : d){
            System.out.print(k + " ");
        }
    }
}
