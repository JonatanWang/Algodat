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
import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N37 {

    private static void fourColorMap(String dir) {
        try {   // read in file
            BufferedReader in = new BufferedReader(new FileReader(dir));
            String line = "";
            // construct border[i][j], land[i] & color[i]
            int numLand = Integer.parseInt(in.readLine());
            int[] land = new int[numLand];
            // init land
            for(int i = 0; i < land.length; i ++) {
                land[i] = 0;
            }
       
            int numBorder = Integer.parseInt(in.readLine());
            boolean[][] border = new boolean[numLand][numLand];
            // init border all false
            for(int i = 0; i < border.length; i ++) {
                for(int j = 0; j < border.length; j ++) {
                    border[i][j] = false;
                }
            }
            // read in borders from file, build adjacent matrix
            for(int i = 0; i < border.length; i ++) {
                for(int j = 0; j < border.length; j ++) {
                    while((line = in.readLine()) != null) {
                        int m = Integer.parseInt(String.valueOf(line.charAt(0)));
                        int n = Integer.parseInt(String.valueOf(line.charAt(1)));
                        //System.out.println("m = " + m + ", n = " + n);
                        border[m][n] = true;
                        border[n][m] = true;
                    }
                }
            }
            //for(int i=0;i<border.length;i++)
              //  System.out.println(Arrays.toString(border[i]));
            // init color array, 4 colors
            boolean[] color = new boolean[7];
            
            
            int n = land.length;
            for(int i = 0; i < n; i ++) {   //går igenom länderna så att vi hanterar land i nedan:
            for(int k = 0; k < color.length; k ++) {
                 color[k] =  false;
             }     
                for(int j = 0; j < n; j ++) {   //går igenom länderna för att hitta grannar till land i
                    if(border[i][j] && land[j] != 0) {
                        color[land[j]] = true;  //markerar angränsande färger
                    }
                }
                for(int j = 1; j < color.length; j ++) {    //går igenom färgerna för att hitta första lediga
                    if(!color[j]) {
                        land[i] = j;
                        break;  // avbryt for-loopen
                    }
                }
            }
            print(land);
            System.out.println("");
            printBool(color);
//            
//            for(int i = 0; i < color.length; i ++) {
//                System.out.println(color[i]);
//            }  
//            for(int i = 0; i < border.length; i ++) {
//                for(int j = 0; j < border.length; j ++) {
//                    System.out.print(border[i][j] + " ");
//                }
//            }
//            System.out.println("land size " + land.length + " border: " + border.length);

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
