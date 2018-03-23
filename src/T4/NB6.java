/*
 * Test ArrayStack new methods: size(), flush(), peek(n)
 */
package T4;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB6 {
    
    public static void main(String[] args) {
        
        ArrayStack<String> stack = new ArrayStack<>();
        System.out.println("Test initial size() = " + stack.size());
        //System.out.println("Test init flush() = " + stack.flush());
        //System.out.println("Test init peek(n) = " + stack.peek(0));
        
        stack.push("First Element");
        stack.push("Second Element");
        System.out.println("Test peek(1) = " + stack.peek(1));
        System.out.println("Test flush() => " 
                + stack.flush() + "; size() = " + stack.size() 
                + "; Empty? " + stack.empty());
    }
}
