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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i ++) {
            subsetsWithDup(0, i, new ArrayList<Integer>(), subsets, nums);
        }
        return subsets;
    }
    public void subsetsWithDup(int begin, int size, List<Integer> subset, List<List<Integer>> subsets, int[] nums) {
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
                subsetsWithDup(i + 1, size, subset, subsets, nums);
                subset.remove(subset.size() - 1);
                pre = nums[i];
            }
        }
    }
}
