/*
 * ArrayQueue by circular array
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 * @param <E>
 */
public class ArrayQueue<E> {
    
    private int front, rear, size, maxSize;
    private E[] data;
    
    public ArrayQueue(int initMaxSize) {
        front = size = 0;
        maxSize = initMaxSize;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }
    
    public boolean offer(E e) {
        if(size == maxSize) {
            reallocate();
        }
        rear = (rear + 1) % maxSize;
        data[rear] = e;
        size ++;
        return true;
    }
    
    public E peek() {
        if(size == 0) {
            return null;
        }
        return data[front];
    }
    
    public E poll() {
        
        if(size < maxSize / 4 && size > 0) {
            resize();
            //System.out.println("maxSize = " + maxSize);
        }
        
        if(size == 0) {
            return null;
        } else {
            size --;
            E res = data[front];
            front = (front + 1) % maxSize;
            return res;
        }
    }

    private void reallocate() {
        int newMaxSize = 2 * maxSize;
        E[] newData = (E[]) new Object[newMaxSize];
        
        int j = front;
        for(int i = 0; i < size; i ++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }
    
    private void resize() {
        int newMaxSize = maxSize / 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for(int i = 0; i < size; i ++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        setMaxSize(newMaxSize);
        data = newData;
    }
    
    // Test method to return size of the array
    public int getMaxSize() {
        return this.maxSize;
    }
    
    private void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
