/*
 * !!!!! Unfinished
 * Skriv ett program som läser in en avståndstabell för ett antal städer 
 * från fil och sedan använder en girig algoritm 
 * för att försöka hitta en kort rutt för att besöka alla städer. 
 * Låt användaren få ange startstad så att man kan prova olika startstäder. 
 * Programmet ska sedan presentera rutten.
 */
package T12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N38 {
    
    private static final int INF = Integer.MAX_VALUE;
    private static int[] col;
    private static int[] row;
    private static int[][] map;
    private static int numLines;
    
    private static void route(String dir) {
        
        try {
            
            BufferedReader in = new BufferedReader(new FileReader(dir));
            String line = "";
            Queue<String> tokens = new LinkedList<>();
            while((line = in.readLine()) != null) {
                tokens.add(line);
                numLines ++;
            }
            in.close();
            System.out.print("Input start city [0 - " + (numLines - 1) + "]: ");
            Scanner  scan = new Scanner(System.in);
            int start = scan.nextInt();
            if(start > numLines - 1 || start < 0) {
                System.out.println("Input right start!");
                return;
            } else {
                System.out.println("Start from: " + start);
            }
            // init the map
            map = new int[numLines][numLines];
            for(int i = 0; i < map.length; i ++) {
                String[] distances = tokens.poll().split(" ");
                for(int j = 0; j < map[i].length; j ++) {      
                    map[i][j] = Integer.valueOf(distances[j]);
                    map[j][i] = Integer.valueOf(distances[j]);
                    if(map[i][j] == 0) {
                        map[i][j] = INF;
                        map[j][i] = INF;
                    }
                }
            }
            // test
            // printMap(map);
            int s = 0;  // total distance
            int i = start;  // start point
            int j;  // next point
            String path = String.valueOf(start);
            col = new int[numLines]; 
            row = new int[numLines];
            int[] tmp = new int[numLines];
            for(int k = 0; k < numLines; k ++) {
                col[k] = 1;
                row[k] = 1;
            }
            col[start] = 0;
            // default: start from 0
            while(row[i] == 1) {
                // copy a line
                for(int l = 0; l < numLines; l ++) {
                    tmp[l] = map[i][l];
                }
                // select next point: unvisited && differ from i
                j = selectMin(tmp, start);
                //j = selectMin1(tmp, i);
                // find next point
                row[i] = 0; // set 0, visited
                col[j] = 0; // set 0, visited
                
                path += " -> " + j;
                s += map[i][j];
                i = j;
            }
            System.out.println("Path: " + path);
            System.out.println("Distance: " + s);
        
        } catch(IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private static void printMap(int[][] map) {
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[i].length; j ++) {
                System.out.print(map[i][j] + " ");
            }
        }
    }

    private static int selectMin(int[] p, int start) {
        
        int j = start; int k = 0; int m = p[start];
        // search the first usable point
        while(col[j] == 0) {
            
            j ++;
            if(j >= numLines) {
                // no usable point, searching finishes.
                m = p[start];
                break;
            } else {
                m = p[j];
            }
        }
        // search from j backwards, to find the point with minimal distance
        for(; j < numLines; j ++) {
            if(col[j] == 1) {
                if(m >= p[j]) {
                    m = p[j];
                    k = j;
                }
            }
        }
        // search from 0 - start, to find the point with minimal distance
        for(int q = 0; q <= start; q ++) {
            if(col[q] == 1) {
                if(m >= p[q]) {
                    m = p[q];
                    k = q;
                }
            }
        }
        return k;
    }
        
    public static void main(String[] args) {
        
        String dir = "src/T12/distance";
        route(dir);
    }

    private static int selectMin1(int[] p, int i) {
        int res = 0; int min = INF;
        for(int j = 0; j < p.length; j ++) {
            if(min > p[j] && j != i) {
                min = p[j];
                res = j;
            }
        }
        return res;
    }
}
