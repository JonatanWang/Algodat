/*
 * check for balanced parentheses
 */
package T4;

import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class ParenChecker {
    
    private static final String OPEN = "([{";
    private static final String CLOSE = ")]}";
   
    
    public static boolean isBalanced(String exp) {
        
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        
        try {
            int index = 0;
            while (balanced == true && index < exp.length()) {
                char c = exp.charAt(index);
                if(isOpen(c)) {
                    stack.push(c);
                } else if (isClose(c)) {
                    char topChar =  stack.pop();
                    balanced = OPEN.indexOf(topChar) == CLOSE.indexOf(c);   // Most important
                  }
                    index ++;
                }        
        
            } catch (EmptyStackException e) {
              balanced = false;
        }
        
        return (balanced == true && stack.isEmpty());
    }
    
    private static boolean isOpen(char c) {
        
        return OPEN.indexOf(c) >  -1;
    }
    
    private static boolean isClose(char c) {
        
        return CLOSE.indexOf(c) > -1;
    }
    
    public static void main(String[] args) {
    
        String exp = JOptionPane.showInputDialog("Enter exp: ");
        if (ParenChecker.isBalanced(exp)) {
            JOptionPane.showMessageDialog(null, exp + " is balanced.");
        } else {
            JOptionPane.showMessageDialog(null, exp + " is unbalanced.");
        }
        
        System.exit(0);
    }
}
