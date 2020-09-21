package algdat.uke4.seksjon143;

import java.util.Arrays;

public class Oppgave7 {
    public static void main(String[] args) {
        double[] a = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] b = new Double[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        System.out.println(Arrays.toString(b));
    }
}
