package algdat.ukeoppgaver.uke4.seksjon144;

import algdat.datastrukturer.Tabell;
import algdat.eksempelklasser.Person;

import java.util.Arrays;
import java.util.Comparator;

public class Oppgave2 {
    public static void main(String[] args) {
        Person[] p = new Person[5];

        p[0] = new Person("Kari","Svendsen");
        p[1] = new Person("Boris","Zukanovic");
        p[2] = new Person("Ali","Kahn");
        p[3] = new Person("Azra","Zukanovic");
        p[4] = new Person("Kari","Pettersen");

        int m = Tabell.maks(p);
        System.out.println(p[m] + " er størst");
        Tabell.innsettingssortering(p);
        System.out.println(Arrays.toString(p));

        /*
        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
         */

        //Skrevet på én linje
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);

    }
}
