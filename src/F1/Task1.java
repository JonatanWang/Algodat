package F1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zyw
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("coo");
        list.add("bar");
        list.add("foo");
        list.add("coo");
        list.add("coo");
        list.add("bar");
        list.add("coo");
        
        System.out.println("Total foo: " + count(list, "foo"));
        System.out.println("Total bar: " + count(list, "bar"));
        System.out.println("Total coo: " + count(list, "coo"));
    }
    
    public static int count(List<String> list, String text) {
        
        int res = 0;
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i).equals(text)) {
                res ++;
            }
        }
        return res;
    }
}
