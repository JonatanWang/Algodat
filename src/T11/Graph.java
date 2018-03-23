/*
 * Graph weighted
 */
package T11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Graph {
    
    private static final int INF = Integer.MAX_VALUE;
    private List<Edge> graph[];
    private String dir;
    
    /**
     * test constructor
     * @param n 
     */
    public Graph(int n) {
        
        this.graph = new LinkedList[n];
        for(int i = 0; i < graph.length; i ++) {
            graph[i] = new LinkedList<>();
        }
    }
    
    /**
     * constructor
     * @param dir 
     */
    public Graph(String dir) {
        this.dir = dir;
        try {   // read in file
            BufferedReader in = new BufferedReader(new FileReader(dir));
            int numLines = 0;
            String line = "";
            Queue<String> tokens = new LinkedList<>();
            while((line = in.readLine()) != null) {
                tokens.offer(line);
                numLines ++;
            }
            // construct the graph
            this.graph = new LinkedList[numLines];
            for(int i= 0; i < graph.length; i ++) {
                graph[i] = new LinkedList<>();
                String[] item = tokens.poll().split(" ");
                for(int j = 0; j < item.length - 1; j += 2) {
                    graph[i].add(new Edge(Integer.valueOf(item[j]), 
                                    Integer.valueOf(item[j + 1])));
                }
            }
        } catch(IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
    
    /**
     * construct edge/graph by start-, end nodes and weight
     * @param u
     * @param v
     * @param w 
     */
    public void addEdge(int u, int v, int w) {
        graph[u].add(0, new Edge(v, w));
    }
    
    /**
     * check if two nodes are directly connected
     * @param u
     * @param v
     * @return 
     */
    public boolean isConnected(int u, int v) {
        System.out.print((char) ('A' + u) 
                + " and " 
                + (char) ('A' + v) 
                + " is connected? ");
        return graph[u].stream().anyMatch((e) -> (e.getVertex() == v));
    }
    
    /**
     * get the weight between 2 nodes: 0 if same node, INF if unconnected
     * @param u
     * @param v
     * @return 
     */
    public int getWeight(int u, int v) {
        
        if(u == v) {
            return 0;
        } 
        // check if node v exists in list u i.e. if they are connected
        // edges in file is not ordered, so a loop is need to test
        for(int i = 0; i < graph[u].size(); i ++) {
            if(graph[u].get(i).getVertex() == v) {
                return graph[u].get(i).getWeight();
            } 
        }     
        return INF;
    }
    
    /**
     * find arbitrarily 2 nodes min distance/weight by Dijkstra's algorithm
     * @param u start node
     * @param v end node
     * @return a string of route
     */
    public String shortestRoute(int u, int v) {
      
        int n = graph.length;
        // 前驱顶点数组。即，prev[i]的值是"顶点u"到"顶点v"的最短路径所经历的全部顶点中，位于"顶点v"之前的那个顶点
        int[] prev = new int[n];    // previous nodes before shorted path is found
        // 长度数组。即，dist[v]是"顶点u"到"顶点v"的最短路径的长度
        int[] dist = new int[n];    // distances shortest between u and v
        // flag[v]=true表示"顶点u"到"顶点v"的最短路径已成功获取
        boolean[] flag = new boolean[n];    // flags marking if a node's shortest path is found
        
        // init values
        for(int i = 0; i < graph.length; i ++) {
            flag[i] = false;    // 顶点i的最短路径还没获取到
            prev[i] = 0;        // 顶点i的前驱顶点为0
            dist[i] = getWeight(u, i);  // 顶点i的最短路径为"顶点u"到"顶点i"的权
        }
        
        // 对"顶点u"自身进行初始化
        // init node u
        flag[u] = true;     // start->start, always true
        dist[u] = 0;        // start->start, distance always 0
        
        int k = 0;
        // 遍历n-1次；每次找出一个顶点的最短路径
        // traverse n - 1 times, find the shortest path for one node every time
        for(int i = 1; i < n; i ++) {
            int min = INF;
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离u最近的顶点(k)
            /**
             * find the current shortest path, i.e. find the nearest node k to u
             * among those nodes which have not obtained shortest paths
             */
            for(int j = 0; j < n; j ++) {
                if(flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            
            // 标记"顶点k"为已经获取到最短路径
            // mark vertex k as having obtained shortest path
            flag[k] = true;
        
            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"
            /**
             * adjust current shortest path and previous vertices
             * i.e. when having found vertex k's shortest path, update the 
             * shortest paths and previous vertices of those vertices, which
             * have not obtained shortest paths
             */
            for(int j = 0; j < n; j ++) {

                int tmp = getWeight(k, j);
                tmp = (tmp == INF ? INF : (min + tmp));
                if(flag[j] == false && tmp < dist[j]) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        
        // prepare mininal weight of the shortest path u -> v
        String minWeight = String.valueOf(dist[v]);
        // prepare previous vertex of vertex v
        String prevNode = String.valueOf(prev[v]);
        
        // print previous vertices array
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        for(int i = 0; i < prev.length; i ++) {
            sb.append(prev[i]).append(" ");
        }
        sb.append("] ");
        
        // prepare route from last vertex v to first vertex u, stack LIFO
        Stack<Integer> route = new Stack<>();
        route.push(v);
        int p = prev[v];
        while (p != 0) {
            int nextP = prev[p];
            route.push(p);
            p = nextP;
        }
        route.push(u);

        StringBuilder rt = new StringBuilder();
        while(!route.empty()) {
            rt.append((char)('A' + route.pop())).append(" -> ");
        }
        
        return "Min weight: " + minWeight + " | " 
                + "Previous node: " + prevNode + " | " 
                + "Prev node array: "  + sb.toString()
                + "Route: " + rt.toString() + "\n";
    }
    
    @Override
    public String toString() {
        
        String res = "";
        for(int i = 0; i < graph.length; i ++) {
            res += (char) ('A' + i) + "" + i + " -> " + graph[i] + "\n";
        }
        return res;
    }
}
