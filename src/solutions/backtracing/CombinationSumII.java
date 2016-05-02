package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 22:14.
 * @DESCRIPTION:
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, new ArrayList<Integer>(), result, candidates, target);
        return result;
    }
    public void combinationSum2(int begin, List<Integer> curList, List<List<Integer>> result, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curList));
            return;
        }
        int candidate = -1;
        for (int i = begin; i < candidates.length && candidates[i] <= target; i++) {
            if (candidate == candidates[i]) {
                continue;
            }
            curList.add(candidates[i]);
            combinationSum2(i + 1, curList, result, candidates, target - candidates[i]);
            curList.remove(curList.size() - 1);
            candidate = candidates[i];
        }
    }
}
