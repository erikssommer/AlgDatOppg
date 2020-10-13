package algdat.ukeoppgaver.uke4.seksjon145;

import algdat.hjelpeklasser.Tabell;
import algdat.eksempelklasser.Student;
import algdat.eksempelklasser.Studium;

public class Oppgave5 {
    public static void main(String[] args) {
        Student[] s = new Student[6]; // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);
        s[4] = new Student("Kari", "Pettersen", Studium.Data);
        s[5] = new Student("Ola", "Normann", Studium.Elektro);

        Tabell.innsettingssortering(s);

        for (Student t : s){
            System.out.println(t);
        }
    }
}
