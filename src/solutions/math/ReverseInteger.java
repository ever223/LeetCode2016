package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-29 15:20.
 * @DESCRIPTION:
 */

//Reverse digits of an integer.
//
//        Example1: x = 123, return 321
//        Example2: x = -123, return -321

public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int mod = x % 10;
            if (x > 0) {
                if (result > Integer.MAX_VALUE / 10
                        || (result == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
            } else {
                if (result < Integer.MIN_VALUE / 10
                        || (result == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
            }
            result = result * 10 + mod;
            x /= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-1013));

    }
}
