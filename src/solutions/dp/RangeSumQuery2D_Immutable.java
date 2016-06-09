package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-08 22:36.
 * @DESCRIPTION:
 */
public class RangeSumQuery2D_Immutable {

    // extra space
    public class NumMatrix {

        private int[][] sum;
        public NumMatrix(int[][] matrix) {
            int rows = matrix.length;
            int cols = (rows == 0) ? 0 : matrix[0].length;
            sum = new int[rows + 1][cols + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + matrix[i][j];
                }
                for (int j = 0; j < cols; j++) {
                    sum[i + 1][j + 1] += sum[i][j + 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        }
    }

    // no extra space
    public class NumMatrix1 {

        private int[][] matrix;
        public NumMatrix1(int[][] matrix) {
            int rows = matrix.length;
            int cols = (rows == 0) ? 0 : matrix[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols - 1; j++) {
                    matrix[i][j + 1] += matrix[i][j];
                }
            }
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i + 1][j] += matrix[i][j];
                }
            }
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
           return matrix[row2][col2]
                   - ((col1 == 0) ? 0 : matrix[row2][col1 - 1])
                   - (row1 == 0 ? 0 : matrix[row1 - 1][col2])
                   + (col1 == 0 || row1 == 0 ? 0 : matrix[row1 - 1][col1 - 1]);
        }
    }

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.matrix(0, 1, 2, 3);
// numMatrix.matrix(1, 2, 3, 4);
}
