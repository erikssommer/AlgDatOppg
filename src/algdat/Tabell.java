package algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell(){}

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n){
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--){
            int i = r.nextInt(k +1);
            bytt(a,k,i);
        }
        return a;
    }

    public static void randPerm(int[] a) {
        Random r = new Random();

        for (int k=a.length-1;k>0;k--) {
            int i = r.nextInt(k + 1); // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til){

        fratilKontroll(a.length, fra, til);

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++){
            if (a[i] > maksverdi){
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    public static int maks(int[] a){
        return maks(a, 0,a.length);
    }

    public static int min(int[] a, int fra, int til){
        if (fra < 0 || til > a.length || fra >= til){
            throw new IllegalArgumentException("Illegalt intervall");
        }

        int m = fra;
        int minvedi = a[fra];

        for (int i = fra + 1; i < til; i++){
            if (a[i] < minvedi){
                m = i;
                minvedi = a[m];
            }
        }
        return m;

    }

    public static int min(int[] a){
        return min(a, 0,a.length);
    }

    public static void bytt(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til){
        for (int i = fra; i <= til; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void skriv(int[] a){
        for (int i : a){
            System.out.print(i + " ");
        }
    }

    public static void skrivln(int[] a, int fra, int til){
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] a){
        skriv(a);
        System.out.println();
    }

    public static void fratilKontroll(int tabellengde, int fra, int til){

        if (tabellengde == 0){
            throw new IllegalArgumentException("Tabellengden er null");
        }

        if (fra < 0){
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tabellengde){
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tabellengde + ")");
        }

        if (fra > til){
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v<0){
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }
        if (h >= tablengde){
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde + ")");
        }

        if (v>h+1){
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
    }

    public static int[] nestMaks(int[] a){
        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        int nm;

        if (m == 0){
            nm = maks(a, 1, n);
        }else if (m == n - 1){
            nm = maks(a, 0, n -1);
        }else {
            int mv = maks(a, 0, m);
            int mh = maks(a, m + 1, n);
            nm = a[mh] > a[mv] ? mh : mv;
        }
        return new int[] {m, nm};
    }

    public static int[] nestMaksSF(int[] a){

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        bytt(a, 0, m);

        int nm = maks(a, 1, n);

        bytt(a, m, 0);

        return new int[] {m, nm};
    }

    public static int[] nestMaksSB(int[] a){

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        bytt(a, m, n - 1);

        int nm = maks(a, 0, n - 2);

        bytt(a, m, n - 1);

        return new int[] {m, nm};
    }

    public static void sortering(int[] a){

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        for (int i = n-1; i > 0; i--){

            int m = maks(a, 0, i);

            bytt(a, m, i);

            int nm = maks(a, 0, i);

            bytt(a, nm, i-1);
        }
    }

    public static int[] nestMaksTR(int[] a){ //Turneringstre
        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];
        //System.arraycopy(a,0,b,n,n);
        kopier(a,0,b,n,n);

        for (int k = 2*n-2; k > 1; k -= 2){
            b[k/2] = Math.max(b[k],b[k+1]);
        }

        int maksverdi = b[1];
        int nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n -1, k = 2; k < m; k *= 2){
            int temp = b[k+1];
            if (maksverdi != b[k]){
                temp = b[k];
                k++;
            }
            if (temp > nestmaksverdi){
                nestmaksverdi = temp;
            }
        }
        return new int[] {maksverdi, nestmaksverdi};
    }

    public static void kopier(int[] a, int i, int[] b, int j, int ant){
        int aIndex = i;
        for (int k = j; k < ant*2; k++){
            if (aIndex < a.length){
                b[k] = a[aIndex];
                aIndex++;
            }
        }
    }
}
