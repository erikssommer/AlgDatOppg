package algdat.ukeoppgaver.uke4.seksjon147;

import algdat.datastrukturer.Tabell;
import algdat.eksempelklasser.Komparator;
import algdat.eksempelklasser.Person;

import java.util.Arrays;

public class Oppgave4 {
    public static void main(String[] args) {
        Person[] p = new Person[5];
        p[0] = new Person("Kari", "Svendsen");
        p[1] = new Person("Boris", "Zukanovic");
        p[2] = new Person("Ali", "Kahn");
        p[3] = new Person("Azra", "Zukanovic");
        p[4] = new Person("Kari", "Pettersen");

        Tabell.innsettingssortering(p, Komparator.orden((Person::etternavn)));
        System.out.println(Arrays.toString(p));
    }
}
