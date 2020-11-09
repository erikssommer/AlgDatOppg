package algdat.ukeoppgaver.uke8.seksjon517;

import algdat.datastrukturer.BinTre;
import algdat.datastrukturer.Oppgave;

public class Oppgave3 {
    public static void main(String[] args) {
        String[] preorden = "ABDHOIPQEJRKSCFLMTUGNV".split("");
        String[] inorden = "HODPIQBJREKSALFTMUCNVG".split("");
        BinTre<String> tre = BinTre.trePreorden(preorden,inorden);
        tre.nivaOrden(Oppgave.konsollutskrift());
    }
}
