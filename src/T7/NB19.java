/*
 * brickspel
 */
package T7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NB19 {
    
    public static int[] initial = {1,1,1,0,-1,-1,-1};
    public static int[] target = {-1,-1,-1,0,1,1,1};
    public static int[] offsets = {-2,-1,1,2};
    public static List<String> closed = new ArrayList<String>();
    static int cnt = 0;

    public static void main(String[] args) {    
        findTarget(initial, 0,"");    
    }
   
    public static void findTarget(int[] current, int step, String solution){
       
        if (closed.contains(Arrays.toString(current))|| step >= 16){
            return;
        } else {
            closed.add(Arrays.toString(current));
        }
        if (Arrays.equals(current, target)){
            cnt ++;
            System.out.println("Solution " + cnt + ": " 
                    + solution.substring(0, solution.length() - 1));           
        }
       
        for (int i = 0 ; i < current.length ; i++){
            if (current[i] == 0){
               for (int offset : offsets){
                    if ( i + offset >= 0 && i + offset < current.length){
                     
                     String s = (i + offset + 1) + "->" + (i + 1) + ",";
                     int swap = current[i + offset];
                     current[i + offset] = current[i];
                     current[i] = swap;
                     findTarget(current, step + 1, solution + s);
                     swap = current[i + offset];
                     current[i + offset] = current[i];
                     current[i] = swap;
                    }         
               }       
            }       
       }
      closed.remove(Arrays.toString(current));
    }
}