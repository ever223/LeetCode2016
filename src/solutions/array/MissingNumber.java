package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 08:25.
 * @DESCRIPTION:
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i] - 1;
            }
        }
        return nums.length;
    }
    public void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums.length) {
                    break;
                }
                swap(nums, i, nums[i]);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
