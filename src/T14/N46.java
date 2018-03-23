/*
 *  beräknar högsta summan man kan få genom 
 * att lägga ihop talen längs valfri väg 
 * från toppen av en taltriangel till botten.
 */
package T14;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N46 {
    
    private static final int X = - 1 * Integer.MAX_VALUE;
    
    // simple recursive wrapper
    private static int highestSumRecursive(int[][] a) {
        
        return highestSumRecursive(a, 0, 0);
    }

    // Recursive
    private static int highestSumRecursive(int[][] a, int i, int j) {
        
        int max = 0;
        
        max = a[i][j] + (i == a.length - 1? 0 : Math.max(highestSumRecursive(a, i + 1, j), 
                highestSumRecursive(a, i + 1, j + 1)));
        
        return max;
    }
    
    // DP topdown wrapper
    private static int maxSumDPTopdown(int[][] a) {
        
        int[][] s = new int[a.length + 1][a.length + 1]; 
        s[0][0] = 0;
        return maxSumDPTopdown(a, s, 0, 0);
    }

    // DP topdown
    private static int maxSumDPTopdown(int[][] a, int[][] s, int i, int j) {

        if(s[i][j] != 0) {return s[i][j];}
        s[i][j] = a[i][j] + (i == a.length - 1 ? 
                0 : Math.max(maxSumDPTopdown(a, s, i + 1, j), 
                maxSumDPTopdown(a, s, i + 1, j + 1)));

        return s[i][j];
    }
    
    // DP bottom up wrapper
    private static int maxSumDPBottomup(int[][] a) {
        
        //int[][] s = a;
        return maxSumDPBottomup(a, 0, 0);
    }
    
    // DP bottom up
    private static int maxSumDPBottomup(int[][] s, int i, int j) {
 
        for(i = s.length - 1; i > 0; i --) {
            for(j = 0; j < s[i].length - 1; j++) {
                s[i - 1][j] += Math.max(s[i][j], s[i][j + 1]);
            }
        }

        return s[0][0];
    }
        
    // tes main     
    public static void main(String[] args) {
               
        int[][] a = {   {7, X, X, X, X, X, X, X},
                        {3, 8, X, X, X, X, X, X},
                        {8, 1, 0, X, X, X, X, X},
                        {2, 7, 4, 4, X, X, X, X},
                        {4, 5, 2, 6, 5, X, X, X},
                        {1, 2, 3, 4, 5, 6, X, X},
                        {2, 3, 4, 5, 6, 7, 8, X},
                        {3, 4, 5, 6, 7, 8, 9, 0}};
        
        int[][] b = {{4, X, X, X, X},
                     {2, 1, X, X, X},
                     {2, 8, 1, X, X},
                     {3, 7, 1, 2, X},
                     {2, 4, 8, 5, 7}};
        
        long startTime = System.currentTimeMillis();
        System.out.println("max sum recursive: " + highestSumRecursive(b));         
        long endTime  = System.currentTimeMillis();
        System.out.println("recursive time(ms): " + 1000 * (endTime - startTime));
        
                
        startTime = System.currentTimeMillis();
        System.out.println("max sum dp top down: " + maxSumDPTopdown(b));              
        endTime = System.currentTimeMillis();
        System.out.println("dp top down time(ms): " + 1000 * (endTime - startTime));
        
        startTime = System.currentTimeMillis();
        System.out.println("max sum dp bottom up: " + maxSumDPBottomup(b));                
        endTime = System.currentTimeMillis();
        System.out.println("dp bottom up time(ms): " + 1000 * (endTime - startTime));
    }

}
