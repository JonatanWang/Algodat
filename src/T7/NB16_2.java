/*
 * BFS coin machine
 */
package T7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB16_2 {
    
    public static Queue<Integer> open = new LinkedList<Integer>();
    public static HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        
        System.out.print("Target: ");
        Scanner in = new Scanner(System.in);
        int goal = in.nextInt();
        open.offer(1);
        results.put(1, 0);
        searchBFS(goal);
        if (results.get(goal) == null) {
            System.out.println("No Solution");
        } else {
            System.out.println("Total coins: " + results.get(goal));
        }
    }

    public static void searchBFS(int goal) {
        while (true) {
            if (open.isEmpty())
                return;
            if (open.peek() * 3 <= goal) {
                open.offer(open.peek() * 3);
            if (results.get(open.peek() * 3) == null 
                    || results.get(open.peek()) + 10 < results.get(open.peek() * 3)) {
                
                    results.put(open.peek() * 3, results.get(open.peek()) + 10);
                }
            }
            if (open.peek() + 4 <= goal) {
                open.offer(open.peek() + 4);
                if (results.get(open.peek() + 4) == null
                        || results.get(open.peek()) + 5 < results.get(open.peek() + 4)) {
                    
                    results.put(open.peek() + 4, results.get(open.peek()) + 5);
                }
            }
            open.poll();
        }
    }
}

