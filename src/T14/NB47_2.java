/*
 * Coin change DP, top down
 */
package T14;

import java.util.HashMap;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB47_2 {
    
    private static int change(int target, int[] currency, HashMap<Integer, Integer> map, int[] plan) {
        
        // base case
        if(target == 0) {return 0;}
        
        // if result exists, return result
        if(map.containsKey(target)) {return map.get(target);}
        
        // traverse all currencies and check which one is the best choice
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < currency.length; i ++) {
            
            if(currency[i] > target) {continue;}    // if a currency larger than target, continue
            
            int value = change(target - currency[i], currency, map, plan);
            
            /**
             * if value by adding currency[i] for currency total value is less than
             * value found so far, make it min
             */
            if(value < min) { min = value;}
        }
                    
            // if min == MAX, keep it; otherwise add 1
            min = (min == Integer.MAX_VALUE) ? min : min + 1;
            
            // memorize current value
            map.put(target, min);
            return min; 
    }
    
    public static void main(String[] args) {
        
        int[] CURRENCY = {1000, 500, 100, 50, 20, 10, 5, 1};
        int[] CURRENCY2 = {25, 10, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = CURRENCY.length;
        int[] plan = new int[n];
        int sum = 789;
        int sum2 = 30;
      
        System.out.println("Total number of notes/coins: " + 
                change(sum, CURRENCY, map, plan));
                    
        for(int i = 0; i < plan.length; i ++) {System.out.print(plan[i] + " ");}
    }
}
