package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-11 23:21.
 * @DESCRIPTION:
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        while(n >= 2) {
            if(n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return n == 1;
    }
    // 2^30 = 1073741824 < 2^31 - 1
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && 1073741824 % n == 0;
    }
}
