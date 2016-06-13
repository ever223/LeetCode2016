package solutions.array;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-06-13 20:13.
 * @DESCRIPTION:
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums) {
            if (!map.containsKey(num)) {
                Integer left = (map.get(num - 1) == null) ? 0 : map.get(num - 1);
                Integer right = (map.get(num + 1) == null) ? 0 : map.get(num + 1);

                int curLength = left + right + 1;
                longest = Math.max(longest, curLength);

                map.put(num, curLength);
                map.put(num - 1, curLength);
                map.put(num + 1, curLength);
            }
        }
        return longest;
    }
}
