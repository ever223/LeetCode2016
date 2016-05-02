package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-02 12:33.
 * @DESCRIPTION:
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        permute(visited, new ArrayList<>(), permutations, nums);
        return permutations;
    }
    public void permute(boolean[] visited, List<Integer> list, List<List<Integer>> permutations, int[] nums) {
        if (list.size() == nums.length) {
            permutations.add(new ArrayList<>(list));
        }
        int i = 0;
        while (i < nums.length) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                permute(visited, list, permutations, nums);
                visited[i] = false;
                list.remove(list.size() - 1);
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i ++;
                }
            }
            i ++;
        }
    }
}
