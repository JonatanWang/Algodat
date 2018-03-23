/*
 * convert infix exp with parentheses
 */
package T5;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class InfixToPostfixParens {
    
    private Stack<Character> operatorStack;
    private static final String OPERATORS ="+-*/()";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    private StringBuilder postfix;
    
    private void processOperator(char firstChar) {
        
        if(operatorStack.empty() || firstChar == '(') {
            operatorStack.push(firstChar);
        } else {
            // peek the operator stack & let topOp be the top operator
            char topOp = operatorStack.peek();
            if(precedence(firstChar) > precedence(topOp)) {
                operatorStack.push(firstChar);
            } else {
                // pop all stacked operators with equal or higher precedence than firstChar
                while(!operatorStack.empty() && 
                        precedence(firstChar) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') {
                        // matching '(' popped - exit loop
                        break;
                    }
                    postfix.append(topOp);
                    postfix.append(' ');
                    if(!operatorStack.empty()) {
                        // reset topOp
                        topOp = operatorStack.peek();
                    }
                }
                // operator stack is empty 
                // or current operator precedence > top of stack operator precedence
                if(firstChar != ')') {
                    operatorStack.push(firstChar);
                }
            }
        }
    }
       
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String msg) {
            super(msg);
        }
    }

    // determine precedence of an operator +- == 1, */ == 2
    private int precedence(char firstChar) {
        return PRECEDENCE[OPERATORS.indexOf(firstChar)];
    }
        
    // determine if a character is an operator +-*/
    private boolean isOperator(char firstChar) {
        return OPERATORS.indexOf(firstChar) != -1;
    }

    public String convert(String infix) throws SyntaxErrorException {
        
        operatorStack = new Stack<>();
        postfix = new StringBuilder();
        try {
        
            String nextToken;
            Scanner scan = new Scanner(infix);
            String pattern = "[\\p{L}\\p{N}]+|[-+/\\*()]";
            while((nextToken = scan.findInLine(pattern)) != null) {
                char firstChar = nextToken.charAt(0);
                // is is operand?
                if(Character.isJavaIdentifierPart(firstChar) || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if(isOperator(firstChar)) {  // is is operator?
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " 
                    + firstChar);
                }
            } // end while loop
            
            // pop any remaining operators and append them to postfix
            while(!operatorStack.empty()) {
                char op = operatorStack.pop();
                // Any '(' on the stack is not matched
                if(op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis.");     
                }
                postfix.append(op);
                postfix.append(' ');
            }
            
            // stack is empty, return result
            return postfix.toString();
        } catch(EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: the stack is empty.");
        } 
    }
}
