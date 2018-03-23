/*
 * NB 22
 * Skriv funktioner som traverserar trädet med preOrder och postOrder.
 */
package T8;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB22 {
   
    public static void main(String[] args) {
        
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(6);
        tree.add(5);
        tree.add(1);
        tree.add(7);
        /**
         *              4
         *      2               6
         * 1        3       5       7
         */
        System.out.println("inOrder toString: " + tree.toString());
        System.out.println("preOrder toString: " + tree.preOrderToString());
        System.out.println("postOrder toString: " + tree.postOrderToString());
    }
}
