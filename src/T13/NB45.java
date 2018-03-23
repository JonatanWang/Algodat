/*
 * Find Majority Element
 */
package T13;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB45 {
    
    private static int findMajority(int[] a) {
        
        int n = a.length;
        
        if (n == 1) {
            return a[0];
        }
        
        if(n == 2) {
            
            if(a[0] == a[1]) {
                return a[0];
            } else {
                return -1;
            }
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid + 1, n);
        int e1 = findMajority(left);
        int e2 = findMajority(right);
        
        return merge(e1, e2);
        
    }
    
    public static void main(String[] args) {
        
        int[] a = {8, 8, 6, 8, 6, 6, 8, 6, 8, 6, 6};
        System.out.println("majority = " + findMajority(a));
    }

    private static int merge(int e1, int e2) {
        
        if(e1 == e2) {
            return e1;
        } 
        
        if(e1 == -1 && e2 >= 0) {
            return e2;
        } 
        
        if (e1 >= 0 && e2 == -1) {
            return e1;
        } 
        return -1;   
    }
}
