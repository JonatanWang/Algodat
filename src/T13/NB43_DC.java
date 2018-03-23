/*
 * Coin change DC
 */
package T13;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB43_DC {
    
    private static int change(int sum, int[] currency) {
    
        int n = currency.length;
        int rs;
        int[] res = new int[n];
        int[] tmp = new int[n];
        int k;
        
        if(sum == 0) {
            return 0;
        }
        
        for(int i = 0; i < res.length; i ++) {
            res[i] = -1;
        }
        
        for(k = 0; k < n; k ++) {
        
            if(currency[k] <= sum) {
                
                tmp[k] = change(sum - currency[k], currency);
                res[k] = tmp[k] + 1;
            }
        }
        
        rs = -1;
        for(k = 0; k < n; k ++) {
            if(res[k] >= 0) {
                if(rs == -1 && res[k] < rs) {
                    rs = res[k];
                }
            }
        }
        return rs;
    }
        
    public static void main(String[] args) {
        
        int[] CURRENCY = {1000, 500, 100, 50, 20, 10, 5, 1};
        int[] CURRENCY2 = {25, 10, 1};
    
        int sum = 789;
        int sum2 = 30;
        System.out.println("Total number of notes/coins: " + change(sum, CURRENCY));
    }
}
