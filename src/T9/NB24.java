/*
 * Skriv en toString-metod och en remove-metod till 
 * vår hashtabell från föreläsningen. 
 * Skriv toString- metoden med fokus på att 
 * den ska kunna hjälpa till vid testning av klassen. 
 * Den bör alltså skriva ut tabellen så att 
 * man kan se var i tabellen de olika värdena är lagrade. 
 * Skriv som alltid en main som testar din metod.
 */
package T9;

/**
 * Revised by Wang Zhengyu
 * @author bfelt
 */
public class NB24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashTableBucket<Integer, Integer> table = new HashTableBucket<>(10);
        for (int i = 0; i < 30; i += 1) {
            table.put(i, i);
        }
        System.out.println(table);
        for (int i = 0; i < 100; i++) {
            if(i % 3 == 0) {
                table.remove(i);
            }     
        }
        System.out.println("\nafter remove: " + table);
        System.out.println("\nget: 22 -> " + table.get(22));
        System.out.println("\nget: 27(deleted) -> " + table.get(27));
        System.out.println("\nduplicately put(22) -> "
                + "\nreturn value = " + table.put(22, 888)
                + "\nnew value retrieved = " + table.get(22));
        //System.out.println("toString: " + table.toString());
    }

}
