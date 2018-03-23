/*
 * Stack implemented by ArrayList without a top index
 */
package T4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class ArrayListStackNoTopIndex<E> implements StackInterface<E> {

    private ArrayList<E> data;
    
    public ArrayListStackNoTopIndex() {
        data = new ArrayList<>();
    }
    
    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    } 
}
