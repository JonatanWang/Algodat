/*
 * coin macine BFS
 */
package T7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB16 {
    
    private static int coins(int target) {
        
        Queue<State> q = new LinkedList<>();
        State s = new State(1, 0, target);
        q.add(s);
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) { // t.points != goal
            
            State current = q.peek();
            if(current.display == s.target && min > current.coins) {
                min = current.coins;
            }
            
            if(current.display * 3 < s.target) {
                int newDisplay = current.display * 3;
                int newCoins = current.coins + 10;
                q.offer(new State(newDisplay, newCoins, s.target));
            }
            
            if(current.display + 4 <= s.target) {
                int newDisplay = current.display + 4;
                int newCoins = current.coins + 5;               
                q.offer(new State(newDisplay, newCoins, s.target));
            }
            q.poll();   // t.cost;
        }
        
        return min;
    }
    
    /**
     * A Classmate's solution
     * public static int myntMaskin(int goal) {
     *  Queue<Tillstand> q = new LinkedList<>();
     *  Tillstand t = new Tillstand(1, 0);
     * while(t.points != goal) {
     *  q.offer(new Tillstand(t.points + 4, t.cost + 5);
     *  q.offer(new Tillstand(t.points + 3, t.cost + 10);
     *  t.poll();
     * }
     * return t.cost;
     */
    
    private static class State {
        
        public int display;
        public int coins;
        public int target;
        
        public State(int display, int coins, int target) {
            this.display = display;
            this.coins = coins;
            this.target =  target;
        }
    }
    
        public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
 
        System.out.println("Minimal result = " + coins(target));
    }
}
