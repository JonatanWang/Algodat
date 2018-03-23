/*
 * Shrink an array queue
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB8 {
    
    public static void main(String[] args) {
        
        ArrayQueue<String> queue = new ArrayQueue<>(10);
        
        System.out.println("************ offer! **************");
        for(int i = 0; i < 16; i ++) {
            queue.offer("e " + (i + 1));
            System.out.println("Element: " + queue.peek());
            System.out.println("Array Size = " + queue.getMaxSize());
        }
        
        System.out.println("************ pop! **************");
        
        while(queue.peek() != null) {
            System.out.println("Element: " + queue.poll());
            System.out.println("Array Size = " + queue.getMaxSize());
        }
    }
}
