package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 11:09.
 * @DESCRIPTION:
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int start = 0;
        int end = nums.length;
        while(start != end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else if(nums[start] > nums[mid]) {
                if (nums[mid] < target && target <= nums[end - 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                start ++;
            }
        }
        return false;
    }
}
