package T5;

import javax.swing.JOptionPane;

/*
 * Infix calculator which can evaluate parentheses
 */

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB7_2 {
    
         
    public static void main(String[] args) throws PostfixEvaluator.SyntaxErrorException,
            InfixToPostfixParens.SyntaxErrorException {
        
        PostfixEvaluator evaluator = new PostfixEvaluator();
        InfixToPostfixParens inToPost = new InfixToPostfixParens();
        
        String infix = JOptionPane.showInputDialog("Enter an infix exp with parens:");
        
        String postfix = inToPost.convert(infix);
        int result = evaluator.eval(postfix);
        JOptionPane.showMessageDialog(null, "Infix exp "
                + infix +
                "\nconverts to " + postfix +
                "\nResult = " + result);
        System.exit(0);
    }
}
