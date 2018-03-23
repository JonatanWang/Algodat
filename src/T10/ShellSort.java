/*
 * Shell sort based on NB:s lecture
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class ShellSort {
    
    public static void sort(int[] a) {
        
        int n = a.length;

        int gap = n / 2;
        
        while (gap > 0) {
            for(int i = gap; i < n; i ++) { 
            // i < n, in NB:s pdf i < n - 1, he means to and with i == n -1
                int data  = a[i];
                int dataIndex = i;
                while(dataIndex > (gap - 1) && data < a[dataIndex - gap]) {
                    a[dataIndex] = a[dataIndex-gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if(gap == 2) {
                gap = 1;
            } else {
                gap = (int) (gap / 2.2);
            }
        }
    }
}
