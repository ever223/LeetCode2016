package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 18:43.
 * @DESCRIPTION:
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i ++ ) {
                matrix[top][i] = (count ++);
            }
            top ++;
            for (int i = top; i <= bottom; i ++ ) {
                matrix[i][right] = (count ++);
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i--) {
                matrix[bottom][i] = (count ++);
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i--) {
                matrix[i][left] = (count ++);
            }
            left ++;
        }
        return matrix;
    }
}
