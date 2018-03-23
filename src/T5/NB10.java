/*
 * Queue by Double linked list
 */
package T5;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB10 {
    
    public static void main(String[] args) {
        
        QueueByDoubleLinkedList<String> q = new QueueByDoubleLinkedList<>();
        // F2 - F1 - L1 - L2
        q.offerFirst("F1"); q.offerFirst("F2");
        q.offerLast("L1"); q.offerLast("L2");
        
        System.out.println("pollFirst => " + q.pollFirst());
        System.out.println("pollFirst => " + q.pollFirst());
        System.out.println("pollFirst => " + q.pollFirst());
        System.out.println("pollFirst => " + q.pollFirst());
        System.out.println("pollFirst => " + q.pollFirst());
        
//        System.out.println("pollLast => " + q.pollLast());
//        System.out.println("pollLast => " + q.pollLast());
//        System.out.println("pollLast => " + q.pollLast());
//        System.out.println("pollLast => " + q.pollLast());
//        System.out.println("pollLast => " + q.pollLast());
    }
}
