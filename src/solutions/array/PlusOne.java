package solutions.array;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 09:35.
 * @DESCRIPTION:
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        if (digits[n - 1] < 9) {
            digits[n - 1] += 1;
            return digits;
        }
        int i = n - 1;

        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i --;
        }
        if (i >= 0) {
            digits[i] += 1;
            return digits;
        } else {
            int[] result = new int[n + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        }
    }
}
