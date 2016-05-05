package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 22:52.
 * @DESCRIPTION:
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        boolean left = false;
        if (root.left != null) {
            left = hasPathSum(root.left, sum);
        }
        boolean right = false;
        if (root.right != null) {
            right = hasPathSum(root.right, sum);
        }
        return left || right;
    }
}
