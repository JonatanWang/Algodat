/*
 * Implementera Shellsort och Heapsort för en array av int. 
 * Utgå från algoritmerna på föreläsningen. 
 * Försök att inte använda kod från boken eller från nätet.
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB30 {
        
    private static final int RANGE = 1000;
    
    public static void main(String[] args) {     
        
        // Test shell sort
        int[] arr = new int[15];
        for(int j = 0; j < arr.length; j ++) {
           arr[j] = (int) (RANGE * Math.random() - 300);
        }       
        System.out.print("Before shell sort: ");
        print(arr);
        ShellSort.sort(arr);
        print(arr);
        
        // Test heap sort
        int[] arr2 = new int[15];
        for(int j = 0; j < arr2.length; j ++) {
           arr2[j] = (int) (RANGE * Math.random() - 300);
        }        
        HeapSort.sort(arr2);
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
