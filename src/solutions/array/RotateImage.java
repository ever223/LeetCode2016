package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 13:07.
 * @DESCRIPTION:
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i- 1] = temp;
            }
        }
    }


    // 2015
    static void rotate1(int[][] matrix) {

        int n = matrix.length - 1;
        for(int i =  0; i <= n / 2; i ++)
            for(int j = i; j < n - i; j ++) {
                //旋转四个位置相同的点

                //旋转前的位置关系
                //			( i   j) . . . ( j   n-i)
                //				.			   .
                //				.			   .
                //				.			   .
                //			(n-j  i) . . . (n-i  n-j)

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;

                //旋转后的位置关系
                //			(n-j   i ) . . . ( i    j )
                //				.			   	 .
                //				.			     .
                //				.			     .
                //			(n-i  n-j) . . . ( j   n-i)
            }
    }
}
