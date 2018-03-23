/*
 * Coin Machine
 */
package T6;

import java.util.Scanner;

/**
 * wrong if target == 3
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB14_2 {
    
    private static int getMinCoins(int target) {
        if(target <= 1) {
            return (Math.abs(target) / 10 == 0? 10 : 5);
        } else
        if(target / 3 < target - 4) {
            return 10 + getMinCoins(target / 3);
        }
        else if(target / 3 > target - 4) {
            return 5 + getMinCoins(target - 4);
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        System.out.print("Input targeted value: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        System.out.println("Target value " + target + 
                " reaches by " + getMinCoins(target));
    }
}
