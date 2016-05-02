package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 21:41.
 * @DESCRIPTION:
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, new ArrayList<Integer>(), result, candidates, target);
        return result;
    }
    public void combinationSum(int begin, List<Integer> list, List<List<Integer>> result, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = begin; i < candidates.length && candidates[i] <= target; i ++) {
            list.add(candidates[i]);
            combinationSum(i, list, result, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
