/*
 * Floyd Warshall
 */
package T14;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB48 {
    
    private static final int X = Integer.MAX_VALUE;
    private static int[][] path;
    private static int[][] dist;
    
    public static void main(String[] args) {
        
        int[][] w = {   {0, 2, 6, 4},
                        {X, 0, 3, X},
                        {7, X, 0, 1},
                        {5, X, 12, 0}};
                        
        // print out
        int n = w.length;
        System.out.println("\nGraph Weighted");
        for(int i=0;i < n;i ++)
                System.out.println(Arrays.toString(w[i]));
        
        path = new int[n][n];   // previous nodes: paths matrix
        dist = new int[n][n];   // shortest distances path matrix
        
        Floyd f = new Floyd(w);
        f.getShortestPath();
                
        // print out
        System.out.println("\nShortest Distance Table");
        for(int i=0;i < n;i ++)
                System.out.println(Arrays.toString(w[i]));
    }                   
}
