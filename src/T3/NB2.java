/*
 * Implementerar en lista som lagrar heltal mha en array.
 */
package T3;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw at kth.se>
 */
public class NB2 {
    
    public static void main(String[] args) {
        
        // Test IntList(int initialCapacity)
        IntList intList = new IntList(5);
        System.out.println("Initial size = " + intList.size());
        //System.out.println("Element at index 3 = " + intList.get(3));
        
        // Test add(int element); add values to intList
        for(int i = 0; i < 5; i ++) {
            intList.add(i * 2);
        }
        
        // Test get(int index)
        System.out.println("IntList : ");
        for(int i = 0; i < intList.size(); i ++) {
            System.out.println(intList.get(i));
        }
        //System.out.println("get(5) = " + intList.get(5));
        
        // Test indexOf(int element)
        System.out.println("Index Of '4': " + intList.indexOf(4));
        
        // Test remove(int index)
        int index = 3;
        intList.remove(index);
        System.out.println("IntList after remove(" + index + "): ");
        for(int i = 0; i < intList.size(); i ++) {
            System.out.println(intList.get(i));
        }
        
        // Test set(int index, int element)
        intList.set(0, 3);
        intList.set(1, 5);
        intList.set(2, 7);
        intList.set(3, 9);
        //intList.set(4, 11);
        System.out.println("IntList after set(): ");
        for(int i = 0; i < intList.size(); i ++) {
            System.out.println(intList.get(i));
        }
    }     
}
