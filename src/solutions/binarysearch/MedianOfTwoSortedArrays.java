package solutions.binarysearch;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 09:48.
 * @DESCRIPTION:
 */
public class MedianOfTwoSortedArrays {
    public double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        if(totalLength % 2 != 0) {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2);
        } else {
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2)
            + findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2 - 1)) * 0.5;
        }
    }
    public double findKth(int[] nums1, int start1, int end1,
                          int[] nums2, int start2, int end2,
                          int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if(len1 == 0) {
            return nums2[start2 + k];
        }
        if(len2 == 0) {
            return nums1[start1 + k];
        }
        if(k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid1 = len1 * k / (len1 + len2);
        int mid2 = k - mid1 - 1;
        mid1 += start1;
        mid2 += start2;

        if (nums1[mid1] > nums2[mid2]) {
            k -= (mid2 - start2 + 1);
            end1 = mid1;
            start2 = mid2 + 1;
        } else {
            k -= (mid1 - start1 + 1);
            end2 = mid2;
            start1 = mid1 + 1;
        }

        return findKth(nums1, start1, end1, nums2, start2, end2, k);
    }
}
