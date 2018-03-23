/*
 * travelling salesman DP
 */
package T14;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB52 {
    
    public static void main(String[] args) {
        
        int[][] V = {{0,0,0}, 
                     {0,0,1}, 
                     {0,0,2}, 
                     {0,0,3}, 
                     {0,1,2}, 
                     {0,1,3}, 
                     {0,2,3}, 
                     {1,2,3}}; 
        
        int[][] c = {{0,3,6,7}, 
                     {5,0,2,3}, 
                     {6,4,0,2}, 
                     {3,7,5,0}};
        
        int[][] d = new int[c.length + 1][V.length + 1];
    
        for(int i = 0; i < c.length; i ++) {
            for(int j = 0; j < V.length; j ++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        d[c.length - 1][V.length - 1] = 0;
        int n = c.length;
        System.out.println("n = " + n + " V.len = " + V.length + " c.len = " + c.length);
        System.out.println("shortest dist = " + tsp(d, c, V, n));
    }
    
    // check if i is included in array a
    private static boolean isIncluded(int x, int[] a) {
        
        for(Integer integer : a) {
            if(integer != x)
                return false;
        }
        return true;
    }
    
    // implement the search in V'-{k} 
    private static int remainedNode(int k, int[] a, int[][] V) {
        
        int index = 0; 
        int[] aCnt = new int[a.length  + 1];
        int[] vCnt = new int[a.length  + 1];
        int[] tmp = new int[a.length  + 1];;
        for(int j = 0; j < a.length; j ++) {
            aCnt[j] = 0; vCnt[j] = 0; tmp[j] = a[j];
            if(tmp[j] == k) {
                tmp[j] = 0; // remove node k from the set
            } 
        }
        
        for(int j = 0; j < a.length; j ++) {
            if(tmp[j] == j) {
                aCnt[j] ++;
            } else {
                aCnt[j + 1] ++;
            }
        }
        
        for(index = 0; index < V.length; index ++) {
            for(int j = 0; j < a.length; j ++) {
                if(V[index][j] == j) {
                    vCnt[j] ++;
                }else {
                    vCnt[j + 1] ++;
                }
            }
                    
            for(int j = 0; j <= a.length; j ++) {
                if(aCnt[j] == vCnt[j]) {
                    return index;
                }
                vCnt[j] = 0;
            }
        }       
        return 0;
    }
    
    private static int tsp(int[][] d, int[][] c, int[][] V, int n) {
        
        int i = 0; int j = 0; int k = 0;
        int comb = V.length - 1;
        
        for(i = 1; i < n; i ++) {
            d[i][0] = c[i][0];
        }
        
        // traverse different sets: {1}{2}{3}{1, 2} {2, 3} {1, 3}, {1, 2, 3}
        for(j = 1; j < comb; j ++) {
            
            // traverse different nodes
            for(i = 1; j < n; i ++) {
                
                // i should not be included in the set
                if(!isIncluded(i, V[j])) {
                    
                    // check each node in V[j], get the min value
                    for(k = 0; k < (n - 1); k ++) {
                        
                        if(V[j][k] != 0 &&
                                (c[i][V[j][k]] + d[V[j][k]][remainedNode(V[j][k], V[j], V)]) < d[i][j]) {
                            d[i][j] = c[i][V[j][k]] + d[V[j][k]][remainedNode(V[j][k], V[j], V)];
                        }
                    }
                }
            }
        }
        
        // 分别试探下一步为集合中的任何一点，取最小值 
        for(k = 0; k < (n - 1); k ++) {
            
            if(V[comb][k] != 0 &&
                    c[0][V[comb][k]] + d[V[comb][k]][remainedNode(V[comb][k], V[comb], V)] < d[0][comb]) {
                d[0][comb] = c[0][V[comb][k]] + d[V[comb][k]][remainedNode(V[comb][k], V[comb], V)];
            }
        }
        return d[0][comb];
    }
}
