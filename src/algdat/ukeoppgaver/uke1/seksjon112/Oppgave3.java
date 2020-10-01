package algdat.ukeoppgaver.uke1.seksjon112;

public class Oppgave3 {
    public static void main(String[] args) {
        int [] a = {3,4,9,3,2,6,4,2,2,9,7,5};
        int verdi = maks(a);

        System.out.println(verdi);
    }

    public static int maks(int [] a){
        if (a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom");
        }
        int m = 0;

        for (int i = 1; i < a.length; i++){
            if (a[i] >= a[m]){ //Endringen er å skrive >=
                m = i;
            }
        }

        return m;
    }
}
