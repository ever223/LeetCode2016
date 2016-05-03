package solutions.binarysearch;

import javax.sound.midi.MidiChannel;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 17:22.
 * @DESCRIPTION:
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else if (matrix[row][col] > target) {
                right = mid;
            } else {
                return true;
            }
        }
        return false;
    }

}
