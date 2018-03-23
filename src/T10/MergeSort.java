/*
 * MergeSort based on NB:s lecture
 */
package T10;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class MergeSort {
    
    public static void sort(int[] a) {
        
        int n = a.length;
        
        if(n == 1) {
            return;
        }
        
        int mid = n / 2;
        int[] b = Arrays.copyOfRange(a, 0, mid);
        int[] c = Arrays.copyOfRange(a, mid, n);
        
        sort(b);
        sort(c);
        
        merge(a, b, c);
    }

    private static void merge(int[] a, int[] b, int[] c) {
        
        int ia = 0; int ib = 0; int ic = 0;
        
        while(ib < b.length && ic < c.length) {
            if(b[ib] <= c[ic]) {
                a[ia ++] = b[ib ++];
            } else {
                a[ia ++] = c[ic ++];
            }
        }
        
        while(ib < b.length) {
            a[ia ++] = b[ib ++];
        }
        
        while(ic < c.length) {
            a[ia ++] = c[ic ++];
        }        
    }
}
