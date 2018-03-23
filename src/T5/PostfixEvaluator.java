/*
 *PostfixEvaluator
 */
package T5;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class PostfixEvaluator {
   
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String msg) {
            super(msg);
        }
    }
    
    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;
    
    private int evalOp(char op) throws SyntaxErrorException {
        /**hit skickar vi en operator den ska nu utföras 
         * på de två översta talen på stacken som ska
         * tas bort. Sedan ska resultatet upp på stacken 
         */
        int res = 0;
        int secondNumber = operandStack.pop();
        int firstNumber = operandStack.pop();
        switch(op) {
            case '+':
                res = firstNumber + secondNumber;
                break;
            case '-':
                res = firstNumber - secondNumber;
                break;
            case '*':
                res = firstNumber * secondNumber;
                break;
            case '/':
                if(secondNumber != 0) {
                    res = firstNumber / secondNumber;
                    break;
                } else {
                    throw new PostfixEvaluator.SyntaxErrorException("Syntax Error: "
                            + "can not be divided by 0.");
                }
        }
        return res;
    }
    
    private boolean isOperator(char c) {
        return OPERATORS.indexOf(c) != -1;
    }
    
    public int eval(String exp) throws SyntaxErrorException {
        // create stack for this evaluation
        operandStack = new Stack<>();
        String[] tokens = exp.split("\\s+");  // divid string with backspace
        
        try{
            for(String nextToken: tokens) {
                if(Character.isDigit(nextToken.charAt(0))) {
                    // det kommer ett tal så använd 
                    //Integer.parseInt(nextToken)) och lägg det på stacken!
                    int digit = Integer.parseInt(nextToken);
                    operandStack.push(digit);
                } else if(isOperator(nextToken.charAt(0))) {
                    //det kommer en operator så anropa 
                    //evalOp för att göra beräkningen med operatorn 
                    int result = evalOp(nextToken.charAt(0));
                    // Push the result onto the operand stack!!
                    operandStack.push(result);
                    
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            } // End for
            
                  
            /**
             * No more tokens - pop result from operand stack.
             * Stack should be empty after pop() answer.
             */
            int answer = operandStack.pop();
            if(operandStack.empty()) {
                return answer;
            } else {
                throw new SyntaxErrorException("Syntax Error: stack should be empty.");
            }
        
        } catch(EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty!");
        }   // End try-catch  
    }
}
