/*
 * Mynt maskin by Nikita
 */
package T6;

import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB14_Classmate {
    
    private static int coins(int currentPoint, int currentCost, int goal) {
        
        if(currentPoint > goal) {
            return -1;
        }
        if(currentPoint == goal) {
            return currentCost;
        }
        int cost1 = coins(currentPoint + 4, 5 + currentCost, goal);
        int cost2 = coins(currentPoint * 3, 10 + currentCost, goal);
        
        if(cost1 == -1 && cost2 == -1) {
            return -1;
        } else if(cost1 == -1) {
            return cost2;
        } else if (cost2 == -1) {
            return cost1;
        }
        
        return cost1 < cost2 ? cost1: cost2;
    } 
    
     public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int currentPoint = 1;
        int currentCost = 0;
        System.out.println("Minimal result = " + coins(currentPoint, currentCost, target));
    }
}
