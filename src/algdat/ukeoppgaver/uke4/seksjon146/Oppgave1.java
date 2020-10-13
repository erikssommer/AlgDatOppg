package algdat.ukeoppgaver.uke4.seksjon146;

import algdat.hjelpeklasser.Tabell;
import algdat.eksempelklasser.Komparator;
import algdat.eksempelklasser.Person;

import java.util.Arrays;

public class Oppgave1 {
    public static void main(String[] args) {
        Person[] p = new Person[5];
        p[0] = new Person("Kari", "Svendsen");
        p[1] = new Person("Boris", "Zukanovic");
        p[2] = new Person("Ali", "Kahn");
        p[3] = new Person("Azra", "Zukanovic");
        p[4] = new Person("Kari", "Pettersen");

        //Gammeldags metode som ble brukt før lambda
        class FornavnKomparator implements Komparator<Person>{
            public int compare(Person p1, Person p2){
                return p1.fornavn().compareTo(p2.fornavn());
            }
        }

        Komparator<Person> c = new FornavnKomparator();
        Tabell.innsettingssortering(p, c);

        System.out.println(Arrays.toString(p));

        //Med bruk av lambda
        Komparator<Person> d = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, d);
        System.out.println(Arrays.toString(p));

        //Kortet ned litt
        Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));
    }
}
