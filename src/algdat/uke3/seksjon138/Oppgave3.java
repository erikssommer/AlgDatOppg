package algdat.uke3.seksjon138;

import java.util.Arrays;

public class Oppgave3 {
    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,56,7,3};
        int[] b = Arrays.copyOf(a, 13);
        int[] c = Arrays.copyOfRange(a, 3, 5);

        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
