package algdat.ukeoppgaver.uke4.seksjon146;

import algdat.hjelpeklasser.Tabell;
import algdat.eksempelklasser.Person;
import algdat.eksempelklasser.Student;
import algdat.eksempelklasser.Studium;

import java.util.Arrays;

public class Oppgave3 {
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new Student("Kari","Svendsen", Studium.Data);
        s[1] = new Student("Boris","Zukanovic", Studium.IT);
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);
        s[3] = new Student("Azra","Zukanovic", Studium.IT);
        s[4] = new Student("Kari","Pettersen", Studium.Data);

        Tabell.innsettingssortering(s, (Person::compareTo));
        System.out.println(Arrays.toString(s));
    }
}
