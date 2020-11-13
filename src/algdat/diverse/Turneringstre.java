package algdat.diverse;

public class Turneringstre {
    public static void main(String[] args) {
        int[] turnering = new int[12];
        turnering[11] = 3;
        turnering[10] = 5;
        turnering[9] = 6;
        turnering[8] = 8;
        turnering[7] = 9;
        turnering[6] = 2;

        System.out.println(vinner(turnering));
    }

    @SuppressWarnings("ALL") //Fjerner forslag om å bruke Math.max
    public static int vinner(int[] a){
        for (int i = a.length-1; i > 0; i-=2){
            a[(i-1)/2] = (a[i] > a[i-1]) ? a[i] : a[i-1];
        }
        return a[0];
    }
}
