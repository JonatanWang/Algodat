/*
 * Convert an infix expression to a postfix expression
 */
package T5;

import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class InfixToPostfix {

    private Stack<Character> operatorStack;
    private static final String OPERATORS ="+-*/";
    private static final int[] PRECEDENCE = {1, 1, 2, 2};
    private StringBuilder postfix;
    
    public String convert(String infix) throws SyntaxErrorException {
        
        operatorStack = new Stack<>();
        postfix = new StringBuilder();
        
        String[] tokens = infix.split("\\s+");
        try {
            
            for(String nextToken : tokens) {
                char firstChar = nextToken.charAt(0);
                // check if it is an operand
                if(Character.isDigit(firstChar) 
                        || Character.isJavaIdentifierStart(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) { // check if it is an operator
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected Character"
                            + "Encountered: " + firstChar);
                }
            } // End for
            
            // Pop any remaining operators and append them to postfix
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                postfix.append(op);
                postfix.append(' ');
            }
            // Stack is empty, return result
            return postfix.toString();
            
        } catch(EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty.");
        }
    }
        
    // determine if a character is an operator +-*/
    private boolean isOperator(char firstChar) {
        return OPERATORS.indexOf(firstChar) != -1;
    }

    private void processOperator(char firstChar) {
        if(operatorStack.empty()) {
            operatorStack.push(firstChar);
        } else {
            // Peek the operator stack and let firstChar be top operator
            char topOp = operatorStack.peek();
            if(precedence(firstChar) > precedence(topOp)) {
                operatorStack.push(firstChar);
            } else {
                // pop all stacked operators with equal 
                // or higher precedence than firstChar
                while(!operatorStack.empty() &&
                        precedence(firstChar) <= precedence(topOp)) {
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if(!operatorStack.empty()) {
                        // reset topOp
                        topOp = operatorStack.peek();
                    }
                } // end while.
                // Operator stack is empty 
                //or current operator precedence > top of stack operator precedence
                operatorStack.push(firstChar);
            }
        }
    }

    // determine precedence of an operator +- == 1, */ == 2
    private int precedence(char firstChar) {
        return PRECEDENCE[OPERATORS.indexOf(firstChar)];
    }
    
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String msg) {
            super(msg);
        }
    } 
    
    // Test
    public static void main(String[] args) {
        
        InfixToPostfix inToPost = new InfixToPostfix();
        
        String infix = JOptionPane.showInputDialog("Enter an infix exp:");
        
        try {
            String postfix = inToPost.convert(infix);
            JOptionPane.showMessageDialog(null, "Infix exp "
                    + infix + 
                    "\nconverts to " + postfix);
        } catch(SyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.exit(0);
    }
}
