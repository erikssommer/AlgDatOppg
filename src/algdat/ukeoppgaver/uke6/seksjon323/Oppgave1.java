package algdat.ukeoppgaver.uke6.seksjon323;

import algdat.datastrukturer.TabellListe;

public class Oppgave1 {
    public static void main(String[] args) {
        String[] s = {"Jan", "Petter", "Markus", null, "Julie"};

        TabellListe<String> tabellListe = new TabellListe<>(s);
        System.out.println(tabellListe.fjern("Markus"));
        System.out.println(tabellListe.toString());
    }
}
