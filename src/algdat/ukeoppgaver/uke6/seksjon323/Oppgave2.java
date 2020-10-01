package algdat.ukeoppgaver.uke6.seksjon323;

import algdat.hjelpeklasser.TabellListe;

public class Oppgave2 {
    public static void main(String[] args) {
        String[] s = {"Jan", "Petter", "Markus", null, "Julie"};

        TabellListe<String> tabellListe = new TabellListe<>(s);
        tabellListe.nullstill();
        System.out.println(tabellListe.toString());
    }
}
