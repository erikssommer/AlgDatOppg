package algdat.diverse;

import java.util.Arrays;

/**
 * Flettesortering (engelsk: merge sort) er en effektiv sammenligningsbasert sorteringsalgoritme.
 * De fleste implementasjoner produserer en stabil sortering, noe som betyr at implementasjonen bevarer innmatningens
 * rekkefølge av like elementer i den sorterte utmatningen. Flettesortering er en splitt og hersk-algoritme.
 * Gjennomsnittlig og worst case O(n log(n)) sammenlikninger
 */

public class MergeSort {

    public static void mergeSort(int[] values, int[] temp, int begin, int end){
        int pivot = (begin + end) / 2;

        if (end - begin < 2) return;

        //Sorterer venstre intervall
        mergeSort(values, temp, begin, pivot);

        //Sorterer høyre intervall
        mergeSort(values, temp, pivot, end);

        //Slår sammen til en samlet liste
        merge(values, temp, begin, pivot, end);
    }

    public static void merge(int[] values, int[] temp, int begin, int pivot, int end){
        //Sjeker om listen allerede er sortert
        if (values[pivot-1] <= values[pivot]) return;

        int n = pivot - begin;
        //Kopier fra values inn i temp
        System.arraycopy(values, begin, temp, 0, n);

        //Teller i temp-variabelen
        int i = 0;

        //Telleren er i values, starter fra midten
        int j = pivot;

        //Telleren er i values. Brukes som output. Starter på starten
        int k = begin;

        //Looper så lenge i er innenfor intervallet
        while (i < n && j < end){
            if (temp[i] < values[j]){
                values[k] = temp[i];
                i++;
            }else {
                values[k] = values[j];
                j++;
            }
            k++;
        }

        //Legger inn resterende tall
        while (i < n){
            values[k] = temp[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] values = {3,4,3,2,6,4,2,8,5,3,6,2,6};
        int[] temp = new int[values.length/2];

        mergeSort(values, temp, 0, values.length);
        System.out.println(Arrays.toString(values));
    }
}
