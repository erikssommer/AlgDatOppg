package algdat.en;

public class Collection {
    private Collection(){}

    public static int max(int[] a, int from, int to){
        int maxindex = from;
        int maxvalue = a[from];

        for (int i = from + 1; i < to; i++){
            if (a[i] > maxvalue){
                maxindex = i;
                maxvalue = a[i];
            }
        }
        return maxindex;
    }

    public static int min(int[] a, int from, int to){
        int minindex = from;
        int minvalue = a[from];

        for (int i = from + 1; i < to; i++){
            if (a[i] > minvalue){
                minindex = i;
                minvalue = a[i];
            }
        }
        return minindex;
    }
}
