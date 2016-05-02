package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 23:15.
 * @DESCRIPTION:
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if(n == 0) {
            return 0;
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    grid[0][j] += grid[0][j - 1];
                } else if(j == 0) {
                    grid[i][0] += grid[i -1][0];
                } else {
                    grid[i][j] += Math.min(grid[i -1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
