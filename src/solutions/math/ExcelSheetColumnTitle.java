package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 19:45.
 * @DESCRIPTION:
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if(n == 0) {
            return null;
        }
        String title = "";
        while(n != 0) {
            char c = (char)((n - 1) % 26 + (int) 'A');
            title = c + title;
            n = (n - 1) / 26;
        }
        return title;
    }
}
