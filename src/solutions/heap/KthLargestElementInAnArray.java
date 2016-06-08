package solutions.heap;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-07 23:09.
 * @DESCRIPTION:
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        heap(nums, k);
        return nums[nums.length - k];
    }
    private void heap(int[] nums, int k) {
        int heapSize = nums.length - 1;
        for(int i = heapSize / 2; i >= 0; i --) {
            adjust(nums, i, heapSize);
        }
        for (int i = nums.length - 1; (i + k) >= nums.length; i --) {
            swap(nums, 0, i);
            heapSize --;
            adjust(nums, 0, heapSize);
        }
    }
    private void adjust(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left <= heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right <= heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(nums, largest, index);
            adjust(nums, largest, heapSize);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
