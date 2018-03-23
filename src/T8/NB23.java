/*
 * Skriv två funktioner numberOfLeaves och numberOfNodes till 
 * vår implementation från föreläsningen. 
 * Obs de ska bestämma antalet utifrån trädet och inte använda privata medlemsvariabler.
 */
package T8;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB23 {
     
    public static void main(String[] args) {
        
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        /**
         *              4
         *      2               6
         * 1        3       5       7
         */
        System.out.println("Number of Nodes: " + tree.numberOfNodes());
        System.out.println("Number of Nodes: " + tree.numberOfLeaves());
    }
}
