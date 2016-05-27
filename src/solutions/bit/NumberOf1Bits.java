package solutions.bit;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 19:13.
 * @DESCRIPTION:
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            ones += n & 1;
            n >>>= 1;
        }
        return ones;
    }
}
