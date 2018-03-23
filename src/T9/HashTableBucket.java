package T9;

import java.util.Iterator;

/**
 * revised by wang zhengyu
 * @author bfelt
 * @param <K>
 * @param <V>
 */
public class HashTableBucket<K, V> {

    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }     
    }

    private SingleLinkedList<Entry<K, V>>[] table;
    private int numberOfKeys;
    private final double THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new SingleLinkedList[initialSize];
        numberOfKeys = 0;
    }

    public V get(K key) {
        
        int index = key.hashCode() % table.length;
        System.out.println("Original index: " + index);
        if (index < 0) {
            index += table.length;
            System.out.println("Adjusted index: " + index);
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        
        int index = key.hashCode() % table.length;
        System.out.println("Original index: " + index);
        if (index < 0) {
            index += table.length;
            System.out.print("Adjusted index: " + index);
        }
        // if an empty element was found, insert new entry
        if (table[index] == null) {
            table[index] = new SingleLinkedList<>();
            System.out.println("An empty element found, insert table[" +index + "]." );
        } 
            // re-write old value, number of keys remains unchanged
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        
        table[index].addFirst(new Entry<>(key, value)); 
        numberOfKeys ++;
            //Check if rehash is needed
            double loadFactor = (double) numberOfKeys / table.length;
            System.out.println("loadFactor = " + loadFactor);
            if (loadFactor > THRESHOLD) {
                rehash();
            }
        return null;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table.length; i ++) {
            sb.append("\nList ").append(i).append("-> ");
            if(table[i] != null) {  // Important to check whether null
                for(int j = 0; j < table[i].size(); j ++) {
                sb.append("[key: ").append((table[i].get(j)).key).append(", ");
                sb.append(" value: ").append((table[i].get(j)).value).append("] ");           
                }   
            }   
        }
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * WRONG
     * remove(key) tar bort key, value elementet om det finns och returnerar
     * value annars returneras null
     * @param i 
     
    public V remove(K key) {
        V res = get(key);
        for (SingleLinkedList<Entry<K, V>> table1 : table) {
            if(table1 != null) {
                for (int j = 0; j < table1.size(); j ++) {
                    if (table1.get(j).key == key) {
                        table1.remove(table1.get(j));
                        numberOfKeys --;
                    }
                }
            }
        }
        return res;
    }
    */
    
    /**
     * Another method to remove(key)
     * @param key
     * @return 
     */
    public V remove(K key) {
        
        int index = key.hashCode() % table.length;
        if(index < 0) {
            index += table.length;
        }
        if(table[index] == null) {  // key not in table
            return null;
        }
        Iterator<Entry<K, V>> iter = table[index].iterator();
        while(iter.hasNext()) {
            Entry<K, V> e = iter.next();
            // if search successes, return the value
            if(e.key.equals(key)) {
                V res = e.value;
                iter.remove();
                //set table[index] == null when table[index].size() == 0
                if(table[index].size() == 0) {
                    table[index] = null;
                }
                return res;
            }
        }
        return null;    // key not in table
    }
    
    /**
     * resize the table length when the number of keys 
     * becomes larger than a threshold(e.g. 75%)
     * size of the table doubled to an odd number by + 1.
     * All non-empty elements in the old table re-inserted into the new table
     */
    public void rehash() {
        System.out.println("rehash!");
        // Save the old table
        SingleLinkedList<Entry<K, V>>[] oldTable = this.table; 
        // double capacity of the old table
        this.table = new SingleLinkedList[oldTable.length * 2 + 1];
        
        // reinsert all items in the old table into the expanded table
        numberOfKeys = 0;
        for (SingleLinkedList<Entry<K, V>> t : oldTable) {
            if (t != null) {
                for (Entry<K, V> e : t) {
                    put(e.key, e.value);
                }
            }
        }
    }
}
