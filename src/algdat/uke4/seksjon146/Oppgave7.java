package algdat.uke4.seksjon146;

import algdat.Tabell;
import algdat.eksempelklasser.Komparator;
import algdat.eksempelklasser.Student;
import algdat.eksempelklasser.Studium;

import java.util.Arrays;

public class Oppgave7 {
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new Student("Kari","Svendsen", Studium.Data);
        s[1] = new Student("Boris","Zukanovic", Studium.IT);
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);
        s[3] = new Student("Azra","Zukanovic", Studium.IT);
        s[4] = new Student("Kari","Pettersen", Studium.Data);

        Komparator<Student> c = (s1, s2) -> {
            int cmp = s1.studium().toString().compareTo(s2.studium().toString());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));
    }
}
