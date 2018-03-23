/*
 * Queue by single linked list
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB9 {
    
    public static void main(String[] args){
        
        QueueBySingleLinkedList q = new QueueBySingleLinkedList();
        System.out.println("************ offer! **************");
        for(int i = 0; i < 16; i ++) {
            q.enqueue("e " + (i + 1));
            System.out.println("Element: " + q.peek()); // peekRear()
        }
        System.out.println("Size of the queue: " + q.size());
        System.out.println("************ pop! **************");
        
        while(q.size() != 0) {
            System.out.println("Element: " + q.dequeue());
        }
        System.out.println("Size of the queue: " + q.size());
    }
}
