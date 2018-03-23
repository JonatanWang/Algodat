/*
 * Divide & conquer
 * exp(a, b)
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Exp {
    
  private static int exp(int a, int b) {
      if(b == 0) {
          return 1;
      }
      if(b == 1) {
          return a;
      }
      
      int p = exp(a, b/2);
      if(b % 2 == 0) {
          return p * p;
      }
      return p * p * a;
  }
  
  public static void main(String[] args) {
  
      System.out.println(exp(3, 0));
  }
}
