package algdat.ukeoppgaver.uke4.seksjon146;

import algdat.Tabell;
import algdat.eksempelklasser.Komparator;
import algdat.eksempelklasser.Student;
import algdat.eksempelklasser.Studium;

import java.util.Arrays;

public class Oppgave2 {
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new Student("Kari","Svendsen", Studium.Data);
        s[1] = new Student("Boris","Zukanovic", Studium.IT);
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);
        s[3] = new Student("Azra","Zukanovic", Studium.IT);
        s[4] = new Student("Kari","Pettersen", Studium.Data);

        //V1
        Tabell.innsettingssortering(s, (s1, s2) -> s1.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s));

        //V2
        Komparator<Student> c = (s1,s2) -> {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));

        //V3
        Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()) != 0 ? s1.studium().compareTo(s2.studium()) : s1.compareTo(s2));
        System.out.println(Arrays.toString(s));
    }
}
