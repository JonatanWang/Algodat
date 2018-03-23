package F1;

import java.util.Arrays;

/**
 * Implement an array-list by array
 * @author zyw
 * @param <E>
 */
public class MyArrayListByArray<E> {
    
    private E[] data;
    private int noElements;
    private int maxSize;
    
    public MyArrayListByArray() {
        this.noElements = 0;
        this.maxSize = 10;
        this.data = (E[]) new Object[maxSize];
    }
    
    // ArrayList add(e) return boolean
    public boolean add(E e) {
        
        if(noElements == maxSize) {
            reallocate();
        } 
        data[noElements ++] = e;
        /**
         * Or my way:
        data[noElements] = e;
        noElements ++;
        * */
        return true;
    }
    
    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }
    
    /**
     * Wrong! Without consideration of borders!!!!!!
     * @param index
     * @param entry 
    public void add(int index, E entry) {
        if(noElements == maxSize) {
            reallocate();
        }
        E[] oldData = data;
        data[index] = entry;
        noElements ++;
        System.arraycopy(oldData, index, data, index + 1, oldData.length - index);
    }
    */
    
    public void add(int index, E entry) {
        
        // Check if index out of bounds first
        if(index >= 0 && index <= noElements) {
            //Check if number of elements is equal to the maxSize
            if(noElements == maxSize) {
                reallocate();
            }
            // E[] oldData = data; No need to create another array
            for(int i = data.length; i > index; i --) {
                data[i] = data[i - 1];  // Shift each element one step to the right side 
                                        //from/except data[index]
            }
            data[index] = entry;
            noElements ++;
            return; // No need go further if insertion succeeds
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
    
    public E get(int index) {
        
        if(index >= 0 && index <= noElements) {
            return data[index];
        } 
        
        throw new ArrayIndexOutOfBoundsException(index);
    }
}
