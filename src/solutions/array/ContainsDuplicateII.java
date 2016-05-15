package solutions.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 11:52.
 * @DESCRIPTION:
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i]) && (i - m.get(nums[i]) <= k)) {
                return true;
            }
            if (m.size() > k) {
                m.remove(nums[i - k]);
            }
            m.put(nums[i], i);
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = m.get(nums[i]);
            if (pos == null) {
                m.put(nums[i], i);
            } else {
                if (i - pos > k) {
                    m.replace(nums[i], i);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
