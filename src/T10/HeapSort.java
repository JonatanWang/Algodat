/*
 * HeapSort based on NB:s lecture
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class HeapSort {
    
    public static void sort(int[] a) {
        
        int n = a.length;
        Heap heap = new Heap(n);
        
        while (heap.size() < n) {
            
            int e = a[heap.size()];
            heap.insert(e);
        }
        
        heap.print();
        
        int i = 0;
        while(heap.size() > 0) {
            
            int e = heap.delete();
            a[i ++] = e;
        }
    }
}
