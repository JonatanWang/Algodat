/*
 * Coin change DP
 */
package T13;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB43 {
    
    private static final int[] CURRENCY = {1000, 500, 100, 50, 20, 10, 5, 1};
    private static final int[] CURRENCY2 = {25, 10, 1};
    
    private static int change(int sum) {
    
        // array to store result
        int[] res = new int[sum + 1];
        // init res
        for(int i = 0; i < res.length; i ++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[0] = 0;
        
        int[][] list = new int[CURRENCY.length][1];

        for(int j = 1; j <= sum; j ++) {
            
            // traverse all units less than j
            for (int k = 0; k < CURRENCY.length; k ++) {
                
                if(CURRENCY[k] <= j) {
                    
                    int tmp = res[j - CURRENCY[k]];
                    if(tmp != Integer.MAX_VALUE && (tmp + 1) < res[j]) {
                        
                        res[j] = tmp + 1;
                        list[k][0] ++;
                    }
                }
            }
        }
        for(int i = 0; i < CURRENCY.length; i ++) {
            System.out.print(i + " " + list[i][0]);
        }
        return res[sum];
    }    
    
    public static void main(String[] args) {
         
        int sum = 789;
        int sum2 = 30;
        System.out.println("Total number of notes/coins: " + change(sum));
    }
}
