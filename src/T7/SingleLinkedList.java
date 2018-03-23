/*
 * Vår enkellänkade lista
 */
package T7;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <T>
 */
public class SingleLinkedList<T> {

    public Node<T> getNode(int index) {
        if(head == null) {
            return null;
        }
        return getNode(head, index);
    }

    private Node<T> getNode(Node<T> head, int index) {
        Node<T> tmp = head;
        if(index == 0) {
            return tmp;
        } else {       
            return getNode(tmp.next, index - 1);
        }
    }
    
    public int size() {
        return size(head);
    }

    private int size(Node<T> head) {
        Node<T> tmp = head;
        if (tmp == null) {
            return 0;
        }
        return 1 + size(tmp.next);
    }

    public class Node<T> {
    
        private T data;
        private Node<T> next;
        
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        
        public T getData() {
            return this.data;
        }
    }
    
    private Node<T> head;
    private int size;
    
    public SingleLinkedList() {
        head = null;
        size = 0;
    }
    public void add(int index, T item) { 
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index)); 
        }
        if (index == 0) {
            addFirst(item); 
        } else {
            Node<T> node = getNode(index - 1);
            addAfter(node, item); 
        }
    }
    
    public void addFirst(T item) {
        head = new Node<>(item, head);
        size++; 
    }
    
    private void addAfter(Node<T> node, T item) {
        node.next = new Node<>(item, node.next);
        size++; 
    }
    
    public boolean add(T item) {
        add(size, item);
        return true;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> node = getNode(index);
        return node.data;
    }
}
