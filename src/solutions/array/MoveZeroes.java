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

    public void moveZeroes1(int[] nums) {
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros ++;
            }
            if (zeros != 0 && nums[i] != 0) {
                nums[i - zeros] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
