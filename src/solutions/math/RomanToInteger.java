package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 18:53.
 * @DESCRIPTION:
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Integer[] radixs = {1000, 500, 100, 50, 10, 5, 1};
        String romans= "MDCLXVI";
        int num = 0;
        for (int i = 0; i < s.length() - 1; i ++) {
            int pos1 = romans.indexOf(s.charAt(i));
            if (i == s.length() - 1) {
                num += radixs[pos1];
                break;
            }
            int pos2 = romans.indexOf(s.charAt(i + 1));
            if (pos1 <= pos2) {
                num += radixs[pos1];
            } else {
                num -= radixs[pos2];
            }
        }
        return num;
    }
}
