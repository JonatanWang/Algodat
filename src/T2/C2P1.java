package T2;

import java.util.ArrayList;

/**
 * @author Wang Zheng-Yu <zhengyuw at kth.se>
 */
public class C2P1 {
    
    /** Replaces each occurrence of oldItem in aList with newItem.
     * @param aList
     * @param oldItem
     * @param newItem */
    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
    
        /**
         * Method 1 O(n)
        for(int i = 0; i < aList.size(); i ++) {
            if(oldItem.equals(aList.get(i))) {
                aList.set(i, newItem);
            }
        }
        * */
        
        // Method 2. O(n) - O(n2)
        int index = aList.indexOf(oldItem);
        // If oldItem not exist, aList.indexOf() returns -1.
        while(index != -1) {
            aList.set(index, newItem);
            index = aList.indexOf(oldItem);
        }
    }
    
    
    // Test
    public static void main(String[]  args) {
        
        ArrayList<String> aList = new ArrayList<>();
        
        aList.add("old");
        aList.add("old");
        aList.add("small");
        aList.add("Big");
        aList.add("new");
        aList.add("old");
        
        replace(aList, "old", "new");
        aList.forEach((s) -> {
            System.out.println("Item " + s);
        });
    }
}
