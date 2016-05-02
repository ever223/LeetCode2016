package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 14:07.
 * @DESCRIPTION:
 * 在一个N*N的矩阵上面放置N个物体，
 * 一个矩阵点只允许放置一个物体，
 * 任意两个点不能在一行上，
 * 也不能在一列上，
 * 不能在一条左斜线上，
 * 当然也不能在一条右斜线上。
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {

        String[] mapping = new String[n];
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            sb.replace(i, i + 1, "Q");
            mapping[i] = sb.toString();
            sb.replace(i, i + 1, ".");
        }

        boolean[] mainDiag = new boolean[n * 2];
        boolean[] antiDiag = new boolean[n * 2];
        boolean[] columns = new boolean[n];
        Arrays.fill(mainDiag, false);
        Arrays.fill(antiDiag, false);
        Arrays.fill(columns, false);

        int[] positions = new int[n];
        Arrays.fill(positions, -1);

        List<List<String>> result = new ArrayList<>();
        dfs(0, positions, columns, mainDiag, antiDiag, result, mapping);
        return result;
    }
    public void dfs(int row,
                    int[] positions,
                    boolean[] columns,
                    boolean[] mainDiag,
                    boolean[] antiDiag,
                    List<List<String>> result,
                    String[] mapping) {
        int n = columns.length;
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (Integer column : positions) {
                list.add(mapping[column]);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns[i] || mainDiag[row + i] || antiDiag[n - i + row]) {
                continue;
            }
            positions[row] = i;
            mainDiag[row + i] = true;
            antiDiag[n - i + row] = true;
            columns[i] = true;

            dfs(row + 1, positions, columns, mainDiag, antiDiag, result, mapping);

            positions[row] = -1;
            mainDiag[row + i] = false;
            antiDiag[n - i + row] = false;
            columns[i] = false;
        }
    }
}
