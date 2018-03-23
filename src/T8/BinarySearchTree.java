/*
 * BST generic
 */
package T8;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {
        
        private Node<E> left;
        private Node<E> right;
        private E data;
        
        private Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }
            
        @Override
        public String toString() {
            return data.toString();
        }
    }
    
    private Node<E> root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
    
    /**
     * First left, then node it self, to the last right part
     * @param node
     * @param sb 
     */
    private void inOrder(Node<E> node, StringBuilder sb) {
        
        if(node != null) {  // if node == null, finished
            inOrder(node.left, sb);
            sb.append(": ").append(node.toString());
            inOrder(node.right, sb);
        }
    }
    
    public String preOrderToString() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
   
    /**
     * First node, then node left part tree, then node right part tree
     * @param node
     * @param sb 
     */
    private void preOrder(Node<E> node, StringBuilder sb) {
        
        if(node != null) {
            sb.append(": ").append(node.toString());
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    
    public String postOrderToString() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }
   
    /**
     * First left part, then right part, to the last the node itself(root)
     * @param node
     * @param sb 
     */
    private void postOrder(Node<E> node, StringBuilder sb) {
        
        if(node == null) {
            return;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(": ").append(node.toString());
    }

    public boolean add(E data) {
        
        if(root == null) {
            root = new Node(data);
            return true;
        } else {
            return add(data, root);
        }
    }
    
    private boolean add(E data, Node<E> node) {
        
        if(data.compareTo(node.data) == 0) {
            return false;   // key already exists in the tree, 
                            //not allowed to have two keys of same value
        } else if(data.compareTo(node.data) < 0) {
            
            if(node.left == null) {
            
                node.left = new Node(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else {
            if(node.right == null) {
                node.right = new Node(data);
                return true;
            }else {
                return add(data, node.right);
            }
        } 
    }
    
    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        
        if(node == null) {
            return null;
        }
        if(target.compareTo(node.data) == 0) {
            return node.data;
        } 
        
        if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        } 
        return find(target, node.right);
    }
    
    // wrapper: begin from the root
    public int numberOfNodes() {
        return numberOfNodes(root);
    }
    
    // if node != null, +1 and search node.left & node.right...
    private int numberOfNodes(Node<E> node) {
        
        if(node == null) {
            return 0;
        } else {
            return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
        }
    }
    
    // wrapper: begin from root
    public int numberOfLeaves() {
        return numberOfLeaves(root);
    }
    
    // if both node.left & right == null, +1. Otherwise serach left & right downwards
    private int numberOfLeaves(Node<E> node) {
        
        if(node == null) {
            return 0;
        } else if(node.left == null && node.right == null) {
            return 1;
        } else {
            return numberOfLeaves(node.left) + numberOfLeaves(node.right);
        }
    }
}
