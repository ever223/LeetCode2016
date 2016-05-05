package solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 23:22.
 * @DESCRIPTION:
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, new ArrayList<Integer>(), paths, sum);
        return paths;
    }
    public void pathSum(TreeNode root, List<Integer> path, List<List<Integer>> paths, int sum) {
        if(root == null) {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        if(sum == 0 && root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if(root.left != null) {
            pathSum(root.left, new ArrayList<>(path), paths, sum);
        }
        if(root.right != null) {
            pathSum(root.right, new ArrayList<>(path), paths, sum);
        }
    }
}
