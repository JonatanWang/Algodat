/*
 * Skriv testkod för vår hashtabell från föreläsningen. 
 * Fundera på vad den behöver testa. 
 * Inspiration kan du hämta på sid 394 i boken.
 */
package T9;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB26 {
    
    private static final int SIZE = 100;    // key-value pairs, neither number of lists nor table size
    private static final int KEY_RANGE = 655350;
    /**
     * Test:
     * Load factor reaches 0.75 rehash?
     * Deleted keys no longer accessible via a get(key)?
     */
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashTableBucket<Integer, Integer> table = new HashTableBucket<>(10);
        for (int i = 0; i < SIZE; i += 1) {
            Integer nextInt = (int) (Math.random() * KEY_RANGE);
            table.put(nextInt, nextInt);
        }
        System.out.println(table);
        for (int i = 0; i < KEY_RANGE; i++) {
            if(i % 2 == 0) {
                table.remove(i);
            }     
        }
        System.out.println("\nafter remove: " + table);
        System.out.println("\nget: 22 -> " + table.get(22));
        System.out.println("\nget: 27(remove(27) -> " + table.get(27));
        System.out.println("\nduplicately put(22, 888) -> "
                + "\nreturn value = " + table.put(22, 888)
                + "\nnew value retrieved = " + table.get(22));
        System.out.println("\nLast toString(): " + table.toString());
    }
}
