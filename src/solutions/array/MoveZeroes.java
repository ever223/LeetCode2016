package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-11 19:28.
 * @DESCRIPTION:
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int notZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeros ++] = nums[i];
            }
        }
        for (int i = notZeros; i < nums.length; i ++) {
            nums[i] = 0;
        }
    }
}
