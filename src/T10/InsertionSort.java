/*
 * Insertion Sort implemented with an array
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class InsertionSort {
 
    public static void sort(int[] arr) {
            
        // arr[0, ... i - 1] is sorted, insert element at position i in the sorted array
        for(int i = 1; i < arr.length; i ++) {
            insert(arr, i);
        }
    }

    private static void insert(int[] arr, int i) {
        
        int nextElement = arr[i];  // element to insert
        while (i > 0 && nextElement < arr[i - 1]) {
            arr[i] = arr[i - 1];    // shift down
            i --;   // check next smaller element
        }
        // insert nextElement at index i
        arr[i] = nextElement;
    }
}
