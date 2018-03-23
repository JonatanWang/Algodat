/*
 * p. 193, Chapter 3 Programming project 7 review, Stack continues.
 * Evaluate infix expressions directly using combined algorithm between infix & postfix.
 */
package T5;

import javax.swing.JOptionPane;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class C3P7 {
       
    public static void main(String[] args) throws PostfixEvaluator.SyntaxErrorException {
        
        PostfixEvaluator evaluator = new PostfixEvaluator();
        InfixToPostfix inToPost = new InfixToPostfix();
        
        String infix = JOptionPane.showInputDialog("Enter an infix exp:");
        
        try {
            String postfix = inToPost.convert(infix);
            int result = evaluator.eval(postfix);
            JOptionPane.showMessageDialog(null, "Infix exp "
                    + infix + 
                    "\nconverts to " + postfix +
                    "\nResult = " + result);
            
        } catch(InfixToPostfix.SyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.exit(0);
    }
}
