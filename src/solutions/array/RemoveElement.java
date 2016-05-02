package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 11:15.
 * @DESCRIPTION:
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        int length = nums.length;
        while ( left < right) {
            while (nums[left] != val && left < right) {
                left ++;
            }
            while (nums[right] == val && left < right) {
                right --;
                length --;

            }
            if (left < right) {
                nums[left] = nums[right];
                left ++;
                right --;
                length --;
            }
        }
        if (left == right && nums[left] == val) {
            length --;
        }
        return length;
    }
}
