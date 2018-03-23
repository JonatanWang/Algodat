/*
 * a) Skriv ett program som läser in en karta från en textfil. 
 * Textfilen innehåller först antal länder och sedan antal gränser 
 * och därefter följer på varje rad två tal som representerar att dessa länder har en gräns. 
 * Ex:
 * 4
 * 5 
 * 0 1 
 * 0 2 
 * 1 2 
 * 1 3 
 * 2 3
 * Därefter ska programmet med hjälp av algoritmen från föreläsningen presentera 
 * vilken färg varje land ska färgläggas i så att man använder få färger 
 * men angränsande länder aldrig har samma färg.
 * b) Förbättra nu programmet så att algoritmen hela tiden väljer ett av de länder 
 * som angränsar till flest redan valda länder.
 */
package T12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N37_2 {

    private static void fourColorMap(String dir) {
        
        int[] res;      // result: set of color corresponding land 0 - (n - 1), i.e.(0 - 3)
        int color = 1;  // color counter
        int area = 1;   // land counter
        int k;          // counter
        
        try {   // read in file
            BufferedReader in = new BufferedReader(new FileReader(dir));
            String line = "";
            // construct adjacent matrix border[i][j]
            // number of borders unused      
            int numLand = Integer.parseInt(in.readLine());
            int numBorder = Integer.parseInt(in.readLine());
            res = new int[numLand];
            res[0] = 1; // set 1st land color 1

            int[][] border = new int[numLand][numLand];
            // init border all false/ unconnected
            for(int i = 0; i < border.length; i ++) {
                for(int j = 0; j < border.length; j ++) {
                    border[i][j] = 0;
                }
            }
            // read in borders from file, if connected set 1 symmetrically
            for(int i = 0; i < border.length; i ++) {
                for(int j = 0; j < border.length; j ++) {
                    while((line = in.readLine()) != null) {
                        int m = Integer.parseInt(String.valueOf(line.charAt(0)));
                        int n = Integer.parseInt(String.valueOf(line.charAt(1)));
                        //System.out.println("m = " + m + ", n = " + n);
                        border[m][n] = 1;
                        border[n][m] = 1;
                    }
                }
            }
            
            // check if all lands arer already painted            
            while(area < numLand) {
                // check if all 4 colors have been used
                while(color <= 4) {
                    
                    if(area >= numLand) {
                        break;
                    }
                    k = 0;
                    // check if re-paint same color
                    while(k < area && (res[k] * border[area][k] != color)) {
                        k ++;
                    }
                    if(k < area) {
                        color ++;
                    } else {
                        res[area] = color;
                        area ++;
                        color = 1;
                    }
                }
                if(color > 4) { // not found proper color, backtracking
                    area --;
                    color = res[area] + 1;
                }
            }
            System.out.println("Lands 1 - " + numLand + " are painted by colors: ");
            print(res);

//            for(int i = 0; i < border.length; i ++) {
//                for(int j = 0; j < border.length; j ++) {
//                    System.out.print(border[i][j] + " ");
//                }
//            }

        } catch(IOException e) {
            e.printStackTrace(System.err);
                System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        
        String DIR = "src/T12/map";
        fourColorMap(DIR);
    }

    private static void print(int[] a) {
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
    }
    
    private static void printBool(boolean[] a) {
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
    }
}
