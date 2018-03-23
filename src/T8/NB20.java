/*
 * Coin machine 10, 5
 * Genom en 10-öring multipliceras poängen på displayen med 3.
 * Genom en 5-öring adderas 4 till poängen på displayen.
 */
package T8;

import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB20 {
    
    private static int res = 0;     // Result of minimal coin value
    private static int minRes = 0;  // minimal coin value
    private static int cnt = 0;     // counter of solutions
    
    public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        // Start with 10 öre
        findCoin(1,1,target, "");
        // Reset res
        res = 0;
        // Start with 5 öre
        findCoin(1,2,target, "");
        System.out.println("Best result = " + minRes);
    }

    /**
     * 1 => 10 öre, 2 => 5 öre
     * 1 * 3 * 3 = 9; 1 + 4 + 4 = 9; 
     * @param current
     * @param type
     * @param target 
     * @param s steps
     */
    private static void findCoin(int current, int type, int target, String s) {
        
        if(type == 1) {
            current *= 3;
            res += 10;
            s = s + "10->"; // add 10->
        }
        if (type == 2) {
            current += 4;
            res += 5;
            s = s + "5->";  // add 5->
        }
        if (current == target) {    // reach the target
            if(res < minRes || minRes == 0) {
                minRes = res;       
            }
            cnt ++; // solution number + 1
            System.out.println("Solution " + cnt + ": " + s);   // print the solution
        }
        if (current < target) { // backtracking...
            findCoin(current, 1, target, s);
            res -= 10;
            findCoin(current, 2, target, s);
            res -= 5;
        }
    }
}
