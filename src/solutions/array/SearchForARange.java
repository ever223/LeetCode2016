package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 16:45.
 * @DESCRIPTION:
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        searchRange(0, nums.length, range, nums, target);
        return range;
    }
    public void searchRange(int left, int right, int[] range, int[] nums, int target) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            for (int i = mid; i >= left && nums[i] == target; i--) {
                range[0] = i;
            }
            for (int i = mid; i < right && nums[i] == target; i++) {
                range[1] = i;
            }
        } else if (nums[mid] < target) {
            searchRange(mid + 1, right, range, nums, target);
        } else {
            searchRange(left, mid, range, nums, target);
        }
    }
}
