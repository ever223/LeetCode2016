package solutions.sort;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 23:31.
 * @DESCRIPTION:
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
