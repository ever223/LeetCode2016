package solutions.binarysearch;

import java.util.Stack;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-28 23:07.
 * @DESCRIPTION:
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersion1(int n) {
        return bs(1, n);
    }
    public int bs(int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + ((right - left) >> 1);
        return isBadVersion(mid) ? bs(left, mid) : bs(mid + 1, right);
    }
}
