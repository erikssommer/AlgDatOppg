package algdat.uke4.seksjon145;

import algdat.eksempelklasser.Studium;

public class Oppgave1 {
    public static void main(String[] args) {
        for (Studium s : Studium.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
    }
}
