package algdat.diverse;

import java.util.Arrays;

public class Turneringstre {
    public static void main(String[] args) {
        int[] turnering = new int[12];
        turnering[11] = 3;
        turnering[10] = 5;
        turnering[9] = 6;
        turnering[8] = 8;
        turnering[7] = 9;
        turnering[6] = 2;

        System.out.println(Arrays.toString(turnering));
        System.out.println("Vinneren er: " + vinner(turnering));
        System.out.println(Arrays.toString(turnering));

        System.out.println();

        int[] storTurnering = new int[100];
        for (int i = storTurnering.length/2; i < storTurnering.length; i++){
            storTurnering[i] = (int)(Math.random()*(900)+0);
        }

        System.out.println(Arrays.toString(storTurnering));
        System.out.println("Vinneren er: " + vinner(storTurnering));
        System.out.println(Arrays.toString(storTurnering));
    }

    @SuppressWarnings("ALL") //Fjerner forslag om å bruke Math.max
    public static int vinner(int[] a){
        for (int i = a.length-1; i > 0; i-=2){
            a[(i-1)/2] = (a[i] > a[i-1]) ? a[i] : a[i-1];
        }
        return a[0];
    }
}
