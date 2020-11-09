package algdat.ukeoppgaver.uke6.seksjon322;

import algdat.datastrukturer.TabellListe;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] s = {"Jan", "Petter", "Markus", null, "Julie"};

        TabellListe<String> tabellListe = new TabellListe<>(s);
        System.out.println(tabellListe.indeksTil("Petter"));
        System.out.println(tabellListe.hent(3));
    }
}
