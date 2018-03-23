/*
 * Implementera Mergesort för en array av int. Utgå från algoritmerna på föreläsningen. 
 * Använd inte kod från boken eller från nätet.
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB29 {
    
    private static final int KEY_RANGE = 1000;
    
    public static void main(String[] args) {     
        
        // Test merge sort
        int[] arr = new int[15];
        for(int j = 0; j < arr.length; j ++) {
           arr[j] = (int) (KEY_RANGE * Math.random() - 300);
        }        
        MergeSort.sort(arr);
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
