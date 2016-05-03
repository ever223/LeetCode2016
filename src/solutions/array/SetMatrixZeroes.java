package solutions.array;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 16:08.
 * @DESCRIPTION:
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row1Zero = false;
        boolean col1Zero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                matrix[i][0] = 0;
                matrix[0][j] = 0;
                if (i == 0) {
                    row1Zero = true;
                }
                if (j == 0) {
                    col1Zero = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0
                        || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row1Zero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col1Zero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    // space O(mn), time O(mn)
    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rVisited = new boolean[m];
        boolean[] cVisited = new boolean[n];
        Arrays.fill(rVisited, false);
        Arrays.fill(cVisited, false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rVisited[i] = true;
                    cVisited[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rVisited[i] || cVisited[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
