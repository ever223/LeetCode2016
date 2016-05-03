package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 22:31.
 * @DESCRIPTION:
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            subsets(0, i, new ArrayList<Integer>(), result, nums);
        }
        return result;
    }
    public void subsets(int start, int k, List<Integer> list, List<List<Integer>> result, int[] nums) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (nums.length - start < k - list.size()) {
            return;
        }
        list.add(nums[start]);
        subsets(start + 1, k, list, result, nums);
        list.remove(list.size() - 1);
        subsets(start + 1, k, list, result, nums);
    }
}
