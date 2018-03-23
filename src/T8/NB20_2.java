/*
 * DFS + backtracking: print steps
 */
package T8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB20_2 {
    
public static int result = 0;
    public static int min_result = 0;
    private static Stack<String> steps = new Stack<>();
    private static List<String> bestSteps = new ArrayList<String>();
     
    public static void main(String[] args){
        
        System.out.print("Input target value: ");
        Scanner in = new Scanner(System.in);
        int goal = in.nextInt();
        //first insert 10 coins
        findCoin(1, 1, goal);
        //let result be to zero
        result = 0;
        //first insert 5 coins
        findCoin(1, 2, goal);
        System.out.println(min_result);
        //output best steps here
        for(int i = 0; i < bestSteps.size(); i ++) {
            System.out.print(bestSteps.get(i));
        }
       
    }
   

   
    public static void findCoin(int current, int type,int goal){
        
        if (type == 1){
            current = current * 3;
            result += 10;
            steps.push("10->");
        }         
        if (type == 2){
         current += 4;
         result += 5;
         steps.push("5->");
        }
        if (current == goal){
            // output each solution from here
            System.out.print("coins value = " + result + ", steps: ");
            for(int i = 0; i < steps.size(); i ++) {
                System.out.print(steps.elementAt(i));
            }
            System.out.println();
            
            if (result < min_result || min_result == 0){
                min_result = result;
                //recording current best solution
                bestSteps = new ArrayList<>();
                bestSteps.addAll(steps);
            }
        }
       
        if (current < goal){
            findCoin(current, 1, goal);
            result -= 10;
            //steps is not in the parameter list, 
            //during backtracking, always back the previous state
            steps.pop();
            findCoin(current, 2, goal);
            result -= 5;
            //steps is not in the parameter list, 
            //during backtracking, always back the previous state
            steps.pop();
        }
    }
}
