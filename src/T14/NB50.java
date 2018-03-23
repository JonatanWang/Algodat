/*
 * Hur många unika vägar finns det från övre högra hörnet till nedre vänstra hörnet 
 * om vi bara får gå väst och syd?
 * DP top down
 */
package T14;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB50 {
    
    private static int numPath(int i, int j) {
        
        int[][] s = new int[i + 1][j + 1];
        s[0][0] = 1;
        return numPath(s, i, j);
    }

    private static int numPath(int[][] s, int i, int j) {
        
        if(s[i][j] != 0) { return s[i][j];}
 
        int numPath = 0;
        
        if(i > 0) {
            numPath += numPath(s, i - 1, j);
        }
        if(j > 0) {
            numPath += numPath(s, i, j - 1);
        }     
        return numPath;
    }
    
    public static void main(String[] args) {

        System.out.println("Number of paths: " + numPath(5, 6));
    }
}
