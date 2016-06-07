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
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}


// Your RangeSumQuery object will be instantiated and called as such:
// RangeSumQuery numArray = new RangeSumQuery(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
