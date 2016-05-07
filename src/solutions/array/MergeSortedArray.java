package solutions.array;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 18:52.
 * @DESCRIPTION:
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m + n - 1; i >= 0; i --) {
            int num1 = (m - 1 < 0) ? Integer.MIN_VALUE : nums1[m - 1];
            int num2 = (n - 1 < 0) ? Integer.MIN_VALUE : nums2[n - 1];
            nums1[i] = (num1 <= num2) ? nums2[--n] : nums1[--m];
        }
    }
}
