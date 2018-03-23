/*
 * Lös växlingsproblemet med en girig algoritm. 
 * Skriv en metod som tar växlingssumman och en int- array 
 * med de olika tillgängliga valutorna I fallande ordning 
 * och returnerar en int-array med antalet av varje valuta. 
 * Ex. Man vill veta växeln för 789 kr I vår valuta. Man anropar då:
 * change(789,new int[] {1000,500,100,50,20,10,5,1}) som då returnerar: {0,1,2,1,1,1,1,4}.
 */
package T12;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N34 {

    private static void change(int sum, int[] c) {
        
        int[] res = null;
        List<Integer> list = new ArrayList<>();
        int[] num = new int[c.length];
        
        // init num
        for(int i = 0; i < num.length; i ++) {
            num[i] = 0;
        }
    
        while(sum > 0) {
            for(int i = 0; i < c.length; i ++) {
                if(c[i] <= sum) {
                    list.add(c[i]);
                    num[i] ++;
                    sum -= c[i];
                }
            }
        }
        res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        System.out.println("Selections of notes/coins");
        print(res);
        System.out.println("\nNumbers of notes/coins");
        print(num);
        System.out.println("");
    }
    
    private static void print(int[] res) {
        
        for(int i = 0; i < res.length; i ++) {
            System.out.print(res[i] + " ");
        }
    }
    
    public static void main(String[] args) {
         
        int sum = 789;
        int sum2 = 30;
        int[] CURRENCY = {1000, 500, 100, 50, 20, 10, 5, 1};
        int[] currency2 = {25, 10, 1};
        change(sum, CURRENCY);
        change(sum2, currency2);
    }
}
