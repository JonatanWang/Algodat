/*
 * find longest increasing sequence
 */
package T14;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB51 {
    
    public static void main(String[] args) {
        
        int[] a = {5, 2, 8, 6, 3, 6, 9, 7};
        System.out.println("Longest interval: " + lis(a));
    }

    private static int lis(int[] a) {
        
        if(a == null || a.length == 0) {return 0;}
        
        int n = a.length; int res = 0;
        
        // init dp, each element == 1 as one digit itself is a sequence of length 1
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                if(a[i] < a[j] && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
