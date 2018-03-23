/*
 * Skriv en funktion som tar en array med punkter 
 * (använd en klass för att representera en 2D-punkt med float för koordinaterna) 
 * och returnerar det kortaste avståndet mellan två punkter. 
 * Funktionen ska använda en effektiv söndra och härska algoritm 
 * enligt föreläsningen (dvs inte jämföra onödiga punkter över mittlinjen). 
 * Skriv också en main som slumpar fram n punkter 
 * som ligger i intervallet: - 1<x<1 och -1<y<1 med lika stor sannolikhet för alla värden. 
 * Anropa din funktion med de framslumpade punkterna.
 */
package T13;

import java.util.Random;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB42 {

    public static void main(String[] args) {
        
        int n = 10;
        Point[] p = new Point[n];
        Random random = new Random();
        for(int i = 0; i < p.length; i ++) {
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;
            Point point = new Point(x,y);
            p[i] = point;
            System.out.print(p[i].toString());
        }
        // see closed pair project
    }

}
















