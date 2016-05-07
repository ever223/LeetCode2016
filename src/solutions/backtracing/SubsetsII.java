package solutions.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 19:24.
 * @DESCRIPTION:
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (num == null) {
            return ret;
        }

        Arrays.sort(num);

        dfs(num, new ArrayList<Integer>(), ret, 0);

        return ret;
    }

    public void dfs(int[] num, List<Integer> path, List<List<Integer>> ret, int index) {
        ret.add(new ArrayList<Integer>(path));

        for (int i = index; i < num.length; i++) {
            // skip the duplicate.
            if (i > index && num[i] == num[i - 1]) {
                continue;
            }

            path.add(num[i]);
            // 注意：这里是i + 1不是index + 1!!!
            dfs(num, path, ret, i + 1);
            path.remove(path.size() - 1);
        }

    }



    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i ++) {
            subsetsWithDup1(0, i, new ArrayList<Integer>(), subsets, nums);
        }
        return subsets;
    }
    public void subsetsWithDup1(int begin, int size, List<Integer> subset, List<List<Integer>> subsets, int[] nums) {
        if(subset.size() == size) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        if(nums.length - begin < size - subset.size()) {
            return;
        }
        int pre = nums[begin];
        for(int i = begin; i < nums.length; i ++) {
            if(i == begin || nums[i] != pre) {
                subset.add(nums[i]);
                subsetsWithDup1(i + 1, size, subset, subsets, nums);
                subset.remove(subset.size() - 1);
                pre = nums[i];
            }
        }
    }
}
