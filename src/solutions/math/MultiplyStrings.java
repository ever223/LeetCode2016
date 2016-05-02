package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 08:47.
 * @DESCRIPTION:
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String result = "0";
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String base = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String sum = multiply(num1, charToNum(num2.charAt(i))) + base;
            result = add(result, sum);
            base += "0";
        }
        return result;
    }
    public String multiply(String num, int digit) {
        if (digit == 0 || num.equals("0")) {
            return "0";
        }
        String result = "";
        int carry = 0;
        for(int i = num.length() - 1; i >= 0; i --) {
            int d1 = charToNum(num.charAt(i));
            int acc = d1 * digit + carry;
            result = (acc % 10) + result;
            carry = acc / 10;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;

    }
    public String add(String num1, String num2) {
        String sum = "";
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = i < 0 ? 0 : charToNum(num1.charAt(i));
            int d2 = j < 0 ? 0 : charToNum(num2.charAt(j));
            int acc = d1 + d2 + carry;
            sum = (acc % 10) + sum;
            carry = acc / 10;
            i --;
            j --;
        }
        return sum;

    }
    public int charToNum(char c) {
        return c - '0';
    }
}
