package T6;

import javax.swing.JOptionPane;

/**
 * 2017 spring solution
 * @author zw
 */
public class BinaryCal {
    
    static int[] strToInt(String str) {
        String[] tmp = str.split("");
        int[] num = new int[tmp.length];
        for (int i = tmp.length - 1; i >= 0; i --) {
            num[i] = Integer.parseInt(tmp[i]);
        }
        int[] res = new int[num.length];
        for(int i = 0; i < num.length; i ++) {
            res[num.length - 1 - i] = num[i];
        }
        return res;
    }
    
    static int calBinary(int[] num) {
        return calBinary(num, 0);
    }
    
    private static int calBinary(int[] num, int i) {
        int res = 0;
        while(i < num.length) {
            res += (int) (Math.pow(2, i) * num[i]);
            i ++;
            calBinary(num, i);
        } 
        return res;
    }
    
    static String calString(int num) {
        if(num == 0) {return "0";}
        double len = Math.log(num) / Math.log(2);
        int finalLen = ((int) len) + 1;
        int[] arr = new int[finalLen];
        return calString(num, arr, 0);
    }
    
    private static String calString(int num, int[] arr, int i) {
        if(num == 1) {
            arr[0] = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        while(i < arr.length) {
            double tmp0 = Math.log(num) / Math.log(2);
            int tmp = (int) tmp0;
            if(tmp0 >= 1) {
                arr[tmp] = 1;
                num -= Math.pow(2, tmp);
            }
            i ++;
            calString(num, arr, i);
        }
        for(int j = arr.length - 1; j >= 0; j --) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        String str = JOptionPane.showInputDialog("Input a binary text string(e.g.1011): ");
        int[] num = strToInt(str);
        System.out.println(str + " ==> " + calBinary(num));
        
        String str1 = JOptionPane.showInputDialog("Input a number(e.g.11): ");
        int num2 = Integer.valueOf(str1);
        System.out.println("Binary result by JDK: "+ Integer.toBinaryString(num2));
        JOptionPane.showMessageDialog(null, str1 + " ==> "+ calString(num2));
    }
}
