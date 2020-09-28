package algdat.uke4.seksjon147;

import algdat.Tabell;
import algdat.eksempelklasser.Komparator;

import java.util.Arrays;

public class Oppgave3 {
    public static void main(String[] args) {
        Boolean[] b = {false, true, true, false, false, true, false, true};

        Tabell.innsettingssortering(b, Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));
    }
}
