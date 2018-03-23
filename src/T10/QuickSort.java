/*
 * QuickSort based on the textbook
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class QuickSort {
    
    // sort the array using the quicksort algorithm
    public static void sort(int[] a) {
        // sort the whole array
        quickSort(a, 0, a.length - 1);
    }

    /**
     * sort a part of the array using the quick sort algorithm
     * @param a The array to be sorted
     * @param first The low bound index
     * @param last  The high bound index
     */
    private static void quickSort(int[] a, int first, int last) {
    
        if (first < last) { // there is data to be sorted
                        // partition the array
            int pivot = partition(a, first, last);

            // sort the left half
            quickSort(a, first, pivot - 1);
            // sort the right half
            quickSort(a, pivot + 1, last);
        }
    }

    private static int partition(int[] a, int first, int last) {
        
        // select the first item as the pivot value
        int pivot = a[first];
        int up = first;
        int down = last;
        
        do {
            /**
             * all items in a[first, ..., up - 1] <= pivot
             * all items in a[down + 1, ..., last] > pivot
             */
            while(up < last && pivot >= a[up]) {
                up ++;
            }
            // up equals last or a[up] > pivot
            while (pivot < a[down]) {
                down --;
            }
            // down equals first or a[down] <= pivot
            if(up < down) { // if up is to the left of down
                // exchange a[up] and a[down]
                swap(a, up, down);
            }
        } while (up < down);    // repeat while up is left of down
        // exchange a[first] and a[down] thus putting the pivot value where it belongs
        swap(a, first, down);
        // return the index of the pivot value
        return down;
    }

    /**
     * swap the items in a[i] and a[j]
     * @param a
     * @param i
     * @param j 
     */
    private static void swap(int[] a, int i, int j) {
        
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
