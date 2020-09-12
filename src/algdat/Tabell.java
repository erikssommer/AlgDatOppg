package algdat;

import java.util.Arrays;
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
        if (fra < 0 || til > a.length || fra >= til){
            throw new IllegalArgumentException("Illegalt intervall");
        }

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
        if (fra < 0){
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tabellengde){
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tabellengde + ")");
        }

        if (fra > til){
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
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



}
