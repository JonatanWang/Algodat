/*
 * Maximal delsekvens
 */
package T13;

import static java.lang.Math.max;
import java.util.Random;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB41 {
    
    private static int maxIntervalSum(int[] a) {
       
        if(a.length == 0) {
            return 0;
        } 
        return maxIntervalSum(a, 0, a.length -1);
    }

    private static int maxIntervalSum(int[] a, int left, int right) {
        
        if(left > right) {
            return 0;
        }
        if(left == right) {
            return max(0, a[left]);
        }
        
        int center = (left + right) / 2;
        int sum = 0, maxLeft = 0, maxRight = 0;
        for(int i = center; i >= left; i --) {
            
            sum += a[i];
            maxLeft = max(sum, maxLeft);
        }
        sum = 0;
        for(int i = center + 1; i <= right; i ++) {
            sum += a[i];
            maxRight = max(sum, maxRight);
        }
        int maxOverMid = maxLeft + maxRight;
        return max(max(maxOverMid, maxIntervalSum(a, left, center)), 
                maxIntervalSum(a, center + 1, right));
    }
    
    public static void main(String[] args) {
        
        int[] a = new int[1000];
        for(int i = 0; i < a.length; i ++) {
            Random random=new Random();
            a[i] = (int) random.nextInt(2000) - 1000;
            System.out.print(a[i] + " ");
        }
        
        int maxIntervalSum = maxIntervalSum(a);
        System.out.println("\nSum: " + maxIntervalSum);
    }
}
