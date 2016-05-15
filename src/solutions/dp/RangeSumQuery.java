package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 18:39.
 * @DESCRIPTION:
 */
public class RangeSumQuery {

    private int[] nums;
    private int[] sum;
    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }


    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}


// Your RangeSumQuery object will be instantiated and called as such:
// RangeSumQuery numArray = new RangeSumQuery(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
