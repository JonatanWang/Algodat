/*
 * Implementera Quicksort för en array av int. 
 * Titta inte på någon kod utan utgå från algoritmen i boken.
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB31 {
        
    private static final int RANGE = 1000;
    
    public static void main(String[] args) {     
        
        // Test merge sort
        int[] arr = new int[15];
        for(int j = 0; j < arr.length; j ++) {
           arr[j] = (int) (RANGE * Math.random() - 300);
        }        
        System.out.print("Before sort: ");
        print(arr);
        QuickSort.sort(arr);
        System.out.print("\n\nAfter sort: ");
        print(arr);
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
