package solutions.dp;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-13 23:08.
 * @DESCRIPTION:
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] liss = new int[length];
        Arrays.fill(liss, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && (liss[j] + 1 > liss[i])) {
                    liss[i] = liss[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, liss[i]);
        }
        return max;
    }
}
