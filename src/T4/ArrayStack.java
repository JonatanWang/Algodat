/*
 * Stack implemented by Array
 */
package T4;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class ArrayStack<E> implements StackInterface<E>{

    private E[] data;
    private int top;
    private int maxSize;
    
    public ArrayStack() {
        maxSize = 10;
        data = (E[]) new Object[maxSize];
        top = -1;
    }
    
    /**
     * Number of elements
     * @return size of the data
     */
    public int size() {
        return top  + 1;
    }
    
    /**
     * Remove all elements in the stack
     * @return the last element removed
     */
    public E flush() {
        // check if empty stack
        if (empty()) {
            throw new EmptyStackException();
        }
        E res = null;
        while(!empty()) {
            res = pop();
        }
        return res;
    }
    
    /**
     * Mock method to get the n:th element in the stack
     * Without any affection on the stack
     * @param index
     * @return 
     */
    public E peek(int index) {
        // Check borders
        if(index < 0 || index > top) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // Check if stack is empty
        if(empty()) {
            throw new EmptyStackException();
        }
        return data[top - index];   // First element is data[top], last element is data[0].
    }
    
    @Override
    public E push(E obj) {
        if(top == maxSize - 1) {
            reallocate();
        }
        top ++;
        data[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    @Override
    public E pop() {
    
        if(empty()) {
            throw new EmptyStackException();
        }
        return data[top --];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
    
    private void reallocate() { 
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize); 
    }
}
