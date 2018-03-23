/*
 * Coin Machine
 */
package T6;

import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB14_3 {
    
    private static int calCoins(int target) {
        
        if(target == 1) {
            return 0;
        }
        if (target < 1) {
            return 0;   // Or throw some exception
        }
        
        if(target % 3 != 0) {
            return 5 + calCoins(target - 4);
        } else {
            if(target - 4 >= 1) {
                int one = 5 + calCoins(target - 4);
                int two = 10 + calCoins(target / 3);
                return Math.min(one, two);
            } else {
                return 10 + calCoins(target / 3);
            }
        }
    }
    
    public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
 
        System.out.println("Minimal result = " + calCoins(target));
    }
}
