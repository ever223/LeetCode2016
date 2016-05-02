package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 21:56.
 * @DESCRIPTION:
 */
public class UniquePaths {

    // 超时
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int down = uniquePaths1(m - 1, n);
        int right = uniquePaths1(m, n - 1);
        return down + right;
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] path = new int[m][n];
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}
