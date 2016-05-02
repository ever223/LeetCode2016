package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 12:06.
 * @DESCRIPTION:
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        permute(new ArrayList<Integer>(), used, permutations, nums);
        return permutations;
    }
    public void permute(List<Integer> list, boolean[] used, List<List<Integer>> permutations, int[] nums) {
        if (list.size() == nums.length) {
            permutations.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                permute(list, used, permutations, nums);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
