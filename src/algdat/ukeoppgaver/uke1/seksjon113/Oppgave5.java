package algdat.ukeoppgaver.uke1.seksjon113;

import java.util.Arrays;

public class Oppgave5 {
    public static void main(String[] args) {
        int[] a = {3,4,1,3,2,6,4,2,6,9,7,5};
        int[] mm = minmaks(a);

        System.out.println(Arrays.toString(mm));
    }

    public static int[] minmaks(int[] a){
        if (a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom");
        }

        int counter = 0;

        int m1 = 0;
        int m2 = 0;

        for (int i = 1; i < a.length; i++){
            if (a[i] < a[m1]){
                m1 = i;
                counter++;
            }
            if (a[i] > a[m2]){
                m2 = i;
                counter++;
            }
        }
        System.out.println("Gikk " + counter + " ganger inn i if testene!");
        return new int[] {m1, m2};
    }

}
