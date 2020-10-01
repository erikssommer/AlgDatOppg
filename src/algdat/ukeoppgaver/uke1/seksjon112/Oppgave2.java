package algdat.ukeoppgaver.uke1.seksjon112;

public class Oppgave2 {
    public static void main(String[] args) {
        int [] a = {3,4,1,3,2,6,4,2,6,9,7,5};
        int minste = min(a);

        System.out.println(minste);
    }

    public static int min(int [] a){
        if (a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom");
        }
        int m = 0; //indeks til foreløpig minste verdi

        for (int i = 1; i < a.length; i++){
            if (a[i] < a[m]){
                m = i;
            }
        }

        return m;
    }
}
