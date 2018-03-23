/*
 * Lös det obegränsade kappsäcksproblemet med en girig algoritm i en funktion 
 * där man kan skicka in storleken på kappsäcken och varornas vikt och värde på ett bra sätt. 
 * Funktionen ska då på ett bra sätt returnera hur kappsäcken ska packas. 
 * Skriv också en main som tillåter en användare att ange indata till algoritmen 
 * och sedan presenterar lösningen för denna.
 */
package T12;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N35 {
    
    private static void solution(int size, LinkedList<Commodity> commodities) {
        
        int totalValue = 0;     // total value of the filled sack
        int totalWeight = 0;    // total weight of the filled sack
        Collections.sort(commodities);  // sort the commodities first, so the biggest is on top
        for(Commodity c : commodities) {    // test, print
            System.out.println(c.toString());
        }
        System.out.println("");
        // hash map to save the result/plan
        HashMap<String, Integer> res = new HashMap<>();
       
        /**
         * Fyll kappsäcken med så många som möjligt av den vara 
         * som har högst värde per viktenhet (kr/kg).
         * Fyll kappsäcken med så många som möjligt av den vara 
         * som har näst högst värde per viktenhet. osv
         */
        while(!commodities.isEmpty() && size >= commodities.peekLast().getWeight()) {    
         
                Commodity currentCommodity = commodities.poll();
                int subTotal = size / currentCommodity.getWeight();
                totalWeight += subTotal * currentCommodity.getWeight();
                totalValue += subTotal * currentCommodity.getPrice();
                size = size % currentCommodity.getWeight();
                res.put(currentCommodity.getName(), subTotal);   
        }
        System.out.println("Total value: " + totalValue);
        System.out.println("Total Weight: " + totalWeight);
        System.out.println(res.keySet());
        System.out.println(res.values());
    }
    
    public static void main(String[] args) {
            
        Queue<Commodity> commodities = new LinkedList<>();
        Commodity apple = new Commodity("apple", 10, 4);
        Commodity pear = new Commodity("pear", 3, 2);
        Commodity melon = new Commodity("melon", 1, 1);
        commodities.add(apple); commodities.add(pear); commodities.add(melon);
        solution(15, (LinkedList<Commodity>) commodities);
        
        System.out.println("**************************************************");
        
        // Unsuccessful example
        Queue<Commodity> commodities1 = new LinkedList<>();
        Commodity chicken = new Commodity("chicken", 12, 11);
        Commodity duck = new Commodity("duck", 10, 10);
        //Commodity goose = new Commodity("goose", 1, 1);
        commodities1.add(chicken); commodities1.add(duck); 
        //commodities1.add(goose);
        solution(20, (LinkedList<Commodity>) commodities1);
    }
}
