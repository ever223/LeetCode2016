package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 16:46.
 * @DESCRIPTION:
 */
public class MaximumSubarray {
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < 0 && curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
                if (curSum < nums[i]) {
                    curSum = nums[i];
                }
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            max = Math.max(max, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }
}
