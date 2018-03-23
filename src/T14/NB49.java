/*
 * Knapsack DP
 */
package T14;

import static java.lang.Math.max;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB49 {
    
    private static final int W = 15; // knapsack max weight
    private static final int NUM = 3; // number of kinds of commodities

    /**
     * find max value that can be obtained by a knapsack of max weight W
     * @param W max weight of knapsack
     * @param weight    
     * @param value
     * @param n number of items
     * @return 
     */
    private static int knapsackNaive(int W, int[] weight, int[] value, int n) {
        
        // base case
        if(n == 0 || W == 0) {
            return 0;
        }
        
        // if when n:th item added, the total weight is larger than W, it should be removed
        if(weight[n - 1] > W) {
            
            return knapsackNaive(W, weight, value, n - 1);
        } else {
            /**
             * 2 situations:
             * 1). n:th item added
             * 2). n:th item not added
             * choose the larger value of the 2 situations
             */
             return max(knapsackNaive(W, weight, value, n - 1), 
                     knapsackNaive(W - weight[n - 1], weight, value, n - 1) + value[n - 1]);
        }
    }
    
    /**
     * find max value that can be obtained by a knapsack of max weight W
     * @param W max weight of knapsack
     * @param weight    
     * @param value
     * @param N number of items
     * @return 
     */
    private static int knapsackDP(int W, int[] weight, int[] value, int N) {
    
        int i, j;
        int dp[][] = new int[N + 1][W + 1];
        
        // if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            dp[0][col] = 0;
        }
        // if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        
        // build dp table bottom up
        for(i = 1; i <= N; i ++) {
            for(j = 1; j <= W; j ++) {
                
                // base case
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    
                    dp[i][j] = Math.max(dp[i - 1][j], 
                            value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.println("dp -> " + dp[i][j]);
            }
        }
        return dp[N][W];
    }
    
    public static void main(String[] args) {
        
        int W = 15;
        int[] value = {10, 3, 1};
        int[] weight = {4 ,2, 1};
        int n = weight.length;
        
        System.out.println("max value = " + knapsackDP(W, weight, value, n));
        System.out.println("knapsack naive, max value = " + knapsackNaive(W, weight, value, n));
    }
}
