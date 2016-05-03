package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 10:09.
 * @DESCRIPTION:
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String sum = "";
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i < 0) ? 0 : a.charAt(i) - '0';
            int d2 = (j < 0) ? 0 : b.charAt(j) - '0';
            carry += d1 + d2;
            sum = carry % 2 + sum;
            carry /= 2;
            i --;
            j --;
        }
        return sum;
    }
}
