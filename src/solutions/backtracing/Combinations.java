package solutions.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 19:54.
 * @DESCRIPTION:
 */
public class Combinations {
    // Time Limit Exceeded
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        combine1(1, new ArrayList<Integer>(), combinations, n, k);
        return combinations;
    }
    public void combine1(int start, List<Integer> list, List<List<Integer>> combinations, int n, int left) {
        if (left == 0) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - left + 1; i ++) {
            list.add(start);
            combine1(start + 1, list, combinations, n, left - 1);
            list.remove(list.size() - 1);
        }
    }



    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        combine(0, new ArrayList<Integer>(), combinations, n, k);
        return combinations;
    }
    public void combine(int start, List<Integer> list, List<List<Integer>> combinations, int n, int k) {
        if (list.size() == k) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        if(start + k - list.size() > n) {
            return;
        }
        list.add(start + 1);
        combine(start + 1, list, combinations, n, k);
        list.remove(list.size() - 1);
        combine(start + 1, list, combinations, n, k);

    }
}
