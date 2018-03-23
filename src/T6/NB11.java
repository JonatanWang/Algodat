/*
 * Find the largest integer in an array by static recursive method
 */
package T6;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB11 {
    
    // wrapper method, starts from index 0 (can start from last element too)
    private static int largest(int[] arr) {
        return largest(arr, 0);
    }
    
    // recursive method to find the maximal integer
    private static int largest(int[] arr, int start) {
        
        // set condition to jump out the recursion: index of the last element
        if(start < arr.length - 1) {
            return Math.max(arr[start], largest(arr, start + 1));
        }else {
            return arr[start];
        }    
    }
    
    public static void main(String[] args) {
        
        int[] arr = new int[10];
        System.out.println("Array => ");
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(" " + arr[i]);
        }
        System.out.println("\nArray length: " + arr.length);
        System.out.println("Largest int: " + largest(arr));
    }
}
