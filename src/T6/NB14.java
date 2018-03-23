/*
 * Coin machine 10, 5
 * Genom en 10-öring multipliceras poängen på displayen med 3.
 * Genom en 5-öring adderas 4 till poängen på displayen.
 */
package T6;

import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB14 {
    
    private static int res = 0;
    private static int minRes = 0;
    
    public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        // Start with 10 öre
        findCoin(1,1,target);
        // Reset res
        res = 0;
        // Start with 5 öre
        findCoin(1,2,target);
        System.out.println("Minimal result = " + minRes);
    }

    /**
     * 1 => 10 öre, 2 => 5 öre
     * 1 * 3 * 3 = 9; 1 + 4 + 4 = 9; 
     * @param current
     * @param type
     * @param target 
     */
    private static void findCoin(int current, int type, int target) {
        
        if(type == 1) {
            current *= 3;
            res += 10;
        }
        if (type ==2) {
            current += 4;
            res += 5;
        }
        if (current == target) {
            if(res < minRes || minRes == 0) {
                minRes = res;
            }
        }
        if (current < target) {
            findCoin(current, 1, target);
            res -= 10;
            findCoin(current, 2, target);
            res -= 5;
        }
    }
}
