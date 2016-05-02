package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 16:01.
 * @DESCRIPTION:
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high - 1] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }

}
