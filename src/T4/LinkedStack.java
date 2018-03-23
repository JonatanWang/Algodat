/*
 * Stack implemented by LinkedList
 * add size(), peek(n), and flush() to LinkedStack
 */
package T4;

import java.util.EmptyStackException;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class LinkedStack<E> implements StackInterface<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        private Node(E dataItem, Node<E> nextRef) {
            this.data = dataItem;
            this.next = nextRef;
        }     
    }
    
    private Node<E> top;
    
    public LinkedStack() {
        top = null;
    }
    
    /**
     * Number of elements
     * @return 0, if empty stack, otherwise number of elements
     */
    public int size() {
        int res = 0;
        if(empty()) {
            return res;
        }
        Node<E> pointer = top;
        while(pointer != null) {
            res ++;
            pointer = pointer.next;
        }
        return res;
    }
    
    /**
     * Empty the whole stack
     * @return The last element in the stack
     */
    public E flush() {
        if(empty()) {
            throw new EmptyStackException();
        }
        E res = null;
        while(!empty()) {
            res = pop();
        }
        return res;
        /**
         * Node<E> tmp = top;
         * top = null;
         * return ....???
         */
    }
    
    /**
     * Mock method to return the n:th element in the stack
     * @param index
     * @return The n:th element
     */
    public E peek(int index) {
        if(empty()) {
            throw new EmptyStackException();
        }
        if(index < 0 || index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException(); // Right exception?
        }
        if(index == 0) {
            return peek();
        }
        Node<E> res = top;
        for(int i = 0; i < index; i ++) {
            res = res.next;
        }
        return res.data;
    }
    
    @Override
    public E push(E obj) {
        top = new Node<>(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        E res = top.data;
        top = top.next;
        return res;
    }

    @Override
    public boolean empty() {
        return top == null;
    }
}
