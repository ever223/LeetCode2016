package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 18:17.
 * @DESCRIPTION:
 */
public class RotateArray {

    // Solution 1
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k);
        reverse(nums, n- k, n);
        reverse(nums, 0, n);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, --end);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // Solution 2
    public void rotate1(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        int[] reverse = new int[n];
        for(int i = n - k; i < n; i ++) {
            reverse[i - (n - k)] = reverse[i];
        }
        for(int i = 0; i < n - k; i ++) {
            reverse[k + i] = reverse[i];
        }
        System.arraycopy(reverse, 0, nums, 0, n);
    }

    // Solution 3
    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;
        for(int i = 0; i < k; i ++) {
            for(int j = n - 1; j > 0; j --) {
                swap(nums, j, j - 1);
            }
        }
    }

}
