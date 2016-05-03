package solutions.sort;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 18:55.
 * @DESCRIPTION:
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] == 2) {
                while (i <= right && nums[right] == 2) {
                    right --;
                }
                if (i >= right) {
                    return;
                }
                swap(nums, i, right--);
            }
            if (nums[i] == 0) {
                swap(nums, i, left ++);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
