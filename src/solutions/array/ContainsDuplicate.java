package solutions.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-09 15:47.
 * @DESCRIPTION:
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
