package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 19:46.
 * @DESCRIPTION:
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return (root == null)
                || (Math.abs(getDepth(root.left) - getDepth(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right));
    }
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
