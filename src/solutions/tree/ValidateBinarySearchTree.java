package solutions.tree;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 11:41.
 * @DESCRIPTION:
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val >= min && root.val <= max) {
            boolean left;
            boolean right;
            if (root.val == Integer.MIN_VALUE) {
                left = (root.left != null);
            } else {
                left = isValidBST(root.left, min, root.val - 1);
            }
            if (root.val == Integer.MAX_VALUE) {
                right = (root.right != null);
            } else {
                right = isValidBST(root.right, root.val + 1, max);
            }
            return left && right;
        }
        return false;
    }
}
