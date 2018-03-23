/*
 * Floyd-Warshall Algorithm Implementation
 */
package T14;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Floyd {
  
    private int[][] graph;  // symmetriscal adjacent matrix
    private static final int X = Integer.MAX_VALUE;
    
    public Floyd(int[][] graph) {
        this.graph = graph;
    }
    
    public int[][] getShortestPath() {
        
        int n = graph.length;           // lenght of graph = num of vertices
        int k, i, j;
        int[][] path = new int[n][n];   // previous nodes
        for(i = 0; i < n; i ++) {
            for(j = 0; j < n; j ++) {
                path[i][j] = j;
            }
        }
        // Floyd algorithm
        for(k = 0; k < n; k ++) {
            for(i = 0; i < n; i ++) {
                for(j = 0; j < n; j ++) {
                    
                    if(graph[i][k] < X &&
                            graph[k][j] < X &&
                            graph[i][j] > graph[i][k] + graph[k][j]) {
                        
                        graph[i][j] = graph[i][k] + graph[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
          // print out
        System.out.println("\nPrevious nodes");
        for(i = 0;i < n;i ++)
                System.out.println(Arrays.toString(path[i]));
        
        return graph;
    }
}












