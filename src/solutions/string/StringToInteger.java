package solutions.string;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-29 15:58.
 * @DESCRIPTION:
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int flag = 1;
        if (str.charAt(i) == '+') {
            flag = 1;
            i ++;
        }else if (str.charAt(i) == '-') {
            flag = -1;
            i ++;
        }
        for (; i < str.length(); i ++) {
            int mod = str.charAt(i) - '0';
            if (mod < 0 || mod > 9) {
                break;
            }
            if (flag > 0) {
                if (result > Integer.MAX_VALUE / 10
                        || (result == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (result > Integer.MAX_VALUE / 10
                        || (result == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10 + 1)) {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + mod;
        }

        return result * flag;
    }
}
