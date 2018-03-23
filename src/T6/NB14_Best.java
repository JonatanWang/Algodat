/*
 * Mynt maskin, NB: lösning
 */
package T6;

import java.util.Scanner;

/**
 * Nicklas' solution
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB14_Best {
    
    private static int coins(int points, int target, int totalValue) {
       
        if (points > target) {
            return Integer.MAX_VALUE;
        }
        if (points == target) {
            return totalValue;
        }
        return Math.min(coins(points * 3, target, 10 + totalValue), 
                coins(points + 4, target, 5 + totalValue));
    }
    
    public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int totalValue = 0;
 
        System.out.println("Minimal result = " + coins(1, target, totalValue));
    }
}
