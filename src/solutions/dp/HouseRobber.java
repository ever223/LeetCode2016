package solutions.dp;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-09 15:40.
 * @DESCRIPTION:
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums) {
            int temp = sum2;
            sum2 = Math.max(num + sum1, sum2);
            sum1 = temp;
        }
        return sum2;
    }
}
