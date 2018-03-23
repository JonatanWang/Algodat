/*
 * Implement Selection Sort with an array of integers
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class SelectionSort {
    
    public static void sort(int[] arr) {
  
        for(int i = 0; i < arr.length - 1; i ++) {
            // arr[0, ... i - 1] is sorted
            int min = i;
            
            for (int j = i + 1; j < arr.length; j ++) {
                // arr[min] is the smallest in arr[i, ... j - 1]
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
           
            // arr[min] is the smallest in arr[i, ... arr.length - 1], swap arr[i] and arr[min]
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            // Now arr[i] is the smallest in arr[i, ..., arr.length - 1]
        }
    }
}
