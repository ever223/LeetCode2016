package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 22:37.
 * @DESCRIPTION:
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] path = new int[m][n];
        path[0][0] = 1;

        for (int i = 1; i < n; i++) {
            path[0][i] = (obstacleGrid[0][i] == 1) ? 0 : path[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            path[i][0] = (obstacleGrid[i][0] == 1) ? 0 : path[i - 1][0];
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i - 1][j] + path[i][j -1];
            }
        }
        return path[m -1][n -1];
    }
}
