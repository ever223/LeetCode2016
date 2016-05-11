package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-11 23:32.
 * @DESCRIPTION:
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        while (num >= 4) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return num == 1;
    }

//    public boolean isPowerOfFour1(int num) {
//        return num > 0 && 1073741824 % num == 0 && 536870912 % num != 0;
//    }
}
