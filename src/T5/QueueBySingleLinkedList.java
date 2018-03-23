/*
 * Queue implemented by single linked list
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class QueueBySingleLinkedList<E> {
    
    private class Node<E> {
        
        private E data;
        private Node<E> next;
        
        public Node (E data) {
            this.data = data;
        }
    }
    
    private Node<E> front, rear;
    private int size;
    
    public QueueBySingleLinkedList() {
        front = rear = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        return size;
    }
    
    /**
     * enqueue() / offer()
     * @param e
     * @return 
     */
    public boolean enqueue(E e) {
        Node<E> node = new Node(e);
        if(rear != null) {
            rear.next = node;
        }
        rear = node;
        
        if(front == null) {
            front = node;
        }
        size ++;
        return true;
    }
    
    /**
     * dequeue() / poll()
     * @return 
     */
    public E dequeue() {
//        if(size() == 0) {
//            return null;
//        }
        E res = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        size --;
        return res;
    }
    
    public E peek() {
        return front.data;
    }
    
    public E peekRear() {
        if(size == 0) {
            return null;
        }
        return rear.data;
    }
}
