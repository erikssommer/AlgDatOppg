package algdat.ukeoppgaver.uke4.seksjon145;

import algdat.eksempelklasser.Maned;

public class Oppgave3 {
    public static void main(String[] args) {
        for (Maned s : Maned.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
    }
}
