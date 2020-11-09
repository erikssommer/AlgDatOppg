package algdat.ukeoppgaver.uke6.seksjon324;

import algdat.datastrukturer.TabellListe;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] s = {"Jan", "Petter", "Markus", null, "Julie"};

        TabellListe<String> tabellListe = new TabellListe<>(s);

        tabellListe.fjernHvis(s1 -> s1.equals("Markus"));
        tabellListe.forEach(System.out::println);
    }
}
