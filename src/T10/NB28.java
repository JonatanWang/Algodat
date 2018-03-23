/*
 * Implementera urvalssortering och instickssortering för en array av int.
 * Impement selection sort and insertion sort with an array of integers.
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB28 {
    
    private static final int KEY_RANGE = 1000;
    
    public static void main(String[] args) {     
        
        // Test selection sort
        int[] arr = new int[30];
        for(int j = 0; j < arr.length; j ++) {
           arr[j] = (int) (KEY_RANGE * Math.random() - 300);
        }        
        SelectionSort.sort(arr);
        print(arr);
        
        // Test insertion sort
        int[] arr2 = new int[30];
        for(int j = 0; j < arr2.length; j ++) {
           arr2[j] = (int) (KEY_RANGE * Math.random() - 300);
        }        
        InsertionSort.sort(arr2);
        print(arr2);
    }
    
    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[");
        for(Integer i : arr) {
            sb.append(i).append("\t");
        }
        sb.append("]");
        System.out.print(sb.toString());
    }
}
