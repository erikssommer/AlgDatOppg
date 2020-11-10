package algdat.datastrukturer;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class MatriseGraf {
    private boolean[][] graf;
    private int antall;
    private String[] navn;  // Sortert
    private String[] snavn; // Usortert
    private int[] indeks;
    private int[] forrige;

    public MatriseGraf(int dimensjon){
        graf = new boolean[dimensjon][dimensjon];
        antall = 0;
        navn = new String[dimensjon];
        snavn = new String[dimensjon];
        indeks = new int[dimensjon];
    }

    public MatriseGraf(){
        this(10);
    }

    public int antallNoder(){
        return antall;
    }

    public int dimensjon(){
        return graf.length;
    }

    public String[] nodenavn(){
        return Arrays.copyOf(snavn, antall);
    }

    private int finn(String nodenavn){
        return Arrays.binarySearch(snavn, 0, antall, nodenavn);
    }

    public boolean nodeFinnes(String nodenavn){
        return finn(nodenavn) >= 0;
    }

    private void utvid(){
        int nydimensjon = graf.length == 0 ? 1 : 2 * graf.length;

        navn = Arrays.copyOf(navn, nydimensjon);
        snavn = Arrays.copyOf(snavn, nydimensjon);
        indeks = Arrays.copyOf(indeks, nydimensjon);

        boolean[][] gammelgraf = graf;
        graf = new boolean[nydimensjon][nydimensjon];

        for (int i = 0; i < antall; i++) System.arraycopy(gammelgraf[i], 0, graf[i], 0, antall);
    }

    public boolean leggInnNode(String nodenavn){
        if (navn == null || nodenavn.length() == 0) throw new IllegalArgumentException("Noden må ha et navn");

        int rad = finn(nodenavn);
        if (rad >= 0) return false;
        if (antall >= graf.length) utvid();

        rad = -(rad + 1);

        for (int i = antall; i > rad; i--){
            snavn[i] = snavn[i-1];
            indeks[i] = indeks[i-1];
        }

        snavn[rad] = nodenavn;
        navn[antall] = nodenavn;
        indeks[rad] = antall;

        antall++;

        return true;
    }

    public void leggInnKant(String franode, String tilnode) {
        if (franode.equals(tilnode)) throw new IllegalArgumentException(franode + " er lik " + tilnode + "!");

        int i = finn(franode);
        if (i < 0) throw new NoSuchElementException(franode + " er ukjent!");

        int j = finn(tilnode);
        if (j < 0) throw new NoSuchElementException(tilnode + " er ukjent!");

        int rad = indeks[i];
        int kolonne = indeks[j];

        if (graf[rad][kolonne]) throw new IllegalArgumentException("Kanten finnes fra før!");

        graf[rad][kolonne] = true;
    }

    public void leggInnKanter(String franode, String... tilnoder) {
        for (String tilnode : tilnoder) leggInnKant(franode, tilnode);
    }
}
