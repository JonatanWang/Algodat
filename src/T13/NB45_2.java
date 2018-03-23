/*
 * Find Majority Element
 */
package T13;

import java.util.Arrays;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB45_2 {
    
    private static int findMajority(int[] a) {
        
        int n = a.length;
        
        if (n == 1) {
            return a[0];
        }
        
        if(n == 2) {
            
            if(a[0] == a[1]) {
                return a[0];
            } else {
                return -1;
            }
        }
        return findMajority(a, 0, n-1);
    }
    
    public static void main(String[] args) {
        
        int[] a = {6, 8, 8, 6, 8, 6, 6, 8, 6, 8, 6};
        System.out.println("majority = " + findMajority(a));
    }

    private static int count(int[] a, int left, int right, int e) {
    
        int cnt = 0;
        for(int i = left; i <= right; i ++) {
            if(a[i] == e) {
                cnt ++;
            }
        }
        return cnt;
    }
//    
//    private static int merge(int e1, int e2) {
//
//        if(e1 == -1 && e2 >= 0) {
//            
//            return e2;
//        } 
//        
//        if (e1 >= 0 && e2 == -1) {
//            return e1;
//        } 
//                
//        if(e1 == e2) {
//            return e1;
//        } 
//        
//        if (e1 != e2) {
//            return -1;
//        }
//        return -1;   
//    }

    private static int findMajority(int[] a, int left, int right) {
        
        int n = a.length;
        if(left > right) {
            return -1;
        }
        if(left == right) {
            return a[left];
        }
        int mid = left + (right - left) / 2;
        int e1 = findMajority(a, left, mid);
        int e2 = findMajority(a, mid + 1, right);
        
        if(e2 >= 0) {
            int num = count(a, left, right, e2);
            if (num > (right - left + 1) / 2) {
		return e2;
            }
        }
 
        if (e1 >= 0) {
            int num = count(a, left, right, e1);
		if (num > (right - left + 1) / 2) {
                    return e1;
		}
        }
        return -1;
            
    }
}
