/*
 * Test recursive getNode(int index) & size() for single linked list
 */
package T7;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB17 {
    
    public static void main(String[] args) {
        
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("Hej");
        list.add("på");
        list.add("dig");
        System.out.println("1st: "+ list.getNode(0).getData()
                + "; 2nd: " + list.getNode(1).getData()
                + "; 3rd: " + list.getNode(2).getData());
        System.out.println("size() = " + list.size());
    }
}
