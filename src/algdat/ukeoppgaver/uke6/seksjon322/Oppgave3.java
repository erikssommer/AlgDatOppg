package algdat.ukeoppgaver.uke6.seksjon322;

import algdat.hjelpeklasser.TabellListe;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] s = {"Jan", "Petter", "Markus", null, "Julie"};

        TabellListe<String> tabellListe = new TabellListe<>(s);

        System.out.println(tabellListe.toString());
    }
}
