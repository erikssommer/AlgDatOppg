package algdat.uke1.seksjon113;

public class Oppgave6 {
    public static void main(String[] args) {
        System.out.println(fak(3));
    }

    public static long fak(int a){
        if(a <= 1) {
            return 1;
        }

        return a * fak(a-1);
    }
}
