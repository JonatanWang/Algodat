/*
 * Implementerar en lista som lagrar heltal mha en array.
 * Refer to MyArrayListByArray.java, F1
 */
package T3;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw at kth.se>
 */
public class IntList {
     
    private int[] data; // data stored by an array
    private int initialCapacity;    // initial array capacity
    private int numberOfElements;   // number of elements for size()
        
    // Constructor: initialCapacity <=> maxSize
    public IntList(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.data = new int[this.initialCapacity];
        this.numberOfElements = 0;
    }
       
    /**
     * Add element to the list
     * @param element the integer to be added
     * @return true if succeed, should always be true
     */
    public boolean add(int element) {
        // Check if the size/number of elements already reaches the maxSize/initial Capacity
        if(initialCapacity == size()) {
            reallocate();   // If so, dubble the array size
        }
        data[numberOfElements] = element;   // Add the element to the tail of the list
        numberOfElements ++;    // Increment the number of elements
        return true;    // Always true          
    }
      
    /**
     * Add an element to a specific place
     * @param index the place in the array
     * @param element the integer to be added
     */
    public void add(int index, int element) {
        // Check first if the index is out of bound
        if(index >= 0 && index <= initialCapacity) {
            // Check if the number of elements already reaches the max size
            if(numberOfElements == initialCapacity) {
                reallocate();   // If so, doubble the size of the array
            }
                
            // Shift all elements after data[index] to the right side
            for(int i = numberOfElements; i > index; i --) {
                data[i] = data[i - 1];
            }
            data[index] = element;  // Add element to the place of index
            numberOfElements ++;    // Increment the number of elements
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
        
    /**
     * Get the element at place of index
     * @param index the place in the array
     * @return the element
     */
    public int get(int index) {
        // Check if the index is within a reasonable category
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }
      
    /**
     * Get the index/position of a specific element
     * @param element the target element
     * @return -1 if the element does not exist, otherwise return the index
     */
    public int indexOf(int element) {
        for(int i = 0; i < size(); i ++) {
            if(data[i] == element) {
                return i;   // Return the index of the first appeared target element
            }
        }
        return -1;
    }
        
    /**
     * Remove the element at a specific place/index
     * @param index The position
     * @return the removed element
     */
    public int remove(int index) {
        // Check first if the index is within a resonable interval
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int res = get(index);   // Save the return value first
        for(int i = index; i < numberOfElements - 1; i ++) {
            data[i] = data[i + 1];  // Shit all element after index to the left side
        }   
        numberOfElements --;    // Decrease the number of elements
        return res;
    }
        
    /**
     * Set an element at a specific place/index
     * @param index
     * @param element
     */
    public void set(int index, int element) {
        
        if(index < 0 || index > size()) {   // Check if the index is within a reasonable interval
            throw new ArrayIndexOutOfBoundsException(index);
        }
  
        /**
         * Change the value.
         */
        data[index] = element;  
    }
        
    private void reallocate() {
        initialCapacity *= 2;
        data = Arrays.copyOf(data, initialCapacity);
    }
        
    public int size() {
        return this.numberOfElements;
    }
}
