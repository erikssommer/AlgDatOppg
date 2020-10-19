package algdat.ukeoppgaver.uke8.seksjon517;

import algdat.hjelpeklasser.BinTre;
import algdat.hjelpeklasser.Oppgave;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] preorden = "ABDHOIPQEJRKSCFLMTUGNV".split("");
        String[] inorden = "HODPIQBJREKSALFTMUCNVG".split("");
        BinTre<String> tre = BinTre.trePreorden(preorden,inorden);
        tre.nivaOrden(Oppgave.konsollutskrift());
    }
}
