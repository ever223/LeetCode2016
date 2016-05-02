package solutions.binarysearch;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 18:37.
 * @DESCRIPTION:
 */
public class SearchInsertPosition {
    public int searchInsert1(int[] nums, int target) {
        return bs(0, nums.length,  nums, target);
    }
    public int  bs(int left, int right, int[] nums, int target) {
        if (right == left) {
            return right;
        }
        int mid = (left + right) / 2;
        if (nums[mid] < target) {
            return bs(mid + 1, right, nums, target);
        } else if (nums[mid] > target) {
            return bs(left, mid, nums, target);
        } else {
            return mid;
        }
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
