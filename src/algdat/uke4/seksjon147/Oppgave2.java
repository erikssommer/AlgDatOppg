package algdat.uke4.seksjon147;

import algdat.Tabell;
import algdat.eksempelklasser.Komparator;

import java.util.Arrays;

public class Oppgave2 {
    public static void main(String[] args) {
        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};

        Tabell.innsettingssortering(d, Komparator.naturligOrden());
        System.out.println(Arrays.toString(d));

        Tabell.innsettingssortering(d, Komparator.anvendtOrden());
        System.out.println(Arrays.toString(d));
    }
}
