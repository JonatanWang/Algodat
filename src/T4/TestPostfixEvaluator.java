/*
 * TestPostfixEvaluator
 */
package T4;

import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class TestPostfixEvaluator {
    
    public static void main(String[] args) {
        
        PostfixEvaluator evaluator = new PostfixEvaluator();
        
        String line;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a postfix expression to evaluate: ");
            line = in.nextLine();
            if(!line.equals("")) {
                try {
                    int res = evaluator.eval(line);
                    System.out.println("Value is " + res);
                }catch(PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax Error: " + ex.getMessage());
                }
            } else {
                break;
            }
        }
    }
}
