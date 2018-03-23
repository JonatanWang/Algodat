/*
 * Binary to Decimal <-> Decimal to Binary
 * NB:s solution
 */
package T6;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB15 {
    
    private static int binaryToDecimal(String binaryExp) {
        
        return binaryToDecimal(binaryExp, binaryExp.length() - 1);
    }
 
    private static int binaryToDecimal(String binaryExp, int i) {
        
        if(i < 0) {
            return 0;
        }
        return Character.getNumericValue(binaryExp.charAt(i)) 
                + binaryToDecimal(binaryExp, i - 1) * 2;
    }
    
       
    private static String decimalToBinary(int decimal) {
        
        if(decimal == 0) {
            return "";
        }
        return decimal % 2 + decimalToBinary(decimal / 2);
    }
    
    public static void main(String[] args) {
        
        System.out.println("B(1011) => D: " + binaryToDecimal("1011"));
        System.out.println("D(11) => B: " + decimalToBinary(11));
    }
}
