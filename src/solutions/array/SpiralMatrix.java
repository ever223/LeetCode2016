package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 17:16.
 * @DESCRIPTION:
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        //			top
        // left				right
        //			bottom
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i ++) {
                result.add(matrix[top][i]);
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left ++;
        }
        return result;
    }
}
