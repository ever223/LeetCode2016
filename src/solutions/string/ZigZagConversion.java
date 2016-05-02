package solutions.string;

import java.util.Objects;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-29 14:26.
 * @DESCRIPTION:
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
        String result = "";

        String[][] matrix = new String[numRows][s.length() / 2 + 1];
        for (int m = 0; m < matrix.length; m ++) {
            for (int n = 0; n < matrix[0].length; n ++) {
                matrix[m][n] = "";
            }
        }
        int i = 0;
        for (int col = 0; col < matrix[0].length; col += (numRows - 1)) {
            for (int row = 0; row < numRows; row ++) {
                if (i < s.length()) {
                    matrix[row][col] = s.charAt(i++) + "";
                }
            }
            for (int row = numRows - 2; row > 0; row --) {
                if (i < s.length()) {
                    matrix[row][col + numRows - row - 1] = s.charAt(i++) + "";
                }
            }
        }
        for (String[] aMatrix : matrix) {
            for (int n = 0; n < matrix[0].length; n++) {
                if (!Objects.equals(aMatrix[n], "")) {
                    result += aMatrix[n];
                }
            }
        }
        return result;
    }
}
