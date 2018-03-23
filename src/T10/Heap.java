/*
 * Heap implemented by an array
 * NB ska testa båda 大根堆 和 小根堆
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Heap {
    
    private int[] arr;
    private int heapSize;
    
    public Heap(int capacity) {
        
        arr = new int[capacity];
        heapSize = 0;
    }
    
    public void insert(int e) {
        
        if(heapSize > arr.length) {
            throw new RuntimeException("Overflow");
        } else {
            heapSize ++;
            arr[heapSize - 1] = e;
            shiftUp(heapSize -1);
        }
    }
    
    public int delete() {
        int res;
        if(heapSize == 0) {
            throw new RuntimeException("Heap is empty");
        } else {
            res = arr[0];
            arr[0] = arr[heapSize - 1];
            heapSize --;
            if (heapSize > 0) {
                shiftDown(0);
            }
        }   
        return res;
    }

    private void shiftUp(int p) {
        
        int parentIndex;
        int tmp;
        if(p != 0) {
            
            parentIndex = (p - 1) / 2;
            
            if (arr[parentIndex] > arr[p]) {
                tmp = arr[parentIndex];
                arr[parentIndex] = arr[p];
                arr[p] = tmp;
                shiftUp(parentIndex);
            }
        }
    }

    private void shiftDown(int p) {
        
        int minIndex, tmp;
        int leftChildIndex = 2 * p + 1;
        int rightChildIndex = 2 * p + 2;
        
        if (rightChildIndex >= heapSize) {
            
            if (leftChildIndex >= heapSize) {
                return;
            } else {
                minIndex = leftChildIndex;
            }
        } else {
            
            if (arr[leftChildIndex] <= arr[rightChildIndex]) {
                minIndex = leftChildIndex;
            } else {
                minIndex = rightChildIndex;
            }
        }
        
        if (arr[p] > arr[minIndex]) {
            tmp = arr[p];
            arr[p] = arr[minIndex];
            arr[minIndex] = tmp;
            shiftDown(minIndex);
        }
    }
    
    public int size() {
        return heapSize;
    }
    
    public void print() {
        System.out.println("\n\nBefore heap sort: ");
        for(Integer i : arr) {
            System.out.print(i + "\t");
        }
    }
}
