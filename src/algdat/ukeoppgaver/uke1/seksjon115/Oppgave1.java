package algdat.ukeoppgaver.uke1.seksjon115;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {7,3,4,7,3,2,6,8};
        int[] b = {3};
        int[] c = {};

        System.out.println(maks(a));
        System.out.println(maks(b));
        System.out.println(maks(c)); //Metoden i eks. funker ikke for tomme arrays. Rettet på det
    }

    public static int maks(int[] a) {
        if (a.length == 0){
            return -1;
        }

        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = 0x7fffffff; //Tallet: 2 147 483 647

        for (int i = 0; ; i++) {
            if (a[i] >= maksverdi) {
                if (i == sist) {
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }
}

