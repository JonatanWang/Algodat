/*
 * Linked list
 */
package T3;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw at kth.se>
 */
public class NB3 {

    public static void main(String[] args) {

        // Create 4 nodes
        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        
        // Init & link 4 nodes
        node0.data = "Gilgamesh";
        node0.next = node1;
        node1.data = "löper";
        node1.next = node2;
        node2.data = "på";
        node2.next = node3;
        node3.data = "stäppen";
        //node3.next = null;

        // Traverse list and print out contents
        Node currentNode = node0;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        
        // Delete 'på' before the list is printed out
        System.out.println("\nDelete 'på' before print out. ");
        Node pNode = node0;
        while (pNode != null) {
            if(pNode.next != null && pNode.next.data.equals("på")) {
                pNode.next = pNode.next.next;
            }
            System.out.print(pNode.data + " -> ");
            pNode = pNode.next;
        }
        
        // Test if 'på' has been deleted
        System.out.println("\nCheck if 'på' has been deleted: ");
        Node qNode = node0;
        while (qNode != null) {
            System.out.print(qNode.data + " -> ");
            qNode = qNode.next;
        }
        
    }
}
