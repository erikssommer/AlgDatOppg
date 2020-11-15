package algdat.diverse;

import java.util.Arrays;

/**
 * Boblesortering har lineær orden O(n) i beste tilfelle, men har
 * kvadratisk orden O(n^2) både i gjennomsnitt og worst case
 */

public class BubbleSort {

    public static void bubblesort(int[] values){
        for (int n = values.length; n > 1; ){
            int index = 0;
            for (int i = 1; i < n; i++){
                if (values[i - 1] > values[i]){
                    swap(values, i-1, i);
                    index = i;
                }
            }
            n = index;
        }
    }

    public static void swap(int[] values, int from, int to){
        int temp = values[from];
        values[from] = values[to];
        values[to] = temp;
    }

    public static void main(String[] args) {
        int[] values = {3,4,3,2,6,4,2,8,5,3,6,2,6};
        bubblesort(values);
        System.out.println(Arrays.toString(values));
    }
}
