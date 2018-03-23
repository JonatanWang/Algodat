/*
 * Stack implemented by ArrayList
 */
package T4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class ArrayListStack<E> implements StackInterface<E> {
    
    private ArrayList<E> data;
    private int top; 
    
    public ArrayListStack() {
        data  = new ArrayList<>();
        top = -1;
    }

    @Override
    public E push(E obj) {
        top ++;
        data.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(top);
    }

    @Override
    public E pop() {
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        E res = data.remove(top);
        top --;
        return res;
    }

    @Override
    public boolean empty() {
        return top == -1;
    } 
}
