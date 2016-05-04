package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 09:31.
 * @DESCRIPTION:
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if(nums.length < 3) {
            return nums.length;
        }
        int index = 1;
        for(int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[index] && nums[i] == nums[index - 1]) {
                continue;
            }
            nums[++index] = nums[i];
        }
        return index + 1;
    }
}
