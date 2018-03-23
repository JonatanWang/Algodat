/*
 * Skriv en rekursiv static metod som beräknar x^n där n är ett positivt heltal. 
 * Skriv en iterativ metod som löser samma uppgift.
 */
package T6;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB12 {
    
    // recursive method to calculate x^n
    private static long exponent(int x, int n) {
        if(n == 0) {
            return 1L;
        } else {
            return x * exponent(x, n - 1);
        }
    }
    
    // iterative method to calculat x^n
    private static long exponentIterative(int x, int n) {
        int res = 1;
        for(int i = n; i > 0; i --) {
            res *= x;
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Recursive 2^7 = " + exponent(2, 8));
        System.out.println("Recursive 2^0 = " + exponent(2, 0));
        
        System.out.println("Iterative 2^7 = " + exponentIterative(2, 8));
        System.out.println("Iterative 2^0 = " + exponentIterative(2, 0));
    }
}
