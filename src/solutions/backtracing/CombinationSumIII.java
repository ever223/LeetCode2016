package solutions.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-09 16:02.
 * @DESCRIPTION:
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sums = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<Integer>(), sums);
        return sums;
    }
    public void combinationSum3(int k, int n, int start, List<Integer> sum, List<List<Integer>> sums) {
        if (k == 0 && n == 0) {
            sums.add(new ArrayList<>(sum));
            return;
        }
        if(k == 0 || start > n || n == 0) {
            return;
        }

        for (int i = start; i < 10; i ++) {
            sum.add(i);
            combinationSum3(k - 1, n - i, i + 1, sum, sums);
            sum.remove(sum.size() - 1);
        }
    }
}
