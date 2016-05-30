package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-30 22:39.
 * @DESCRIPTION:
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        for (int i = result.length - 1; i >= 1; i --) {
            result[i] *= result[0];
            result[0] *= nums[i];
        }
        return result;
    }
}
