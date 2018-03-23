/*
 * Givet n punkter på den reella tallinjen. 
 * Hitta det minsta antal intervall med längden 2,0 
 * som tillsammans täcker alla punkter. Designa 
 * och implementera en girig algoritm. 
 * Låt programmet slumpa fram ett antal punkter. 
 * Försök verifiera att din algoritm fungerar med ett resonemang. 
 * Skriv även ner ditt resonemang i din redovisning.
 * 算法：1.排序数列；2. 从第一个点开始, 找到第一个点距离原点大于2.0， 放第一个2.0长度线段；
 * 3. 从那个大于2.0的点开始重复第2步
 * 4. 最后一个点，可以占用一个2.0线段。
 */
package T12;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * !!!!Unfinished
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB40 {

    private static final double L = 2.0;
    private static int res = 0; 
    private static int start = 0; // start point, from 0
    
    private static int totalIntervals(double[] num) {
//        
//        for(int i = 0; i < num.length; i ++) {
//            while(start < num.length) {
//                if(num[i] - num[start] > L) {
//                    res ++;
//                    start = i;
//                }
//            }
//        }
        while(start < num.length) {
            for(int i = start + 1; i < num.length; i ++) {
                if(num[i] - num[start] <= L) {
                    res ++;
                    start = i + 1;
                } 
            }
        }
        return res;
    }
    
    private static void print(double[] a) {
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
    }
    
    public static void main(String[] args) {
            
        int n = 10;
        double[] num = new double[n];
        DecimalFormat df = new DecimalFormat( "0.00 ");
        for(int i = 0; i < num.length; i ++) {
            num[i] = Double.valueOf(df.format(Math.random() * 20));
            //System.out.print(num[i] + ", ");
        }
        Arrays.sort(num);
        print(num);
        System.out.println("Total intervals: " + totalIntervals(num));
    }
}
