/*
 * Queue by Double linked list
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class QueueByDoubleLinkedList<E> {
    
    private class Node<E> {
        
        private E data;
        private Node<E> prev;
        private Node<E> after;
        
        private Node(E data) {
            this.data = data;
        }
    }
    
    private Node<E> first, last;
    
    public QueueByDoubleLinkedList() {
        first = last = null;
    }
    
    public boolean offerFirst(E e) {
        Node<E> node = new Node<>(e);
        if(first == null) {
            first = node;
            last = node;
            first.after = last;
            last.prev = first;
        } else {
            Node<E> newFirst = node;
            newFirst.after = first;
            first.prev = newFirst;
            first = newFirst;
        }    
        return true;
    }
    
    public boolean offerLast(E e) {
    
        Node<E> node = new Node<>(e);
        if(last == null) {
            last = node;
            first = node;
            last.prev = first;
            first.after = last;
        } else {
            Node<E> newLast = node;
            newLast.prev = last;
            last.after = newLast;
            last = newLast;
        }
        return true;
    }
    
    public E pollFirst() {
        if(first == null) {
            return null;
        }
       
        E res = first.data;
        first = first.after;
        return res;
    }
    
    public E pollLast() {
        if(last == null) {
            return null;
        }
        E res = last.data;
        last = last.prev;
        return res;
    }
}
