package algdat.en;

public class Collection {
    private Collection() {
    }

    public static int max(int[] a, int from, int to) {
        int maxindex = from;
        int maxvalue = a[from];

        for (int i = from + 1; i < to; i++) {
            if (a[i] > maxvalue) {
                maxindex = i;
                maxvalue = a[i];
            }
        }
        return maxindex;
    }

    public static int min(int[] a, int from, int to) {
        int minindex = from;
        int minvalue = a[from];

        for (int i = from + 1; i < to; i++) {
            if (a[i] > minvalue) {
                minindex = i;
                minvalue = a[i];
            }
        }
        return minindex;
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int index = 0;
        T value = a[index];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(value) > 0) {
                value = a[i];
                index = i;
            }
        }

        return index;
    }
}
