package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 10:59.
 * @DESCRIPTION:
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[length]) {
                nums[length ++] = nums[i];
            }
        }
        return length + 1;
    }
}
