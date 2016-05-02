package solutions.backtracing;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 16:25.
 * @DESCRIPTION:
 */
public class NQueensII {
    public int totalNQueens(int n) {

        boolean[] column = new boolean[n];
        boolean[] mainDiag= new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];

        Arrays.fill(column, false);
        Arrays.fill(mainDiag, false);
        Arrays.fill(antiDiag, false);

        return nQueens(0, column, mainDiag, antiDiag, 0, n);
    }
    public int nQueens(int row, boolean[] column, boolean[] mainDiag, boolean[] antiDiag, int total, int n) {

        if (row == n) {
            return total + 1;
        }

        for (int i = 0; i < n; i++) {

            if (column[i] || mainDiag[i + row] || antiDiag[n - i + row]) {
                continue;
            }

            column[i] = true;
            mainDiag[i + row] = true;
            antiDiag[n - i + row] = true;

            total = nQueens(row + 1, column, mainDiag, antiDiag, total, n);

            column[i] = false;
            mainDiag[i + row] = false;
            antiDiag[n - i + row] = false;
        }
        return total;
    }
}
