/*
 * Test ArrayListStack
 */
package T4;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB5 {
    
    public static void main(String[] args) {
        ArrayListStack<String> stack = new ArrayListStack<>();
        System.out.println("Empty = " + stack.empty());
        //System.out.println("Peep = " + stack.peek());
        //System.out.println("Pop = " + stack.pop());
        
        stack.push("First Element");
        stack.push("Second Element");
        while(!stack.empty()) {
            System.out.println("Push & Pop = " + stack.pop());
        }
        
        System.out.println("**** After pop ****");
        System.out.println("Empty = " + stack.empty());
        //System.out.println("Peep = " + stack.peek());
        //System.out.println("Pop = " + stack.pop());
        
        /**
         * Test ArrayListStackNoTopIndex
         */
        System.out.println("#### Test ArrayListStackNoTopIndex ####");
        ArrayListStackNoTopIndex<String> stackNoTopIndex = new ArrayListStackNoTopIndex<>();
        System.out.println("Empty = " + stackNoTopIndex.empty());
        //System.out.println("Peep = " + stackNoTopIndex.peek());
        //System.out.println("Pop = " + stackNoTopIndex.pop());
        
        stackNoTopIndex.push("First Element");
        stackNoTopIndex.push("Second Element");
        while(!stackNoTopIndex.empty()) {
            System.out.println("Push & Pop = " + stackNoTopIndex.pop());
        }
        
        System.out.println("**** After pop ****");
        System.out.println("Empty = " + stackNoTopIndex.empty());
        //System.out.println("Peep = " + stackNoTopIndex.peek());
        //System.out.println("Pop = " + stackNoTopIndex.pop());
    }
}
