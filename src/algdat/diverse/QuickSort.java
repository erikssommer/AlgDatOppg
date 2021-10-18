package algdat.diverse;

import java.util.Arrays;

/**
 * Matematisk analyse viser at quicksort i gjennomsnitt krever O (n log n) sammenligninger for å sortere n elementer.
 * I verste tilfelle krever algoritmen O(n2) sammenligninger, selv om dette forekommer sjeldent. Klassisk quicksort
 * krever i gjennomsnitt 2 * n * ln(n)) antall sammenligninger og 1 * n * ln(n)) antall bytter av elementer.
 */

public class QuickSort {

    public static void quickSort(int[] values, int left, int right){
        if (left >= right) return;

        //Velg pivot
        int pivotIndex = (left + right) / 2;
        int pivot = values[pivotIndex];

        //Partisjonering - Alle til høyre er større eller lik pivot og motsatt
        int newPivotIndex = partition(values, left, right, pivotIndex);

        //Gjenta for høyre og venstre subliste
        quickSort(values, left, newPivotIndex-1);
        quickSort(values, newPivotIndex+1, right);
        // Bug fix
    }

    public static int partition(int[] values, int begin, int end, int pivotIndex){
        //Flytter pivot til slutten av arrayet
        swap(values, pivotIndex, end-1);

        int left = begin;
        int right = end-2;

        //Looper igjennom listen til left møter right
        while (left < right){
            while (left <= right && values[left] < values[end-1]){
                left++;
            }
            while (left <= right && values[right] > values[end-1]){
                right--;
            }
            if (left < right){
                swap(values, left, right);
                left++;
                right--;
            }
        }
        swap(values, left, end-1);

        return left;
    }

    public static void swap(int[] values, int from, int to){
        int temp = values[from];
        values[from] = values[to];
        values[to] = temp;
    }

    public static void main(String[] args) {
        int[] values = {3,4,3,2,6,4,2,8,5,3,6,2,6};
        quickSort(values, 0, values.length);
        System.out.println(Arrays.toString(values));
    }
}
