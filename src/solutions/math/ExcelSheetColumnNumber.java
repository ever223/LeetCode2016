package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 19:41.
 * @DESCRIPTION:
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int col = 0;
        for(int i = 0; i < s.length(); i ++) {
            col = col * 26 + s.charAt(i) - 'A' + 1;
        }
        return col;
    }
}
