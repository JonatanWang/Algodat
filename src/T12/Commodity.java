/*
 * Commodity with prices and values
 */
package T12;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Commodity implements Comparable<Commodity> {

    private int price;
    private int weight;
    private int ratio;
    private String name;
    
    public Commodity(String name, int p, int w) {
        this.name = name;
        this.price = p;
        this.weight = w;
        // Times 100 to compare by integer
        this.ratio = (int) (100 * this.price / this.weight);    
    }

    /**
     * In order to compare ratio, to use Arrays.sort or Collections.sort
     * @param c
     * @return 
     */
    @Override
    public int compareTo(Commodity c) {
        // descending order is desired
        return c.ratio - this.ratio;
    }
    
    @Override
    public String toString() {
        return "[" + name + ", " + price +", " + weight + ", " + ratio + "]";
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
