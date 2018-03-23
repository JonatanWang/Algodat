/*
 * Skriv en metod som beräknar roten ur ett tal större 
 * eller lika med 1 med tre decimalers noggrannhet 
 * med hjälp av den rekursiva algoritmen nedan. 
 * e styr noggrannheten och a kan sättas till 1 initialt.
 */
package T6;

import java.text.DecimalFormat;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB13 {
    
    /**
     * 
     * @param n base
     * @param a exponent
     * @param e noggrannhet
     * @return 
     */
    private static double root(double n, double a, double e) {
        
        if(Math.abs(Math.pow(a, 2) - n) < e) {
            return a;
        } else {
            double midExp = (Math.pow(a, 2) + n) / (2 * a);
            return root(n, midExp, e);
        }
    }
    
    public static void main(String[] args) {
        DecimalFormat numberFormat = new DecimalFormat("#.000");
        
        double n = 10000;
        double a = 2;
        double e = 0.001;
        System.out.println("n = " + n + " a = " + a + " e = " + e 
                + " root = " + 
                numberFormat.format(root(n, a, e)));
    }
}
