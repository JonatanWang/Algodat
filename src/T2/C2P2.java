/*
 *Deletes the first occurrence of target in aList
 */
package T2;

import java.util.ArrayList;

/**
 * @author Wang Zheng-Yu <zhengyuw at kth.se>
 */
public class C2P2 {
    
    public static void delete(ArrayList<String> aList, String target) {
        
        /** Method 1
        int index = aList.indexOf(target);  // return -1 if target does not exist.
        if (index != -1) {
            aList.remove(target);
        }
        * */
      
        aList.remove(target);
    }
    
    public static void main(String[] args) {
        
        ArrayList<String> aList = new ArrayList<>();
        
        aList.add("old");
        aList.add("old");
        aList.add("small");
        aList.add("Big");
        aList.add("new");
        aList.add("old");
        
        delete(aList, "Big");
        
        aList.forEach((s) -> {
            System.out.println("Item " + s);
        });
    }
}
