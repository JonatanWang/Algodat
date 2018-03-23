/*
 * Edge weighted
 */
package T11;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Edge {
    
    private int vertex;
    private int weight;
       
    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        
        return "(" + (char) ('A' + vertex) + ", " + weight + ")";
    }
}
