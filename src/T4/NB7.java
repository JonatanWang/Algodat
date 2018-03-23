/*
 * Test flush(), size(), and peek(n) to LinkedStack
 */
package T4;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB7 {
    
    public static void main(String[] args) {
        
        LinkedStack<String> stack = new LinkedStack<>();
        System.out.println("Size() = " + stack.size());
        //System.out.println("Flush() = " + stack.flush());
        //System.out.println("Peek(0) = " + stack.peek(0));
        
        System.out.println("**** Add data to stack ****");
        stack.push("First element");
        stack.push("Second Element");
        stack.push("Third Element");
        System.out.println("After push() & size() = " + stack.size());
        System.out.println("After push() & peek(1) = " + stack.peek(1));
        System.out.println("After push() & flush() = " + stack.flush());
        System.out.println("flush() & size() = " + stack.size());
    }
}
