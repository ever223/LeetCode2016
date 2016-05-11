package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-11 23:13.
 * @DESCRIPTION:
 */
public class PowerOfThree {
     public boolean isPowerOfThree(int n) {
         while(n >= 3) {
             if(n % 3 != 0) {
                 return false;
             }
             n /= 3;
         }
         return n == 1;
     }

    // 3^19 = 1162261467
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
