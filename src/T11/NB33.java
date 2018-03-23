/*
 * Skriv en static metod som hittar det minsta uppspända trädet 
 * för en graf representerad med en förbindelsematris med hjälp av Prims algoritm. 
 * Funktionen skall ta en förbindelsematris som input och returnera en int-array p, 
 * där p[v] anger den nod som noden v anslöts till enligt algoritmen.
 * Skriv också en main där du använder den hårdkodade matrisen från föreläsningen 
 * och anropar din funktion (funktionen skall fungera för godtycklig förbindelsematris 
 * av godtycklig dimension). 
 * Skriv ut resultatet i main på formatet:
 * Node A var startnod 
 * Nod F anslöts till A 
 * Nod D anslöts till F 
 * Nod B anslöts till A 
 * Nod C anslöts till B 
 * Nod H anslöts till C 
 * Nod E anslöts till C 
 * Nod G anslöts till F 
 * TotalVikt: 15
 * (obs att det finns fler korrekta lösningar med avseende på hur man ansluter noderna)
 */
package T11;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB33 {
    
    private static final int X = Integer.MAX_VALUE;
    
    private static void primMST(int[][] graph) {
        
        int n = graph.length;
        
        // array p saves the MST
        int[] p = new int[n];
        
        // vertices used to find min weight edges
        int[] v = new int[n];
        
        // flags used to note MST-unsettled vertices
        boolean[] flag = new boolean[n];
        
        // init
        for(int i = 0; i < n; i ++) {
            v[i] = X;
            flag[i] = false;
        }
        
        // begin with first vertex
        v[0] = 0;
        p[0] = -1;
        
        for (int i = 0; i < n - 1; i ++) {
            
            // find the min vertex from those vertices unsettled in the flag set
            int u = minV(v, flag, n);
            
            // add the selected vertex into the flag set
            flag[u] = true;
            
            // update v and p, considering only those not settled in flag set
            for (int j = 0; j < n; j ++) {
                
                if (graph[u][j] != X &&
                        flag[j] == false &&
                        graph[u][j] < v[j]) {
                    p[j] = u;   // set the minIndex in array p
                    v[j] = graph[u][j];
                }
            }
        }
        printMST(p, n, graph);
    }

    // find the adjacent vertex with the min weight of edge
    private static int minV(int[] v, boolean[] flag, int numV) {
    
        // init
        int min = X; 
        int minIndex = - 1;
        
        for(int i = 0; i < numV; i ++) {
            
            if(flag[i] == false && v[i] < min) {
                
                min = v[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    /**
     * print out result
     * @param p
     * @param n
     * @param graph 
     */
    private static void printMST(int p[], int n, int graph[][]) {
        
        System.out.println("Edge\t\t Weight");
        System.out.println("Node " + (char)('A' + p[1]) + " was start node");
        int totalWeight = 0;
        for(int i = 1;i < n; i ++) {
            totalWeight += graph[i][p[i]];
            System.out.println("Node " + (char)('A' + p[i]) + " - " + "node " + (char)('A' + i) 
                    + "\t " + graph[i][p[i]]);
        }
        System.out.println("Total Weight: " + "\t" + totalWeight);
    }
    
    public static void main(String[] args) {
        
        int[][] graph = {{X, 2, X, X, X, 1, X, X}, 
                         {2, X, 2, 2, 4, X, X, X}, 
                         {X, 2, X, X, 3, X, X, 1}, 
                         {X, 2, X, X, 3, 1, X, X}, 
                         {X, 4, 3, 3, X, X, 7, X}, 
                         {1, X, X, 1, X, X, 5, X}, 
                         {X, X, X, X, 7, 5, X, 6}, 
                         {X, X, 1, X, X, X, 6, X}};
        
        primMST(graph);
    }
}
